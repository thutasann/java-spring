'use client'

import { PageHeading } from '@/components/atoms/page-heading'
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs'
import { PageEndpoints } from '@/lib/constants/page-endpoint'
import { Fragment } from 'react'
import LiveSearch from './live-search'
import SubStringSearch from './substring-search'

const breadcrumbItems = [
  { title: 'Dashboard', link: PageEndpoints.dashboard },
  { title: 'Sliding Window', link: PageEndpoints.slidingWindow.index },
  { title: 'Search and Filtering', link: PageEndpoints.slidingWindow.searchAndFiltering },
]

function SearchFiltering() {
  return (
    <Fragment>
      <PageHeading
        title={`Search and Filtering`}
        description='Finding substrings in large text efficiently.'
        breadcrumbItems={breadcrumbItems}
      />
      <main className='px-8'>
        <Tabs defaultValue='find-substrings'>
          <TabsList>
            <TabsTrigger value='find-substrings'>Find SubStrings</TabsTrigger>
            <TabsTrigger value='live-search'>Live Search</TabsTrigger>
          </TabsList>
          <TabsContent value='find-substrings' className='mt-8 w-full rounded-md border p-4'>
            <SubStringSearch />
          </TabsContent>
          <TabsContent value='live-search' className='mt-8 w-full rounded-md border p-4'>
            <LiveSearch />
          </TabsContent>
        </Tabs>
      </main>
    </Fragment>
  )
}

export default SearchFiltering
