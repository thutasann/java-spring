import {
  Breadcrumb,
  BreadcrumbItem,
  BreadcrumbList,
  BreadcrumbPage,
  BreadcrumbSeparator,
} from '@/components/ui/breadcrumb'
import { ChevronRightIcon } from 'lucide-react'
import Link from 'next/link'
import { Fragment } from 'react'

export type BreadcrumbItemProps = {
  title: string
  link: string
}

export function Breadcrumbs({ items }: { items: BreadcrumbItemProps[] }) {
  return (
    <Breadcrumb className='px-8'>
      <BreadcrumbList>
        {items.map((item, index) => (
          <Fragment key={item.title}>
            {index !== items.length - 1 && (
              <BreadcrumbItem>
                <Link className='hover:underline' href={item.link}>
                  {item.title}
                </Link>
              </BreadcrumbItem>
            )}
            {index < items.length - 1 && (
              <BreadcrumbSeparator>
                <ChevronRightIcon />
              </BreadcrumbSeparator>
            )}
            {index === items.length - 1 && <BreadcrumbPage className='text-sm'>{item.title}</BreadcrumbPage>}
          </Fragment>
        ))}
      </BreadcrumbList>
    </Breadcrumb>
  )
}
