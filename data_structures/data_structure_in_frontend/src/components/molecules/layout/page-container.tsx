import { ScrollArea } from '@/components/ui/scroll-area'
import React, { Fragment } from 'react'

export default function PageContainer({
  children,
  scrollable = false,
}: {
  children: React.ReactNode
  scrollable?: boolean
}) {
  return (
    <Fragment>
      {scrollable ? (
        <ScrollArea className='h-[calc(100dvh-52px)]'>
          <div className='mb-16 h-full'>{children}</div>
        </ScrollArea>
      ) : (
        <div className='h-full w-full'>{children}</div>
      )}
    </Fragment>
  )
}
