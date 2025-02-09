import { Select, SelectContent, SelectGroup, SelectItem, SelectTrigger, SelectValue } from '@/components/ui/select'
import { cn } from '@/lib/utils'
import React from 'react'

export interface ISelectboxOptions {
  value: string
  label: string | React.ReactNode
}

export interface ISelectBox {
  options: Array<ISelectboxOptions>
  value: string | null
  onChange: (val: string) => void
  label?: string
  name: string
  placeholder?: React.ReactNode
  disabled?: boolean
  triggerClassNames?: string
  containerClassNames?: string
  defaultValue?: string
  hideCheck?: boolean
  ghost?: boolean
  maxHeight?: boolean
  align?: 'center' | 'end' | 'start'
}

/**
 * Select box component
 * @description Example usage can be found at `BadgeFormModal.tsx`
 */
function SelectBox({
  options,
  value,
  onChange,
  label,
  name,
  placeholder = 'Select',
  maxHeight,
  disabled,
  triggerClassNames,
  defaultValue,
  containerClassNames,
  align,
}: ISelectBox) {
  return (
    <div className={cn('flex w-full flex-col items-start gap-1', containerClassNames)}>
      {label && (
        <label className='text-text-1 text-sm font-[500]' htmlFor={name}>
          {label}
        </label>
      )}
      <Select disabled={disabled} value={value ? value : ''} onValueChange={onChange} defaultValue={defaultValue}>
        <SelectTrigger className={cn('w-full truncate whitespace-nowrap', triggerClassNames)}>
          <SelectValue placeholder={placeholder}>
            {!value ? (
              <span className='placeholder'>{placeholder}</span>
            ) : (
              options.find((opt) => opt.value === value)?.label
            )}
          </SelectValue>
        </SelectTrigger>
        <SelectContent className={cn('shadow-lg')} align={align}>
          <SelectGroup
            className={cn('overflow-y-auto', options.length === 0 ? 'h-fit' : maxHeight ? 'h-[149px]' : 'h-fit')}
          >
            {options.map((option) => (
              <SelectItem key={option.value} value={option.value}>
                {option.label}
              </SelectItem>
            ))}
          </SelectGroup>
        </SelectContent>
      </Select>
    </div>
  )
}

export default SelectBox
