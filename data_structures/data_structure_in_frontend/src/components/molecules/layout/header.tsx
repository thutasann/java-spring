import { cn } from '@/lib/utils'
import { MobileSidebar } from './nav/mobile-sidebar'
import ThemeToggle from './theme-toggle'
import { UserNav } from './user-nav'

export default function Header() {
  return (
    <header className='sticky inset-x-0 top-0 w-full bg-card'>
      <nav className='flex items-center justify-between px-4 py-2 md:justify-end'>
        <div className={cn('block md:!hidden')}>
          <MobileSidebar />
        </div>
        <div className='flex items-center gap-2'>
          <UserNav />
          <ThemeToggle />
        </div>
      </nav>
    </header>
  )
}
