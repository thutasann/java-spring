import DOMOptionizationSection from '@/components/molecules/contents/sliding-window/dom-optinization'
import SearchFilteringTable from '@/components/molecules/contents/sliding-window/search-filtering'
import PageContainer from '@/components/molecules/layout/page-container'
import { Metadata } from 'next'

export const metadata: Metadata = {
  title: 'DOMOptionization',
}

function DOMOptionization() {
  return (
    <PageContainer>
      <DOMOptionizationSection />
    </PageContainer>
  )
}

export default DOMOptionization
