package Graphs;
import java.util.*;

public class FloyddWarshal {

    public void shortestDistance(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                }
                if (matrix[i][j] == -1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int via = 0; via < matrix.length; via++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][via] != Integer.MAX_VALUE && matrix[via][j] != Integer.MAX_VALUE) {
                        int currDist = matrix[i][via] + matrix[via][j];
                        if (currDist < matrix[i][j]) {
                            matrix[i][j] = currDist;
                        }
                    }
                }
            }
        }



        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 2, -1, -1},
                {1, 0, 3, -1},
                {-1, -1, 0, -1},
                {3, 5, 4, 0}
        };

        /* Creating an instance of
        Solution class */
        FloyddWarshal sol = new FloyddWarshal();

        /* Function to find the shortest distance
        between every pair of vertices. */
        sol.shortestDistance(matrix);

        // Output
        int n = matrix.length;
        System.out.println("The shortest distance matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
