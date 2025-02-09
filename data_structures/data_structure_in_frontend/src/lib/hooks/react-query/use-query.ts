import client from '@/lib/api/client'
import { useMutation, useQuery, type UseMutationOptions, type UseQueryOptions } from '@tanstack/react-query'
import { useCallback, useRef, useState } from 'react'

/**
 * Hook to Fetch Data
 * @description This hook will be used to fetch REST API for the Entire app
 */
export function useFetchQuery<TData = any>(
  url: string,
  $config?: IRequest & { key?: string[] | any[] },
  options?: UseQueryOptions<IResponse<TData>, ResponseError, IResponse<TData>, any[]>,
) {
  const { key, ...config } = $config || {}
  return useQuery({
    queryKey: key ? key : [url],
    queryFn: ({ queryKey }) => client<TData>(url, { method: 'GET', ...config }),
    ...options,
  })
}

/**
 * Hook to Mutate Data
 * @description This hook will be used to mutate REST API for the Entire app
 */
export function useMutateQuery<TData = any>(
  options?: UseMutationOptions<IResponse<TData>, ResponseError, IRequest<TData>, unknown>,
) {
  return useMutation({
    mutationFn: ({ url = '', ...config }: IRequest<TData>) =>
      client<TData>(url, { method: 'POST', ...config, showLoading: config?.showLoading }),
    ...options,
  })
}

/**
 * Hook for file upload
 * @description This hook will be used to File Upload for the Entire app
 */
export function useFileUploadQuery<TData = any>(
  options?: UseMutationOptions<IResponse<TData>, ResponseError, IRequest, unknown>,
) {
  const [progress, setProgress] = useState(0)
  const abortControllerRef = useRef<AbortController | null>(null)

  // @ts-ignore
  const mutation = useMutation(({ url = '', ...config }: IRequest) => {
    abortControllerRef.current = new AbortController()
    return client<TData>(url, {
      method: 'POST',
      type: 'multipart',
      onUploadProgress: (e) => {
        setProgress(Math.round((e.loaded * 100) / e.total!))
      },
      ...config,
    })
  }, options)

  const reset = useCallback(() => {
    abortControllerRef.current?.abort()
    mutation.reset()
    setProgress(0)
  }, [mutation])

  return { ...mutation, progress, abortControllerRef, reset }
}
