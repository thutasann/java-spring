export type RoleProps = 'user' | 'admin' | 'author' | 'team'
export type CookieKeysProps = 'accessToken' | 'refreshToken'

/** User Interface */
export interface IUser extends Partial<BaseSchema> {
  _id: string
  name: string
  email: string
  password: string
  dateOfBirth: string
  gender: string
  photo: string
  country: string
  lastLoggedIn: string
  isVerified: boolean
  bio: string
  role: RoleProps
}

export interface ILoginResponse {
  tokens?: {
    accessToken: string
    refreshToken: string
  }
  user?: IUser
}
