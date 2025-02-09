import * as z from 'zod'

/** Category Form Schema */
export const categoryFormSchema = z.object({
  name: z.string().min(3, { message: 'Enter a valid category name' }),
  slug: z.string({ message: 'Enter a valid category slug' }),
  description: z.string().min(3, { message: 'Enter the description of category' }),
  image: z.any().optional(),
})
export type CategoryFormValue = z.infer<typeof categoryFormSchema>

/** SubCategory Form Schema */
export const subCategoryFormSchema = z.object({
  name: z.string().min(3, { message: 'Enter a valid sub category name' }),
  slug: z.string({ message: 'Enter a valid sub category slug' }),
  description: z.string().min(3, { message: 'Enter the description of sub category' }),
  parentCategory: z.any(),
})
export type SubCategoryFormValue = z.infer<typeof subCategoryFormSchema>

/** SubSub Category Form Schema */
export const subSubCategoryFormSchema = z.object({
  name: z.string().min(3, { message: 'Enter a valid sub category name' }),
  slug: z.string({ message: 'Enter a valid sub category slug' }),
  description: z.string().min(3, { message: 'Enter the description of sub category' }),
  parentSubCategory: z.any(),
})
export type SubSubCategoryFormValue = z.infer<typeof subSubCategoryFormSchema>

/** Tag Form Schema */
export const tagFormSchema = z.object({
  name: z.string().min(3, { message: 'Enter a valid tag name' }),
  slug: z.string({ message: 'Enter a valid tag' }),
  description: z.string().min(3, { message: 'Enter the description of tag' }),
})
export type TagFormValue = z.infer<typeof subCategoryFormSchema>
