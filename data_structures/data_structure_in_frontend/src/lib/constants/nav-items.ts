import { NavItemWithOptionalChildren } from '@/dto/types/ui.type';

/** NAV_ITEMS */
export const navItems: NavItemWithOptionalChildren[] = [
  {
    title: 'Dashboard',
    href: '/dashboard',
    icon: 'dashboard',
    label: 'Dashboard',
  },
  {
    title: 'Sliding Window',
    icon: 'categories',
    label: 'slidingWindow',
    items: [
      {
        title: 'Search and Filtering',
        href: '/dashboard/sliding-window/search-and-filtering',
        icon: 'check',
        label: 'searchAndFiltering',
        items: [],
      },
      {
        title: 'DOM Optimization',
        href: '/dashboard/sliding-window/dom-optimization',
        icon: 'check',
        label: 'domOptimization',
        items: [],
      },
    ],
  },
  {
    title: 'Graph',
    icon: 'billing',
    label: 'graph',
    href: '/dashboard/graph',
  },
];
