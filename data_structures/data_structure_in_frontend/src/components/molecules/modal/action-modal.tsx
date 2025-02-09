import { Button } from '@/components/ui/button'
import { Dialog, DialogContent, DialogFooter, DialogHeader, DialogTitle } from '@/components/ui/dialog'
import { cn } from '@/lib/utils'
import { DialogDescription } from '@radix-ui/react-dialog'
import React from 'react'

interface IActionModal {
  isOpen: boolean
  onClose: () => void
  title: string
  titleAlign?: 'left' | 'center'
  children: React.ReactNode
  onConfirm: () => void
  confirmText: string
  confirmType: 'default' | 'destructive' | 'outline' | 'secondary'
  onCancel?: () => void
  cancelText?: string
  disableButton?: boolean
  className?: string
  btnClassName?: string
}

/**
 * Action Modal for Forms
 */
function ActionModal({
  isOpen,
  onClose,
  title,
  titleAlign = 'left',
  children,
  onConfirm,
  confirmText,
  confirmType,
  onCancel,
  cancelText,
  disableButton,
  className,
  btnClassName,
}: IActionModal) {
  return (
    <Dialog open={isOpen} onOpenChange={onClose}>
      <DialogContent className={cn('overflow-hidden !p-0', className)}>
        <DialogHeader className='border-b px-6 py-6'>
          <DialogTitle className={`text-lg text-${titleAlign}`}>{title}</DialogTitle>
        </DialogHeader>
        <DialogDescription asChild>
          <div className='text-text-1 px-6 pb-6'>{children}</div>
        </DialogDescription>
        <DialogFooter className='px-6 pb-6'>
          <div className='flex items-center gap-3'>
            {onCancel ? (
              <Button variant='link' onClick={onCancel}>
                {cancelText || 'Cancel'}
              </Button>
            ) : null}
            <Button variant={confirmType} disabled={disableButton} onClick={onConfirm} className={btnClassName}>
              {confirmText}
            </Button>
          </div>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  )
}

export default ActionModal
