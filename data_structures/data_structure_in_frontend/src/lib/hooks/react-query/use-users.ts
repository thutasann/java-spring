import { IUser, RoleProps } from '@/dto/types/user.type'
import { checkToken } from '@/lib/utils'
import { useFetchQuery } from './use-query'

/** authentication check */
export function useAuthCheck() {
  const { token } = checkToken()

  const { data, status, refetch, error, isLoading } = useFetchQuery<IUser>('/users/me', {
    headers: {
      'Content-Type': 'application/json; charset=UTF-8',
      Accept: 'application/json',
      Authorization: `Bearer ${token}`,
    },
  })

  return {
    data,
    status,
    refetch,
    error,
    isLoading,
  }
}

/** users */
export function useUsers(role?: RoleProps) {
  const { data, isLoading, refetch, isRefetching } = useFetchQuery<IUser[]>(
    role ? `/users?role=${role}` : `/users`,
    {},
    {
      staleTime: 1000 * 60 * 2, // 2 minutes
      queryKey: ['users', role],
    },
  )
  return {
    data,
    isLoading,
    refetch,
    isRefetching,
  }
}
