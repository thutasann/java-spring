import { Categories, SubCatgories, SubSubCatgories, Tags } from '@/dto/types/article.type'
import { useFetchQuery } from './use-query'

/** get categories */
export function useCategories() {
  const { data, isLoading, refetch } = useFetchQuery<Categories[]>(
    '/categories',
    {},
    {
      queryKey: ['/categories'],
      staleTime: 1000 * 60 * 2, // 2 minutes
    },
  )
  return {
    data,
    isLoading,
    refetch,
  }
}

/** get single category */
export function useCategory(_id: string) {
  const { data, isLoading } = useFetchQuery<Categories>(
    `/categories/${_id}`,
    {},
    {
      enabled: !!_id,
      queryKey: ['/categories', _id],
    },
  )
  return {
    data,
    isLoading,
  }
}

/** get sub-categories */
export function useSubCategories() {
  const { data, isLoading, refetch } = useFetchQuery<SubCatgories[]>(
    '/sub-categories',
    {},
    {
      queryKey: ['/sub-categories'],
      staleTime: 1000 * 60 * 2, // 2 minutes
    },
  )
  return {
    data,
    isLoading,
    refetch,
  }
}

/** get single subcategory */
export function useSubCategory(_id: string) {
  const { data, isLoading, refetch } = useFetchQuery<SubCatgories>(
    `/sub-categories/${_id}`,
    {},
    {
      enabled: !!_id,
      queryKey: ['/sub-categories', _id],
    },
  )
  return {
    data,
    isLoading,
    refetch,
  }
}

/** get sub-sub categories */
export function useSubSubCategories() {
  const { data, isLoading, refetch } = useFetchQuery<SubSubCatgories[]>(
    `/sub-sub-categories`,
    {},
    {
      queryKey: ['/sub-sub-categories'],
      staleTime: 1000 * 60 * 2, // 2 minutes
    },
  )
  return {
    data,
    isLoading,
    refetch,
  }
}

/** get single sub subcategory */
export function useSubSubCategory(_id: string) {
  const { data, isLoading, refetch } = useFetchQuery<SubSubCatgories>(
    `/sub-sub-categories/${_id}`,
    {},
    {
      enabled: !!_id,
      queryKey: ['/sub-sub-categories', _id],
    },
  )
  return {
    data,
    isLoading,
    refetch,
  }
}

/** get tags */
export function useTags() {
  const { data, isLoading, refetch } = useFetchQuery<Tags[]>(
    `/tags`,
    {},
    {
      queryKey: ['/tags'],
      staleTime: 1000 * 60 * 2, // 2 minutes
    },
  )
  return {
    data,
    isLoading,
    refetch,
  }
}

/** get signle tag */
export function useTag(_id: string) {
  const { data, isLoading, refetch } = useFetchQuery<Tags>(
    `/tags/${_id}`,
    {},
    {
      enabled: !!_id,
      queryKey: ['/tags', _id],
    },
  )
  return {
    data,
    isLoading,
    refetch,
  }
}
