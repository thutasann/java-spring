'use client'

import Image from 'next/image'
import React from 'react'

function AuthSidebar() {
  return (
    <div className='relative hidden h-full flex-col bg-muted p-10 text-white dark:border-r lg:flex'>
      <div className='absolute inset-0 bg-zinc-900' />
      <div className='relative z-20 flex items-center text-lg font-medium'>
        <Image src='/light-logo.png' width={30} height={30} alt='logo' />
      </div>
      <div className='relative z-20 mt-auto'>
        <span>{new Date().getFullYear()} &copy; Asia Reviewer.</span>
      </div>
    </div>
  )
}

export default AuthSidebar
