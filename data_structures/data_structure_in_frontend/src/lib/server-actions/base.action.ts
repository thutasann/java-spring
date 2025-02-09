import { RequestInit } from 'next/dist/server/web/spec-extension/request'
import { cookies } from 'next/headers'

const environment = process.env.NODE_ENV
const BASE_URL =
  environment === 'production' ? process.env.NEXT_PUBLIC_PROD_API_ENDPOINT : process.env.NEXT_PUBLIC_DEV_API_ENDPOINT
console.log('BASE_URL', BASE_URL)

/**
 * Extended Server Action
 * @description This is the extended abstract to handle server actions
 */
export async function fetchData<T>(
  endpoint: string,
  options?: RequestInit,
  params?: Record<string, string | number | boolean>,
  payload?: Record<string, any>,
): Promise<IServerActionResponse<T>> {
  const token = cookies().get('accessToken')

  try {
    const url = `${BASE_URL}${endpoint}${buildQueryString(params)}`

    const fetchOptions: RequestInit = {
      ...options,
      headers: {
        'Content-Type': 'application/json',
        ...(options?.headers || {}),
        Authorization: `Bearer ${token?.value}`,
      },
      body: payload ? JSON.stringify(payload) : undefined,
    }

    const res = await fetch(url, fetchOptions)

    if (!res.ok) {
      throw new Error(`Error: ${res.status} ${res.statusText}`)
    }

    const data: IServerActionResponse<T> = await res.json()
    return data
  } catch (error) {
    console.error(`Failed to fetch data from ${endpoint}`, error)
    throw error
  }
}

/** @private buiild query strign */
function buildQueryString(params?: Record<string, string | number | boolean>): string {
  if (!params) return ''
  const queryString = new URLSearchParams(params as any).toString()
  return queryString ? `?${queryString}` : ''
}
