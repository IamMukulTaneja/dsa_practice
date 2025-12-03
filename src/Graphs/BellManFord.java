package Graphs;
import java.util.*;

public class BellManFord {

     public int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {

        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[S] = 0;

        for (int j = 0; j < V - 1; j++) {
            for (int i = 0; i < edges.size(); i++) {
                int u = edges.get(i).get(0);
                int v = edges.get(i).get(1);
                int wt = edges.get(i).get(2);

                if (dist[u] != 1e9 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int wt = edges.get(i).get(2);

            if (dist[u] != 1e9 && dist[u] + wt < dist[v]) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 6, S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(3, 2, 6)));
        edges.add(new ArrayList<>(Arrays.asList(5, 3, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 5)));
        edges.add(new ArrayList<>(Arrays.asList(1, 5, -3)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, -2)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4, -2)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4, 3)));

        /* Creating an instance of
        Solution class */
        BellManFord sol = new BellManFord();

        /* Function call to implement
        Bellman Ford Algorithm */
        int[] ans = sol.bellman_ford(V, edges, S);

        // Output
        if(ans.length == 1 && ans[0] == -1)
            System.out.println("The graph contains negative cycle.");
        else{
            System.out.print("The shortest distance from source is: ");
            for(int i = 0; i < V; i++) {
                System.out.print(ans[i] + " ");
            }
        }
    }
}
