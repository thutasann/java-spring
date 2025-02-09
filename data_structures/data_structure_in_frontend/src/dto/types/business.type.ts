import { SubSubCatgories } from './article.type'

/** Business Type */
export interface Business extends Partial<BaseSchema> {
  _id: string
  name: string
  address: string
  phone: string
  description: string
  image: string
  website: string
  createdBy?: CreatedBy
  subSubCategory: string | SubSubCatgories
}
