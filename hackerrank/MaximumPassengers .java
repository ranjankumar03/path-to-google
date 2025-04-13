package hackerrank;

import java.util.Scanner;

class MaximumPassengers {

    public static int maxPassengers(int[][] grid) {
        int n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];

        return Math.max(0, helper(grid, 0, 0, 0, dp));
    }

    private static int helper(int[][] grid, int r1, int c1, int r2, Integer[][][] dp) {
        int n = grid.length;
        int c2 = r1 + c1 - r2;

        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2] != null) {
            return dp[r1][c1][r2];
        }

        int curr = grid[r1][c1];
        if (r1 != r2 || c1 != c2) {
            curr += grid[r2][c2];
        }

        int temp = Math.max(Math.max(
                        helper(grid, r1 + 1, c1, r2 + 1, dp),
                        helper(grid, r1, c1 + 1, r2, dp)),
                    Math.max(
                        helper(grid, r1 + 1, c1, r2, dp),
                        helper(grid, r1, c1 + 1, r2 + 1, dp))
        );

        curr += temp;
        dp[r1][c1][r2] = curr;
        return curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of rows
        int m = sc.nextInt(); // number of columns (same as n if square matrix)

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxPassengers(grid));
    }
}
