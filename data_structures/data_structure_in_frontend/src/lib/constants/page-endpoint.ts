/**
 * Page Endpionts
 */
export const PageEndpoints = {
  index: '/',
  dashboard: '/dashboard',
  slidingWindow: {
    index: '/dashboard/sliding-window',
    searchAndFiltering: '/dashboard/sliding-window/search-and-filtering',
    domOptimization: '/dashboard/sliding-window/dom-optimization',
  },
  graph: {
    index: '/dashboard/graph',
  },
};

/**
 * Page Endpoint Type
 */
export type PageEndpointProps = typeof PageEndpoints;
