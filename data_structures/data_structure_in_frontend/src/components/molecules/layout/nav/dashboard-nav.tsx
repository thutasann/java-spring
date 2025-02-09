'use client';

import CustomTooltip from '@/components/atoms/custom-tooltip';
import { Icons } from '@/components/atoms/icons';
import { Accordion, AccordionContent, AccordionItem, AccordionTrigger } from '@/components/ui/accordion';
import { NavItemWithOptionalChildren } from '@/dto/types/ui.type';
import { cn } from '@/lib/utils';
import { SidebarState } from '@/providers/recoil/sidebar-state';
import Link from 'next/link';
import { usePathname } from 'next/navigation';
import { Dispatch, SetStateAction } from 'react';
import { useRecoilValue } from 'recoil';

interface DashboardNavProps {
  items: NavItemWithOptionalChildren[];
  setOpen?: Dispatch<SetStateAction<boolean>>;
  isMobileNav?: boolean;
}

export function DashboardNav({ items, setOpen, isMobileNav = false }: DashboardNavProps) {
  const path = usePathname();
  const { isMinimized } = useRecoilValue(SidebarState);

  if (!items?.length) return null;

  return (
    <nav className='grid items-start gap-2'>
      {items.map((item, index) => {
        const Icon = Icons[item.icon || 'arrowRight'];

        return item.href ? (
          <NavLink
            key={index}
            item={item}
            path={path}
            setOpen={setOpen}
            Icon={Icon}
            isMobileNav={isMobileNav}
            isMinimized={isMinimized}
          />
        ) : (
          <Accordion type='single' collapsible key={index}>
            <AccordionItem value='item-1' className='border-none'>
              <AccordionTrigger className='rounded-md !py-2 hover:bg-accent hover:text-accent-foreground'>
                <div className='flex items-center gap-2 text-sm font-medium'>
                  <Icon className={`ml-3 size-5 flex-none`} />
                  {isMobileNav || (!isMinimized && !isMobileNav) ? (
                    <span className='mr-2 truncate'>{item.title}</span>
                  ) : (
                    ''
                  )}
                </div>
              </AccordionTrigger>
              <AccordionContent>
                {item.items?.map((item, index) => {
                  const Icon = Icons[item.icon || 'arrowRight'];
                  return (
                    <div key={index}>
                      <NavLink
                        item={item}
                        path={path}
                        setOpen={setOpen}
                        Icon={Icon}
                        isMobileNav={isMobileNav}
                        isMinimized={isMinimized}
                      />
                    </div>
                  );
                })}
              </AccordionContent>
            </AccordionItem>
          </Accordion>
        );
      })}
    </nav>
  );
}

function NavLink({
  item,
  path,
  setOpen,
  Icon,
  isMobileNav,
  isMinimized,
}: {
  item: NavItemWithOptionalChildren;
  path: string;
  setOpen?: Dispatch<SetStateAction<boolean>>;
  Icon: any;
  isMobileNav: boolean;
  isMinimized: boolean;
}) {
  if (isMinimized) {
    return (
      <CustomTooltip text={item.title} side='right' className='w-full'>
        <Link
          href={item.disabled ? '/' : item.href!}
          className={cn(
            'flex items-center gap-2 overflow-hidden rounded-md py-2 text-sm font-medium hover:bg-accent hover:text-accent-foreground',
            path === item.href ? 'bg-accent' : 'transparent',
            item.disabled && 'cursor-not-allowed opacity-80',
          )}
          onClick={() => {
            if (setOpen) setOpen(false);
          }}
        >
          <div className='flex items-center gap-2'>
            <Icon className={`ml-3 size-5 flex-none`} />
            {isMobileNav || (!isMinimized && !isMobileNav) ? <span className='mr-2 truncate'>{item.title}</span> : ''}
          </div>
        </Link>
      </CustomTooltip>
    );
  } else {
    return (
      <Link
        href={item.disabled ? '/' : item.href!}
        className={cn(
          'flex items-center gap-2 overflow-hidden rounded-md py-2 text-sm font-medium hover:bg-accent hover:text-accent-foreground',
          path === item.href ? 'bg-accent' : 'transparent',
          item.disabled && 'cursor-not-allowed opacity-80',
        )}
        onClick={() => {
          if (setOpen) setOpen(false);
        }}
      >
        <div className='flex items-center gap-2'>
          <Icon className={`ml-3 size-5 flex-none`} />
          {isMobileNav || (!isMinimized && !isMobileNav) ? <span className='mr-2 truncate'>{item.title}</span> : ''}
        </div>
      </Link>
    );
  }
}
