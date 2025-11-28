package Graphs;
import java.util.*;
class PrintShortestPath {
        class Pair {
            int dist;
            int node;

            Pair(int _dist, int _node) {
                dist = _dist;
                node = _node;
            }
        }

        public List<Integer> shortestPath(int n, int m, int[][] edges) {

            List<List<int[]>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            // Adding the edges to the graph
            for (int[] edge : edges) {
                adj.get(edge[0]).add(new int[] {edge[1], edge[2]});
                adj.get(edge[1]).add(new int[] {edge[0], edge[2]});
            }

            // Distance array to find minimum distances
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[1] = 0;

            int[] parent = new int[n + 1];
            Arrays.fill(parent, 0);
            parent[1] = 1;

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
            pq.add(new Pair(0, 1));

            while (!pq.isEmpty()) {
                Pair p = pq.poll();

                for (int[] neighbour : adj.get(p.node)) {
                    int adjNode = neighbour[0];
                    int weight = neighbour[1];

                    if (weight + p.dist < dist[adjNode]) {
                        dist[adjNode] = weight + p.dist;
                        pq.add(new Pair(weight + p.dist, adjNode));
                        parent[adjNode] = p.node;
                    }
                }
            }

            List<Integer> res = new ArrayList<>();
            if (parent[n] == 0) {
                res.add(-1);
                return res;
            }

            int node = n;
            while (parent[node] != node) {
                res.add(node);

                node = parent[node];
            }
            res.add(1);
            Collections.reverse(res);
            res.add(0,dist[n]);
            return res;
        }

    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {
                {1, 2, 2}, {2, 5, 5}, {2, 3, 4},
                {1, 4, 1}, {4, 3, 3}, {3, 5, 1}
        };

        /* Creating an instance of
        Solution class */
        PrintShortestPath sol = new PrintShortestPath();

        /* Function call to find the shortest distance
        of each node from the source node */
        List<Integer> ans = sol.shortestPath(n, m, edges);

        // Output
        System.out.println("The resulting path weight is: " + ans.get(0));
        System.out.println("The path is: ");
        for (int i = 1; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
    }


