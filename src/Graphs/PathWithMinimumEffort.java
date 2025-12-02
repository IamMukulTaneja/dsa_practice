package Graphs;
import java.util.*;

public class PathWithMinimumEffort {
    public int MinimumEffort(List<List<Integer>> heights) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.add(new int[] {0, 0, 0});

        boolean[][] visited = new boolean[heights.size()][heights.get(0).size()];

        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }

        visited[0][0] = true;

        int[] dest = new int[] {heights.size() - 1, heights.get(0).size() - 1};

        while (!queue.isEmpty()) {

            int[] node = queue.poll();

            visited[node[1]][node[2]] = true;

            //System.out.println("POLLED VALUE: " + node[1] + "," + node[2] + " with distance: " + node[0]);

            if (node[1] == dest[0] && node[2] == dest[1]) {
                return node[0];
            }

            int r = node[1];
            int c = node[2];
            // up
            r--;
            if (r >= 0 && !visited[r][c]) {

                int val1 = heights.get(r).get(c);
                int val2 = heights.get(node[1]).get(node[2]);
                queue.add(new int[] {Math.max(node[0], Math.abs(val1 - val2)), r, c});
            }
            r = node[1];
            // down
            r++;
            if (r < heights.size() && !visited[r][c]) {

                int val1 = heights.get(r).get(c);
                int val2 = heights.get(node[1]).get(node[2]);
                queue.add(new int[] {Math.max(node[0], Math.abs(val1 - val2)), r, c});
            }
            r = node[1];
            // right
            c++;
            if (c < heights.get(0).size() && !visited[r][c]) {

                int val1 = heights.get(r).get(c);
                int val2 = heights.get(node[1]).get(node[2]);
                queue.add(new int[] {Math.max(node[0], Math.abs(val1 - val2)), r, c});
            }
            c = node[2];
            // left
            c--;
            if (c >= 0 && !visited[r][c]) {

                int val1 = heights.get(r).get(c);
                int val2 = heights.get(node[1]).get(node[2]);
                queue.add(new int[] {Math.max(node[0], Math.abs(val1 - val2)), r, c});
            }

        }
        return -1;
    }
    public static void main(String[] args) {

        List<List<Integer>> heights = Arrays.asList(
                Arrays.asList(1, 2, 2),
                Arrays.asList(3, 8, 2),
                Arrays.asList(5, 3, 5)
        );

        /* Creating an instance of
        Solution class */
        PathWithMinimumEffort sol = new PathWithMinimumEffort();

        /* Function call to determine minimum efforts
        to go from top-left to bottom-right */
        int ans = sol.MinimumEffort(heights);

        // Output
        System.out.println("The minimum efforts required to go from cell (0,0) to cell (row-1, col-1) is: " + ans);
    }
}
