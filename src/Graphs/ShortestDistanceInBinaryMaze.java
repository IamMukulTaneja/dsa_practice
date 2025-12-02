package Graphs;
import java.util.*;

class ShortestDistanceInBinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a,b) -> a[0] - b[0]
        );
        queue.add(new int[]{0,source[0],source[1]});

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0;i<visited.length;i++) {
            Arrays.fill(visited[i], false);
        }

        while(!queue.isEmpty()) {

            int[] node = queue.poll();

            if(node[1] == destination[0] && node[2] == destination[1]) {
                return node[0];
            }

            int r = node[1];
            int c = node[2];
            // up
            r--;
            if(r >= 0 && grid[r][c]!=0 && !visited[r][c]) {
                visited[r][c] = true;
                queue.add(new int[]{node[0]+1,r,c});
            }
            r = node[1];
            //down
            r++;
            if(r < grid.length && grid[r][c]!=0 && !visited[r][c]) {
                visited[r][c] = true;
                queue.add(new int[]{node[0]+1,r,c});
            }
            r = node[1];
            //right
            c++;
            if(c < grid[0].length && grid[r][c]!=0 && !visited[r][c]) {
                visited[r][c] = true;
                queue.add(new int[]{node[0]+1,r,c});
            }
            c = node[2];
            //left
            c--;
            if(c >=0 && grid[r][c]!=0 && !visited[r][c]) {
                visited[r][c] = true;
                queue.add(new int[]{node[0]+1,r,c});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] source = {0, 1};
        int[] destination = {2, 2};

        int[][] grid = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}
        };

        /* Creating an instance of
        Solution class */
        ShortestDistanceInBinaryMaze sol = new ShortestDistanceInBinaryMaze();

        /* Function call to determine the shortest
        distance between source and destination */
        int ans = sol.shortestPath(grid, source, destination);

        System.out.println("The shortest distance from the source to destination is: " + ans);
    }
}


