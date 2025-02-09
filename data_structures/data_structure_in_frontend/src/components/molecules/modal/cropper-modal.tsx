import { Button } from '@/components/ui/button'
import { Dialog, DialogContent } from '@/components/ui/dialog'
import { Slider } from '@/components/ui/slider'
import { cn } from '@/lib/utils'
import { DialogTitle } from '@radix-ui/react-dialog'
import imageCompression from 'browser-image-compression'
import 'cropperjs/dist/cropper.css'
import { ImageIcon } from 'lucide-react'
import React, { useState } from 'react'
import Cropper from 'react-cropper'

interface IImageCropperModal {
  title: string
  onClose: () => void
  open: boolean
  onSave: (file: any) => void
  file: any
  initialAspectRatio: number
  aspectRatio: number
  src: any
  autoCropArea?: number
  className?: string
}

function ImageCropperModal({
  title,
  onClose,
  open,
  onSave,
  file,
  initialAspectRatio,
  aspectRatio,
  src,
  autoCropArea = 0.715,
  className,
}: IImageCropperModal) {
  const [cropper, setCropper] = useState<any>()
  const [zoomValue, setZoomValue] = useState<number>(0.01)

  const getCropImage = async () => {
    const data = cropper
      .getCroppedCanvas({
        maxWidth: Math.min(cropper.imageData.naturalWidth, 3840),
        maxHeight: Math.min(cropper.imageData.naturalHeight, 2160),
        fillColor: '#fff',
        imageSmoothingEnabled: true,
        imageSmoothingQuality: 'high',
      })
      .toDataURL('image/jpeg')

    const blob = await (await fetch(data)).blob()
    const croppedFile = new File([blob], file.name, { type: file.type, lastModified: file.lastModified })
    const sizeInMb = croppedFile.size / 1024 / 1024

    if (sizeInMb > 1) {
      const options = {
        maxSizeMB: 1,
        useWebWorker: true,
        maxWidthOrHeight: Math.min(cropper.imageData.naturalWidth, 3840),
      }
      try {
        const compressedFileBlob = await imageCompression(croppedFile, options)
        const compressedFile = new File([compressedFileBlob], file.name, {
          type: file.type,
          lastModified: file.lastModified,
        })
        onSave(compressedFile)
      } catch (error) {
        onSave(croppedFile)
      }
    } else {
      onSave(croppedFile)
    }
  }

  return (
    <Dialog onOpenChange={onClose} open={open}>
      <DialogContent>
        <DialogTitle className='text-text-1 text-center text-base font-bold'>{title}</DialogTitle>
        <Cropper
          src={src}
          viewMode={1}
          minCropBoxHeight={10}
          minCropBoxWidth={10}
          guides={false}
          autoCropArea={autoCropArea}
          zoomTo={zoomValue}
          restore={true}
          aspectRatio={aspectRatio}
          className={cn('react-cropper overflow-hidden', className)}
          initialAspectRatio={initialAspectRatio}
          onInitialized={(instance) => setCropper(instance)}
        />
        <div className='flex items-center gap-2'>
          <ImageIcon />
          <Slider defaultValue={[zoomValue]} onValueChange={(val) => setZoomValue(val[0])} max={100} step={2} />
          <ImageIcon />
        </div>

        <div className='mt-3 flex items-end justify-end gap-2'>
          <Button variant='link' onClick={onClose}>
            Cancel
          </Button>
          <Button variant='default' onClick={getCropImage}>
            Done
          </Button>
        </div>
      </DialogContent>
    </Dialog>
  )
}

export default ImageCropperModal
