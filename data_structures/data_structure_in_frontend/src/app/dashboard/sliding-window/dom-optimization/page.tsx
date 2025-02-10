import DOMOptionizationSection from '@/components/molecules/contents/sliding-window/dom-optinization'
import PageContainer from '@/components/molecules/layout/page-container'
import { Metadata } from 'next'

export const metadata: Metadata = {
  title: 'DOM Optimization',
}

function DOMOptionization() {
  return (
    <PageContainer>
      <DOMOptionizationSection />
    </PageContainer>
  )
}

export default DOMOptionization
