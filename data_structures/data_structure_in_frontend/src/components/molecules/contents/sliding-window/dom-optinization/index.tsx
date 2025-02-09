'use client'

import { PageHeading } from '@/components/atoms/page-heading'
import { PageEndpoints } from '@/lib/constants/page-endpoint'
import { Fragment } from 'react'

const breadcrumbItems = [
  { title: 'Dashboard', link: PageEndpoints.dashboard },
  { title: 'Sliding Window', link: PageEndpoints.slidingWindow.index },
  { title: 'DOM Optimization', link: PageEndpoints.slidingWindow.domOptimization },
]

function DOMOptionizationSection() {
  return (
    <Fragment>
      <PageHeading
        title={`DOM Optimization`}
        description='Virtualized rendering For Large Data List'
        breadcrumbItems={breadcrumbItems}
      />
      <main className='px-8'></main>
    </Fragment>
  )
}

export default DOMOptionizationSection
