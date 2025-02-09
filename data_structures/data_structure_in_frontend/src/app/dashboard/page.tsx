'use client';

import PageContainer from '@/components/molecules/layout/page-container';
import { Card, CardContent, CardHeader, CardTitle } from '@/components/ui/card';
import { useRouter } from 'next/navigation';

const data_structures_and_algorithms = [
  {
    title: 'Sliding Window',
    href: '/dashboard/sliding-window/search-and-filtering',
  },
];

export default function DashboardPage() {
  const router = useRouter();

  const handleClick = (href: string) => {
    router.push(href);
  };

  return (
    <PageContainer scrollable={true}>
      <div className='mt-4 space-y-2 px-8'>
        <div className='grid gap-4 md:grid-cols-2 lg:grid-cols-4'>
          {data_structures_and_algorithms.map((item) => (
            <Card key={item.title} onClick={() => handleClick(item.href)} className='cursor-pointer'>
              <CardHeader className='flex flex-row items-center justify-between space-y-0 pb-2'>
                <CardTitle className='text-sm font-medium'>{item.title}</CardTitle>
              </CardHeader>
              <CardContent>
                <div className='text-2xl font-bold'>{item.title}</div>
              </CardContent>
            </Card>
          ))}
        </div>
      </div>
    </PageContainer>
  );
}
