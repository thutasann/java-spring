import { Spinner } from '@/components/ui/loader'
import React from 'react'

function FullPageLoader() {
  return (
    <div className='fixed left-0 top-0 z-[999] flex h-[100vh] w-full flex-col items-center justify-center overflow-y-hidden border bg-background'>
      <Spinner />
    </div>
  )
}

export default FullPageLoader
