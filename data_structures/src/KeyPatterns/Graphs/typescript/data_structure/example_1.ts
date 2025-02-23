import { Graph } from './graph';

const graph = new Graph<string>(true);
graph.addEdge('A', 'B', 4);
graph.addEdge('A', 'C', 2);
graph.addEdge('B', 'C', 5);
graph.addEdge('B', 'D', 10);
graph.addEdge('C', 'D', 3);
graph.printGraph();

console.log('\n------- BFS -------');
console.log('BFS:', graph.bfs('A'));

console.log('\n------- DFS -------');
console.log('DFS:', graph.dfs('A'));

console.log('\n------- Dijkstra -------');
console.log('Dijkstra:', graph.dijkstra('A'));
