'use client'

import { Next13ProgressBar } from 'next13-progressbar'

/**
 * TopLoader For when Navigating the Pages
 * @description This component is used for the entire app to navigate the project when navigating SSR pages
 */
function TopLoader() {
  return (
    <Next13ProgressBar
      height='1.5px'
      color='#007bff'
      startPosition={0.4}
      stopDelayMs={100}
      nonce='next-TopLoader'
      options={{
        easing: 'ease-in-out',
        showSpinner: false,
      }}
      showOnShallow
    />
  )
}

export default TopLoader
