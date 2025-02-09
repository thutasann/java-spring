'use client';

import { PageHeading } from '@/components/atoms/page-heading';
import { PageEndpoints } from '@/lib/constants/page-endpoint';
import { Fragment } from 'react';

const breadcrumbItems = [
  { title: 'Dashboard', link: PageEndpoints.dashboard },
  { title: 'Sliding Window', link: PageEndpoints.slidingWindow.index },
  { title: 'Search and Filtering', link: PageEndpoints.slidingWindow.searchAndFiltering },
];

function SearchFilteringTable() {
  return (
    <Fragment>
      <PageHeading
        title={`Search and Filtering`}
        description='Finding substrings in large text efficiently.'
        breadcrumbItems={breadcrumbItems}
      />
    </Fragment>
  );
}

export default SearchFilteringTable;
