package Graphs;
import java.util.*;

public class Dijikstra
{
    class Pair {
        int dist;
        int node;

        Pair(int _dist, int _node) {
            dist = _dist;
            node = _node;
        }
    }
    public  int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dist = new int[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b) -> a.dist - b.dist
        );
        pq.add(new Pair(0,S));

        Arrays.fill(dist,(int)1e9);
        dist[S] = 0;

        while(!pq.isEmpty()) {
            Pair p = pq.poll();

            for(ArrayList<Integer> node: adj.get(p.node)) {
                int adjNode = node.get(0);
                int weight = node.get(1);

                if(weight + p.dist < dist[adjNode]) {
                    dist[adjNode] = weight + p.dist;
                    pq.add(new Pair(weight + p.dist, adjNode));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int V = 2, S = 0;

        // Create adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> node0 = new ArrayList<>();
        node0.add(new ArrayList<>(Arrays.asList(1, 9)));
        adj.add(node0);

        ArrayList<ArrayList<Integer>> node1 = new ArrayList<>();
        node1.add(new ArrayList<>(Arrays.asList(0, 9)));
        adj.add(node1);

        /* Creating an instance of
        Solution class */
        Dijikstra sol = new Dijikstra();

        /* Function call to find the shortest distance
        of each node from the source node */
        int[] ans = sol.dijkstra(V, adj, S);

        // Output
        System.out.print("The shortest distance of nodes from the source node is: ");
        for (int i = 0; i < V; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

