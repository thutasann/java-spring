import { Business } from './business.type'
import { IUser } from './user.type'

/** Categories */
export interface Categories extends Partial<BaseSchema> {
  _id: string
  name: string
  description: string
  slug?: string
  image?: BaseImage
  createdBy?: CreatedBy
  subCategories: SubCatgories[]
}

/** Sub Categories */
export interface SubCatgories extends Partial<BaseSchema> {
  _id: string
  name: string
  description: string
  slug?: string
  parentCategory?: string | Categories
  subSubCategories?: SubSubCatgories[]
}

/** Sub Sub Categoreis */
export interface SubSubCatgories extends Partial<BaseSchema> {
  _id: string
  name: string
  description: string
  slug: string
  parentSubCategory: string | SubCatgories
  businesses: string[] | Business[]
}

/** Tags */
export interface Tags extends Partial<BaseSchema> {
  _id: string
  name: string
  description: string
  slug: string
  articles: string[] | Articles[]
  createdBy?: CreatedBy
}

/** Medias */
export interface Media extends Partial<BaseSchema> {
  _id: string
  fileName: string
  fileType: string
  fileSize: string
  url: string
  description: string
  uploadedDate: string | Date
  uploadedBy: Partial<IUser>
  altText: string
  title: string
}

/** Articles */
export interface Articles extends Partial<BaseSchema> {}
