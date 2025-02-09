import { atom } from 'recoil'

export interface ISidebarState {
  isMinimized: boolean
}

export const SidebarState = atom<ISidebarState>({
  key: 'SidebarState',
  default: {
    isMinimized: false,
  },
})
