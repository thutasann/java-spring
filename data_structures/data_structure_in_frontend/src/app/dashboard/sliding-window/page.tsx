import PageContainer from '@/components/molecules/layout/page-container';
import CategoriesTable from '@/components/molecules/tables/sliding-window/search-filtering';
import { Metadata } from 'next';

export const metadata: Metadata = {
  title: 'Sliding Window',
};

function SlidingWindow() {
  return (
    <PageContainer>
      <CategoriesTable />
    </PageContainer>
  );
}

export default SlidingWindow;
