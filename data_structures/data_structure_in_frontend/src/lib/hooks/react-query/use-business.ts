import { Business } from '@/dto/types/business.type'
import { useFetchQuery } from './use-query'

/** get businesses */
export function useBusinesses() {
  const { data, isLoading, refetch } = useFetchQuery<Business[]>(
    '/business',
    {},
    {
      queryKey: ['/business'],
      staleTime: 1000 * 60 * 2, // 2 minutes
    },
  )
  return {
    data,
    isLoading,
    refetch,
  }
}

/** get single business */
export function useBusiness(_id: string) {
  const { data, isLoading } = useFetchQuery<Business>(
    `/business/${_id}`,
    {},
    {
      enabled: !!_id,
      queryKey: ['/business', _id],
    },
  )
  return {
    data,
    isLoading,
  }
}
