import qs from 'qs'
import { checkToken } from '../utils'
import { axiosClient } from './base'

/**
 * API Client 🚀
 * @description This API Client is used for Fetching, Mutation Data along with ReactQuery for REST APIs.
 * @description This one is rarely needed to touch cauz this is already setup with Backend
 */
export default async function client<T = any>(url: string, config?: IRequest): Promise<IResponse<T>> {
  const { type, payload, method = 'GET', ...rest } = config || {}
  const { token } = checkToken()

  rest.headers = rest.headers || {
    'Content-Type': 'application/json; charset=UTF-8',
    Accept: 'application/json',
    Authorization: `Bearer ${token}`,
  }

  if (rest.headers) {
    switch (type) {
      case 'csv':
        rest.headers['Accept'] = 'application/csv'
        rest.responseType = 'blob'
        break

      case 'form':
        rest.headers['Content-Type'] = 'application/x-www-form-urlencoded'
        break

      case 'multipart':
        // rest.headers['Content-Type'] = 'multipart/form-data'
        delete rest.headers['Content-Type']
        break
      default:
        rest.headers['Content-Type'] = 'application/json'
    }
  }

  return axiosClient({
    url,
    method,
    ...rest,
    [method === 'GET' ? 'params' : 'data']: payload,
    paramsSerializer: function (params) {
      return qs.stringify(params, { arrayFormat: 'repeat' })
    },
  })
    .then((res) => {
      const response: IResponse<T> = {
        meta: res.data.meta,
        body: res.data.body,
        data: res.data.body,
      }
      return Promise.resolve(response)
    })
    .catch((err) => Promise.reject(err))
}
