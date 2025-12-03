package Graphs;

public class CityWithSmallestNumberOfNeighbours {

    public int findCity(int n, int m, int edges[][], int distanceThreshold) {

        int[][] adj = new int[n][n];

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];

            adj[u][v] = weight;
            adj[v][u] = weight;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    adj[i][j] = 0;
                }
                if (adj[i][j] == 0) {
                    adj[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int via = 0; via < adj.length; via++) {
            for (int i = 0; i < adj.length; i++) {
                for (int j = 0; j < adj[0].length; j++) {
                    if (adj[i][via] != Integer.MAX_VALUE && adj[via][j] != Integer.MAX_VALUE) {
                        int currDist = adj[i][via] + adj[via][j];
                        if (currDist < adj[i][j]) {
                            adj[i][j] = currDist;
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int city = -1;
        for(int i=0;i<n;i++) {
            int currCount = 0;
            for(int j=0;j<n;j++) {
                if(i!=j && adj[i][j]!=Integer.MAX_VALUE && adj[i][j] <= distanceThreshold) {
                    currCount++;
                }
            }
            if(currCount < min) {
                min = currCount;
                city = i;
            } else if(currCount == min) {
                city = i;
            }
        }

        return city;
    }

    public static void main(String[] args) {
        int N = 4, M = 4;
        int[][] edges = {
                {0, 1, 3}, {1, 2, 1},
                {1, 3, 4}, {2, 3, 1}
        };
        int distanceThreshold = 4;

        /* Creating an instance of
        Solution class */
        CityWithSmallestNumberOfNeighbours sol = new CityWithSmallestNumberOfNeighbours();

        /* Function to find the city with
        the smallest number of neighbors. */
        int ans = sol.findCity(N, M, edges, distanceThreshold);

        // Output
        System.out.println("The city with smallest number of neighbors (with given threshold) is: " + ans);
    }
}
