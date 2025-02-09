import { IUser } from '@/dto/types/user.type'
import { atom } from 'recoil'

export const detaulAuthState: IUser = {
  _id: '',
  name: '',
  email: '',
  password: '',
  dateOfBirth: '',
  gender: '',
  photo: '',
  country: '',
  lastLoggedIn: '',
  bio: '',
  role: 'user',
  isVerified: false,
}

/**
 * Authenticated User State
 */
export const AuthUserState = atom<IUser | null>({
  key: 'AuthUserState',
  default: null,
})
