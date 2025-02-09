'use server'

import { Categories } from '@/dto/types/article.type'
import { fetchData } from './base.action'

/** get categories */
export async function getCategories() {
  return await fetchData<Categories[]>('categories', {
    next: { revalidate: 60 }, // revalidate every 60s
  })
}

/** get single category */
export async function getCategory(id: string) {
  return await fetchData<Categories>(`categories/${id}`, {
    next: {
      revalidate: 3600,
    },
  })
}
