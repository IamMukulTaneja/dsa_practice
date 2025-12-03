package Graphs;
import java.util.*;

public class WaysToArriveAtDestination {
    public int countPaths(int n, List<List<Integer>> roads) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.size(); i++) {
            List<Integer> edge = roads.get(i);

            adj.get(edge.get(0)).add(new int[] {edge.get(1), edge.get(2)});
            adj.get(edge.get(1)).add(new int[] {edge.get(0), edge.get(2)});
        }

        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        int count = 0;

        long[] dist = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];
        Arrays.fill(ways, 0);
        ways[0] = 1;

        q.add(new long[] {0, 0});

        while (!q.isEmpty()) {
            long[] node = q.poll();

            for (int[] edge : adj.get((int)node[1])) {
                long newDist = node[0] + edge[1];

                if (newDist < dist[edge[0]]) {
                    q.add(new long[] {newDist, edge[0]});
                    dist[edge[0]] = newDist;
                    ways[edge[0]] = ways[(int)node[1]];
                } else if(newDist == dist[edge[0]]) {
                    ways[edge[0]] = ways[(int)node[1]] + ways[edge[0]];
                }
            }
        }
        int mod = 1000000007; // Mod value
        return (int)(ways[n-1] % mod);
    }

    public static void main(String[] args) {
        int n = 7, m = 20;
        List<List<Integer>> roads = Arrays.asList(
                Arrays.asList(0, 6, 7),
                Arrays.asList(0, 1, 2),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 3),
                Arrays.asList(6, 3, 3),
                Arrays.asList(3, 5, 1),
                Arrays.asList(6, 5, 1),
                Arrays.asList(2, 5, 1),
                Arrays.asList(0, 4, 5),
                Arrays.asList(4, 6, 2)
        );

        /* Creating an instance of
        Solution class */
        WaysToArriveAtDestination sol = new WaysToArriveAtDestination();

        /* Function call to get the number of ways to
        arrive at destinations in shortest possible time */
        int ans = sol.countPaths(n, roads);

        // Output
        System.out.println("The number of ways to arrive at destinations in shortest possible time is: " + ans);
    }
}
