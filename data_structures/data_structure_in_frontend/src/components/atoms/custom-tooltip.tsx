import { Tooltip, TooltipContent, TooltipProvider, TooltipTrigger } from '@/components/ui/tooltip'
import { cn } from '@/lib/utils'
import React from 'react'

interface ICustomTooltip {
  children: React.ReactNode
  text: React.ReactNode
  side?: 'top' | 'right' | 'bottom' | 'left'
  onClick?: () => void
  disabled?: boolean
  className?: string
}

/**
 * Custom Tooltip component
 */
function CustomTooltip({ children, text, side, onClick, disabled, className }: ICustomTooltip) {
  return (
    <TooltipProvider>
      <Tooltip delayDuration={50}>
        <TooltipTrigger
          onClick={onClick}
          aria-label='tooltip'
          disabled={disabled}
          role='button'
          className={cn('disabled:cursor-not-allowed', className)}
        >
          {children}
        </TooltipTrigger>
        {!disabled && <TooltipContent side={side}>{text}</TooltipContent>}
      </Tooltip>
    </TooltipProvider>
  )
}

export default CustomTooltip
