'use client';

import { Avatar, AvatarFallback } from '@/components/ui/avatar';
import { Button } from '@/components/ui/button';
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuGroup,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuShortcut,
  DropdownMenuTrigger,
} from '@/components/ui/dropdown-menu';
import { PageEndpoints } from '@/lib/constants/page-endpoint';
import { getFirstLetter, removeAuthCookies } from '@/lib/utils';
import { AuthUserState } from '@/providers/recoil/auth-state';
import { MapPin } from 'lucide-react';
import { useRouter } from 'next/navigation';
import { useRecoilState } from 'recoil';

export function UserNav() {
  const router = useRouter();
  const [authUser, setAuthUser] = useRecoilState(AuthUserState);

  const handleLogout = () => {
    removeAuthCookies();
    setAuthUser(null);
    router.push(PageEndpoints.index);
    router.refresh();
  };

  return (
    <div className='flex items-center gap-3'>
      <div className='flex items-center gap-1'>
        <MapPin width={20} height={20} />
        <span className='text-[14px] font-normal'>Singapore</span>
      </div>
    </div>
  );
}
