'use client';

import TopLoader from '@/components/molecules/layout/top-loader';
import { Toaster } from '@/components/ui/toaster';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import React from 'react';
import { RecoilRoot } from 'recoil';
import ThemeProvider from './theme/theme-provider';

interface IRootProvider {
  children: React.ReactNode;
}

const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      retry: false,
      refetchOnMount: false,
      refetchOnWindowFocus: false,
    },
  },
});

function RootProvider({ children }: IRootProvider) {
  return (
    <QueryClientProvider client={queryClient}>
      <RecoilRoot>
        <ThemeProvider attribute='class' defaultTheme='system' enableSystem>
          <TopLoader />
          {children}
          <Toaster />
        </ThemeProvider>
      </RecoilRoot>
    </QueryClientProvider>
  );
}

export default RootProvider;
