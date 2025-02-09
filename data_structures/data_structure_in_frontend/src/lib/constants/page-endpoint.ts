/**
 * Page Endpionts
 */
export const PageEndpoints = {
  index: '/',
  dashboard: '/dashboard',
  slidingWindow: {
    index: '/dashboard/sliding-window',
    searchAndFiltering: '/dashboard/sliding-window/search-and-filtering',
  },
};

/**
 * Page Endpoint Type
 */
export type PageEndpointProps = typeof PageEndpoints;
