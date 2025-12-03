package Graphs;
import java.util.*;

public class MinimumMultiplicationToReachEnd {

    public int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }

        boolean[] visited = new boolean[100001];

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {0, start});
        visited[start] = true;

        while (!q.isEmpty()) {

            int[] node = q.poll();

            if (node[1] == end) {
                return node[0];
            }

            for (int i = 0; i < arr.length; i++) {
                int newStart = (node[1] * arr[i]) % 100000;
                if (!visited[newStart]) {
                    visited[newStart] = true;
                    q.add(new int[] {node[0] + 1, newStart});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int start = 3, end = 30;
        int[] arr = {2, 5, 7};

        /* Creating an instance of
        Solution class */
        MinimumMultiplicationToReachEnd sol = new MinimumMultiplicationToReachEnd();

        /* Function call to determine minimum
        multiplications to reach end */
        int ans = sol.minimumMultiplications(arr, start, end);

        // Output
        System.out.println("The minimum multiplications to reach end is: " + ans);
    }
}
