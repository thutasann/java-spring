import * as z from 'zod'

/** Business Form Schema */
export const businessFormSchema = z.object({
  name: z.string(),
  address: z.string(),
  phone: z.string(),
  description: z.string(),
  image: z.any(),
  website: z.string(),
  subSubCategory: z.string(),
})
export type BusinessFormValue = z.infer<typeof businessFormSchema>
