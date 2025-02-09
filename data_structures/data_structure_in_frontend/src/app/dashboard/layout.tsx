import Header from '@/components/molecules/layout/header';
import Sidebar from '@/components/molecules/layout/nav/sidebar';
import type { Metadata } from 'next';

export const metadata: Metadata = {
  title: 'Data Structure and Algorithms in Reactjs',
};

export default function DashboardLayout({ children }: { children: React.ReactNode }) {
  return (
    <div className='flex'>
      <Sidebar />
      <main className='w-full overflow-hidden bg-background'>
        <Header />
        {children}
      </main>
    </div>
  );
}
