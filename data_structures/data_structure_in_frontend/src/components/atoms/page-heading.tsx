'use client'

import { Plus } from 'lucide-react'
import { useRouter } from 'next13-progressbar'
import { Fragment } from 'react'
import { Button } from '../ui/button'
import { Separator } from '../ui/separator'
import { BreadcrumbItemProps, Breadcrumbs } from './breadcrumb'

interface IPageHeading {
  title: string
  description: string
  addRoute?: string
  addOnClick?: () => void
  breadcrumbItems: BreadcrumbItemProps[]
}

export function PageHeading({ title, description, addRoute, addOnClick, breadcrumbItems }: IPageHeading) {
  const router = useRouter()

  return (
    <div className='mb-8 bg-card'>
      <Breadcrumbs items={breadcrumbItems!} />

      <div className='mb-8 mt-2 flex items-start justify-between px-8'>
        <div className='space-y-1.5'>
          <h2 className='text-3xl font-extrabold tracking-tight'>{title}</h2>
          <p className='text-sm text-muted-foreground'>{description}</p>
        </div>
        {addRoute && (
          <Button className='text-xs md:text-sm' onClick={() => router.push(addRoute)}>
            <Plus className='mr-2 h-4 w-4' /> Add New
          </Button>
        )}
        {addOnClick && (
          <Button className='text-xs md:text-sm' onClick={addOnClick}>
            <Plus className='mr-2 h-4 w-4' /> Add New
          </Button>
        )}
      </div>
      <Separator />
    </div>
  )
}
