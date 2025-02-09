import SearchFiltering from '@/components/molecules/contents/sliding-window/search-filtering'
import PageContainer from '@/components/molecules/layout/page-container'
import { Metadata } from 'next'

export const metadata: Metadata = {
  title: 'Sliding Window',
}

function SlidingWindow() {
  return (
    <PageContainer>
      <SearchFiltering />
    </PageContainer>
  )
}

export default SlidingWindow
