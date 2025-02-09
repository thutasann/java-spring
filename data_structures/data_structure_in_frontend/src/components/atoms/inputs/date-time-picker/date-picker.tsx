import { Calendar } from '@/components/ui/calendar'
import { Popover, PopoverContent, PopoverTrigger } from '@/components/ui/popover'
import * as React from 'react'

interface IDatePicker {
  date: Date
  setDate: React.Dispatch<React.SetStateAction<Date | undefined>>
  /**
   * Date picker trigger children
   */
  children: React.ReactNode
}

/**
 * Single DatePicker
 */
function DatePicker({ date, setDate, children }: IDatePicker) {
  return (
    <Popover>
      <PopoverTrigger asChild>{children}</PopoverTrigger>
      <PopoverContent align='start'>
        <Calendar mode='single' selected={date} onSelect={setDate} initialFocus />
      </PopoverContent>
    </Popover>
  )
}

export default DatePicker
