import * as z from 'zod'

/** Login Form Schema */
export const authFormSchema = z.object({
  email: z.string().email({ message: 'Enter a valid email address' }),
  password: z.string({ message: 'Enter a valid password' }),
})
export type AuthFormValue = z.infer<typeof authFormSchema>

/** Account Form Schema */
export const accountFormSchema = z.object({
  name: z.string(),
  email: z.string().email({ message: 'Enter a valid email address' }).optional(),
  dateOfBirth: z.string().optional(),
  gender: z.string().optional(),
  photo: z.any(),
  country: z.string().optional(),
  bio: z.string().optional(),
  role: z.string().optional(),
})
export type AccountFormValue = z.infer<typeof accountFormSchema>

/** Author Form Schema */
export const teamFormSchema = z.object({
  name: z.string(),
  email: z.string().email({ message: 'Enter a valid email address' }),
  password: z.string().optional(),
  dateOfBirth: z.string().optional(),
  gender: z.string().optional().default('male'),
  photo: z.string().optional(),
  country: z.string().optional(),
  bio: z.string().optional(),
  role: z.string().default('author'),
})
export type TeamFormValue = z.infer<typeof teamFormSchema>

export const PREFER_NOT_TO_SAY = 'prefer-not-to-say'
