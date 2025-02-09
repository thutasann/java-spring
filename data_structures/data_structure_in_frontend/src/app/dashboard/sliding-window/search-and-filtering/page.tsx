import PageContainer from '@/components/molecules/layout/page-container';
import SearchFilteringTable from '@/components/molecules/tables/sliding-window/search-filtering';
import { Metadata } from 'next';

export const metadata: Metadata = {
  title: 'Search and Filtering',
};

function SearchAndFiltering() {
  return (
    <PageContainer>
      <SearchFilteringTable />
    </PageContainer>
  );
}

export default SearchAndFiltering;
