import axios from 'axios'

const environment = process.env.NODE_ENV
const BASE_URL =
  environment === 'production' ? process.env.NEXT_PUBLIC_PROD_API_ENDPOINT : process.env.NEXT_PUBLIC_DEV_API_ENDPOINT

/**
 * Axios Client
 * @description This is the REST API base client
 */
const axiosClient = axios.create({
  baseURL: BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
})

export { axiosClient }
