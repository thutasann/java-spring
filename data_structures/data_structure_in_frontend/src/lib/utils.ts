import { CookieKeysProps } from '@/dto/types/user.type'
import { type ClassValue, clsx } from 'clsx'
import cookie from 'js-cookie'
import { twMerge } from 'tailwind-merge'

/** Tailwind class names merge */
export const cn = (...inputs: ClassValue[]) => {
  return twMerge(clsx(inputs))
}

/**
 * Format server date to "23/07/2024"
 * @example `2024-07-23T05:23:01.611Z` to `23/07/2024`
 */
export const formatDate = (dateString: string): string => {
  const date = new Date(dateString)
  const day = String(date.getDate()).padStart(2, '0')
  const month = String(date.getMonth() + 1).padStart(2, '0') // Months are zero-based
  const year = date.getFullYear()
  return `${day}/${month}/${year}`
}

/**
 * Format time zone date string to "23/07/2024"
 * @example Sat Aug 10 2024 00:00:00 GMT+0800 (Singapore Standard Time) to 'dd/mm/yyyy'
 */
export const formatTimezoneDate = (dateString: string): string => {
  const date = new Date(dateString)

  const day = String(date.getDate()).padStart(2, '0')
  const month = String(date.getMonth() + 1).padStart(2, '0')
  const year = date.getFullYear()

  const formattedDate = `${day}/${month}/${year}`
  return formattedDate
}

/** Slugify String  */
export const slugify = (text: string) => {
  if (!text) return ''
  return text
    .toString()
    .toLowerCase()
    .trim()
    .replace(/\s+/g, '-') // Replace spaces with -
    .replace(/[^\w\-]+/g, '') // Remove all non-word chars
    .replace(/\-\-+/g, '-') // Replace multiple - with single -
    .replace(/^-+/, '') // Trim - from start of text
    .replace(/-+$/, '') // Trim - from end of text
}

/** Get First Ltter */
export const getFirstLetter = (str: string): string => {
  if (!str) {
    return 'undefined'
  }
  return str.charAt(0)
}

/** truncate fn */
export const truncate = (str: string, maxLength: number): string => {
  if (str.length <= maxLength) {
    return str
  }
  return str.slice(0, maxLength) + '...'
}

/** generate random password */
export const generateRandomPassword = (length: number): string => {
  const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+[]{}|;:,.<>?'
  let password = ''

  for (let i = 0; i < length; i++) {
    const randomIndex = Math.floor(Math.random() * characters.length)
    password += characters[randomIndex]
  }

  return password
}

/** fn to check the image is valid or not */
export const isValidImage = (url: string) => {
  try {
    fetch(url).then((response) => {
      return response.ok && response.headers.get('content-type')?.includes('image')
    })
    return true
  } catch {
    return false
  }
}

/** get fallback text */
export const getFallbackText = (text: string) => {
  return text ? text.charAt(0).toUpperCase() : 'N/A'
}

/**
 * Localstorage Get, Set, Clear, Remove
 */
export const storage = {
  get: <T>(name: string): T | null => {
    const value = localStorage.getItem(name)
    if (!value) return null

    const firstLetter = value[0]
    if (firstLetter === '[' || firstLetter === '{') {
      return JSON.parse(value)
    }
    return value as T
  },

  set: <T>(name: string, value: T) => {
    const newValue = JSON.stringify(value)
    localStorage.setItem(name, newValue)
  },

  clear: () => localStorage.clear(),

  remove: (name: string) => {
    localStorage.removeItem(name)
  },
}

/** set cookie */
export const setCookie = (key: CookieKeysProps, value: string): void => {
  cookie.set(key, value, { expires: 1 })
}

/** remove cookie */
export const removeCookie = (key: CookieKeysProps): void => {
  cookie.remove(key)
}

/** get cookie */
export const getCookie = (key: CookieKeysProps): string | undefined => {
  return cookie.get(key)
}

/** set auth related cookies */
export const setAuthCookies = (values: string[]): void => {
  setCookie('accessToken', values[0])
  setCookie('refreshToken', values[1])
}

/** check there is accessToken or not */
export const checkToken = (): { token: string } => {
  const token = getCookie('accessToken') || ''
  return {
    token,
  }
}

/** remove auth related cookies */
export const removeAuthCookies = (): void => {
  removeCookie('accessToken')
  removeCookie('refreshToken')
}
