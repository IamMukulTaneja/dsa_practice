package Graphs;
import java.util.*;

public class CheapestFlightWithKStops {
    public int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {
        if(src == dst) {
            return 0;
        }

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int[] edge = flights[i];

            adj.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,src,0});

        int[] cost = new int[n];

        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        while (!queue.isEmpty()) {

            int[] node = queue.poll();
            //System.out.println("POLLED VALUE: " + node[1] + "," + node[2] + " with distance: " + node[0]);


            if(node[0] == (K+1)) {
                continue;
            }


            for(int[] neighbor: adj.get(node[1])) {
                int currentCost = node[2] + neighbor[1];
                if(currentCost < cost[neighbor[0]]) {
                    cost[neighbor[0]] = currentCost;
                    queue.add(new int[]{node[0]+1,neighbor[0],currentCost});
                }
            }
        }
        if(cost[dst] != Integer.MAX_VALUE) {
            return cost[dst];
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };

        int src = 0, dst = 3, k = 1;

        // Creating an instance of Solution class
        CheapestFlightWithKStops sol = new CheapestFlightWithKStops();

        // Function call to determine cheapest flight from source to destination within K stops
        int ans = sol.CheapestFlight(n, flights, src, dst, k);

        // Output
        System.out.println("The cheapest flight from source to destination within K stops is: " + ans);
    }
}
