import SearchFilteringTable from '@/components/molecules/contents/sliding-window/search-filtering'
import PageContainer from '@/components/molecules/layout/page-container'
import { Metadata } from 'next'

export const metadata: Metadata = {
  title: 'Search and Filtering',
}

function SearchAndFiltering() {
  return (
    <PageContainer>
      <SearchFilteringTable />
    </PageContainer>
  )
}

export default SearchAndFiltering
