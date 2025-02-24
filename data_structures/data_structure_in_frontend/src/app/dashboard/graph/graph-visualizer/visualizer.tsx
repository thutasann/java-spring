'use client';

import { Button } from '@/components/ui/button';
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from '@/components/ui/select';
import React, { useState } from 'react';

type Node = string;
type GraphType = Map<Node, Map<Node, number>>;

function Visualizer() {
  const [graph, setGraph] = useState<GraphType>(new Map());
  const [selectedStart, setSelectedState] = useState<Node | ''>('');
  const [traversalResult, setTraversalResult] = useState<Node[]>([]);

  const addNode = (node: Node) => {
    setGraph((prev) => new Map(prev).set(node, new Map()));
  };

  const addEdge = (node1: Node, node2: Node, weight: number) => {
    setGraph((prev) => {
      const newGraph = new Map(prev);
      if (!newGraph.has(node1)) newGraph.set(node1, new Map());
      if (!newGraph.has(node2)) newGraph.set(node2, new Map());

      newGraph.get(node1)?.set(node2, weight);
      newGraph.get(node2)?.set(node1, weight);
      return newGraph;
    });
  };

  const bfs = (start: Node) => {
    if (!graph.has(start)) return;
    const visited = new Set<Node>();
    const queue: Node[] = [start];
    const result: Node[] = [];

    while (queue.length) {
      const vertex = queue.shift()!;
      if (!visited.has(vertex)) {
        visited.add(vertex);
        result.push(vertex);
        queue.push(...graph.get(vertex)!.keys());
      }
    }

    setTraversalResult(result);
  };

  const dfs = (start: Node, visited = new Set<Node>(), result: Node[] = []) => {
    if (!graph.has(start)) return;
    visited.add(start);
    result.push(start);

    for (const neighbor of graph.get(start)!.keys()) {
      if (!visited.has(neighbor)) {
        dfs(neighbor, visited, result);
      }
    }
    setTraversalResult(result);
  };

  return (
    <div className='flex flex-col items-start space-y-4'>
      <div className='flex gap-4'>
        <Button onClick={() => addNode(prompt('Enter Node Name')!)}>Add node</Button>
        <Button
          variant='outline'
          onClick={() => {
            const n1 = prompt('Enter first node')!;
            const n2 = prompt('Enter second node')!;
            const weight = parseInt(prompt('Enter weight')!, 10);
            addEdge(n1, n2, weight);
          }}
        >
          Add Edge
        </Button>
      </div>

      <div className='flex gap-4'>
        <Select value={selectedStart} onValueChange={(val) => setSelectedState(val)}>
          <SelectTrigger className='w-[180px]'>
            <SelectValue placeholder='Select' />
          </SelectTrigger>
          <SelectContent>
            {[...graph.keys()].map((node) => {
              return <SelectItem value={node}>{node}</SelectItem>;
            })}
          </SelectContent>
        </Select>
      </div>

      <div className='flex gap-4'>
        <Button onClick={() => selectedStart && bfs(selectedStart)}>BFS</Button>
        <Button variant='outline' onClick={() => selectedStart && dfs(selectedStart)}>
          DFS
        </Button>
      </div>

      <div className='p-4 border rounded-md w-full'>
        <h2 className='font-semibold'>Traversal Result:</h2>
        <p className='text-md'>{traversalResult.join(' → ') || 'No traversal yet'}</p>
      </div>

      <div className='mt-6 border p-4 rounded-md w-full'>
        <h2 className='text-lg font-semibold mb-2'>Graph Structure:</h2>
        {Array.from(graph.entries()).map(([node, edges]) => (
          <div key={node} className='text-slate-300'>
            <strong>{node}</strong> →{' '}
            {Array.from(edges.entries())
              .map(([neighbor, weight]) => `${neighbor} (${weight})`)
              .join(', ')}
          </div>
        ))}
      </div>
    </div>
  );
}

export default Visualizer;
