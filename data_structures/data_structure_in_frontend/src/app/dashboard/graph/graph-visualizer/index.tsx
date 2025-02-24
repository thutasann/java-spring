'use client';

import { PageHeading } from '@/components/atoms/page-heading';
import { PageEndpoints } from '@/lib/constants/page-endpoint';
import { Fragment } from 'react';
import Visualizer from './visualizer';

const breadcrumbItems = [
  { title: 'Dashboard', link: PageEndpoints.dashboard },
  { title: 'Graph', link: PageEndpoints.graph.index },
  { title: 'Graph Visualizer', link: PageEndpoints.graph.index },
];

function GraphVisualizer() {
  return (
    <Fragment>
      <PageHeading
        title={`Graph Visualizer`}
        description='This example visualizes a graph, allows adding/removing nodes and edges, and performs BFS, DFS, and Dijkstra Algorithm interactively.'
        breadcrumbItems={breadcrumbItems}
      />
      <main className='px-8'>
        <Visualizer />
      </main>
    </Fragment>
  );
}

export default GraphVisualizer;
