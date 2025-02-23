/**
 * Graph Data Structure
 * @description
 * - Uses a Map<T, Map<T, number>> to store adjacency lists, ensuring fast lookup and efficient memory usage.
 * - Inner Map<T, number> stores edges with weights for efficient retrieval.
 */
export class Graph<T> {
  private adjacencyList: Map<T, Map<T, number>>;
  private isDirected: boolean;

  constructor(isDirected = false) {
    this.isDirected = isDirected;
    this.adjacencyList = new Map();
  }

  private addvertex(vertex: T): void {
    if (!this.adjacencyList.has(vertex)) {
      this.adjacencyList.set(vertex, new Map());
    }
  }

  addEdge(vertex1: T, vertex2: T, weight = 1) {
    this.addvertex(vertex1);
    this.addvertex(vertex2);
    this.adjacencyList.get(vertex1)?.set(vertex2, weight);
    if (!this.isDirected) {
      this.adjacencyList.get(vertex2)?.set(vertex1, weight);
    }
  }

  removeEdge(vertex1: T, vertex2: T): void {
    this.adjacencyList.get(vertex1)?.delete(vertex2);
    if (!this.isDirected) {
      this.adjacencyList.get(vertex2)?.delete(vertex1);
    }
  }

  removeVertex(vertex: T): void {
    this.adjacencyList.delete(vertex);
    for (const [key, edges] of this.adjacencyList) {
      edges.delete(vertex);
    }
  }

  bfs(start: T): T[] {
    if (!this.adjacencyList.has(start)) return [];
    const visisted = new Set<T>();
    const queue: T[] = [start];
    const result: T[] = [];

    while (queue.length) {
      const vertex = queue.shift()!;
      if (!visisted.has(vertex)) {
        visisted.add(vertex);
        result.push(vertex);
        queue.push(...this.adjacencyList.get(vertex)!.keys());
      }
    }

    return result;
  }

  dfs(start: T, visited = new Set<T>()): T[] {
    if (!this.adjacencyList.has(start)) return [];
    const result: T[] = [];

    const dfsHelper = (vertex: T) => {
      if (visited.has(vertex)) return;
      visited.add(vertex);
      result.push(vertex);
      for (const neighbor of this.adjacencyList.get(vertex)!.keys()) {
        dfsHelper(neighbor);
      }
    };

    dfsHelper(start);
    return result;
  }

  dijkstra(start: T): Map<T, number> {
    if (!this.adjacencyList.has(start)) return new Map();

    const distances = new Map<T, number>();
    const pq: [T, number][] = [[start, 0]];

    for (const vertex of this.adjacencyList.keys()) {
      distances.set(vertex, vertex === start ? 0 : Infinity);
    }

    while (pq.length) {
      pq.sort((a, b) => a[1] - b[1]);
      const [current, currentDist] = pq.shift()!;

      for (const [neighbor, weight] of this.adjacencyList.get(current)!.entries()) {
        const newDist = currentDist + weight;
        if (newDist < distances.get(neighbor)!) {
          distances.set(neighbor, newDist);
          pq.push([neighbor, newDist]);
        }
      }
    }

    return distances;
  }

  printGraph(): void {
    for (const [vertex, edges] of this.adjacencyList) {
      console.log(`${vertex} -> ${[...edges.entries()].map(([v, w]) => `${v} (${w})`).join(', ')}`);
    }
  }
}
