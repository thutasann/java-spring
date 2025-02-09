import { AxiosError, AxiosRequestConfig } from 'axios'

declare global {
  /** Request Options */
  type RequestOptions = {
    /** To show Global loading (will be barely used) */
    showLoading?: boolean
    /** Service Type you want to call */
    decodeMethod?: 'decodeString' | 'decodeArray'
  }

  /** Request Type */
  type IRequest<T = any> = Omit<AxiosRequestConfig, 'url'> &
    RequestOptions & {
      url?: string
      type?: 'form' | 'csv' | 'multipart'
      payload?: any
    }

  /** Response Type */
  type IResponse<T = any> = {
    meta: {
      success: boolean
      message: string
      devMessage: string
    }
    body: T
    data: T
  }

  /** Response Error  */
  type ResponseError = AxiosError<{
    success: boolean
    message: string
    devMessage: string
  }>

  /** TODO: Pagination */
  interface Paginated<T> {
    filterCount: number
    hasNextPage: boolean
    hasPrevPage: boolean
    nextPage?: number
    prevPage?: number
    totalCount: number
    totalPages: number
    countPerPage: number
    currentPage: number
    data: T
  }

  /** Custom Request Options */
  type CustomRequestOptions = {
    showLoading?: boolean
  }

  type IServerActionResponse<T = any> = {
    meta: {
      success: boolean
      message: string
      devMessage: string
    }
    body: T
  }
}
