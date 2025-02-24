import SearchFiltering from '@/components/molecules/contents/sliding-window/search-filtering';
import PageContainer from '@/components/molecules/layout/page-container';
import { Metadata } from 'next';
import GraphVisualizer from './graph-visualizer';

export const metadata: Metadata = {
  title: 'Graph',
};

function SlidingWindow() {
  return (
    <PageContainer>
      <GraphVisualizer />
    </PageContainer>
  );
}

export default SlidingWindow;
