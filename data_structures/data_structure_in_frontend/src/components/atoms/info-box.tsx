import { cn } from '@/lib/utils'
import { Info } from 'lucide-react'
import React from 'react'

interface IInfoBox {
  text: string
  className?: string
}

function InfoBox({ text, className }: IInfoBox) {
  return (
    <div
      className={cn(
        'flex w-full items-center gap-2 rounded-md bg-secondary-foreground px-3 py-2 text-background shadow-md',
        className,
      )}
    >
      <Info />
      <span className='text-[14px] font-semibold'>{text}</span>
    </div>
  )
}

export default InfoBox
