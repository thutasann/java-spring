/** base schema type */
type BaseSchema = {
  createdAt: string
  updatedAt: string
}

/** base image */
type BaseImage = string | File | null

/** created by */
type CreatedBy =
  | {
      _id: string
      name: string
      email: string
    }
  | string
