'use client';

import { navItems } from '@/lib/constants/nav-items';
import { cn } from '@/lib/utils';
import { SidebarState } from '@/providers/recoil/sidebar-state';
import { ChevronLeft } from 'lucide-react';
import { useTheme } from 'next-themes';
import Image from 'next/image';
import React from 'react';
import { useRecoilState } from 'recoil';
import { DashboardNav } from './dashboard-nav';

type SidebarProps = {
  className?: string;
};

export default function Sidebar({ className }: SidebarProps) {
  const [{ isMinimized }, setSidebarState] = useRecoilState(SidebarState);

  const handleToggle = () => {
    setSidebarState((prev) => {
      return {
        isMinimized: !prev.isMinimized,
      };
    });
  };

  return (
    <aside
      className={cn(
        `relative z-[999] hidden h-screen flex-none transform-gpu border-r bg-card transition-[width] duration-500 md:block`,
        !isMinimized ? 'w-72' : 'w-[72px]',
        className,
      )}
    >
      <ChevronLeft
        width={30}
        height={30}
        className={cn(
          'absolute -right-3 top-12 z-50 cursor-pointer rounded-full border bg-background p-1 text-2xl text-foreground hover:opacity-85',
          isMinimized && 'rotate-180',
        )}
        onClick={handleToggle}
      />
      <div className='space-y-4 py-4'>
        <div className='px-3 py-2'>
          <div className='px-3'>
            <h1>DSA</h1>
          </div>
          <div className='mt-6 space-y-1'>
            <DashboardNav items={navItems} />
          </div>
        </div>
      </div>
    </aside>
  );
}
