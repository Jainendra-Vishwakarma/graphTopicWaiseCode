import java.util.*;
public class RegionInBinaryMatrix {
    static int ROW, COL, count;

    // A function to check if a given cell (row, col)
    // can be included in DFS
    static boolean isSafe(int[][] M, int row, int col,
                          boolean[][] visited)
    {
        // row number is in range, column number is in
        // range and value is 1 and not yet visited
        return (
                (row >= 0) && (row < ROW) && (col >= 0)
                        && (col < COL)
                        && (M[row][col] == 1 && !visited[row][col]));
    }

    // A utility function to do DFS for a 2D boolean
    // matrix. It only considers the 8 neighbours as
    // adjacent vertices
    static void DFS(int[][] M, int row, int col,
                    boolean[][] visited)
    {
        // These arrays are used to get row and column
        // numbers of 8 neighbours of a given cell
        int[] rowNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] colNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; k++) {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k],
                    visited)) {
                // increment region length by one
                count++;
                DFS(M, row + rowNbr[k], col + colNbr[k],
                        visited);
            }
        }
    }

    // The main function that returns largest length region
    // of a given boolean 2D matrix
    static int largestRegion(int[][] M)
    {
        // Make a boolean array to mark visited cells.
        // Initially all cells are unvisited
        boolean[][] visited = new boolean[ROW][COL];

        // Initialize result as 0 and traverse through the
        // all cells of given matrix
        int result = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {

                // If a cell with value 1 is not
                if (M[i][j] == 1 && !visited[i][j]) {

                    // visited yet, then new region found
                    count = 1;
                    DFS(M, i, j, visited);

                    // maximum region
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    // Driver code
    public static void main(String args[])
    {
        int M[][] = { { 0, 0, 1, 1, 0 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1 } };
        ROW = 4;
        COL = 5;

        // Function call
        System.out.println(largestRegion(M));
    }
}

//bsf

// Java program for the above approach

class GFG {

     static class Pair {
        int x, y;
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    // Function to find unit area of the largest region of
    // 1s.
     static int largestRegion(int M[][]) {
        int m = M.length;
        int n = M[0].length;

        // creating a queue that will help in bfs traversal
        Queue<Pair> q = new LinkedList<>();
        int area = 0;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if the value at any particular cell is 1
                // then from here we need to do the BFS
                // traversal
                if (M[i][j] == 1) {
                    ans = 0;

                    // pushing the Pair(i,j) in the queue
                    q.offer(new Pair(i, j));

                    // marking the value 1 to -1 so that we
                    // don't again push this cell in the
                    // queue
                    M[i][j] = -1;

                    while (!q.isEmpty()) {
                        Pair t = q.poll();
                        ans++;
                        int x = t.x;
                        int y = t.y;

                        // now we will check in all 8
                        // directions
                        if (x + 1 < m) {
                            if (M[x + 1][y] == 1) {
                                q.offer(new Pair(x + 1, y));
                                M[x + 1][y] = -1;
                            }
                        }
                        if (x - 1 >= 0) {
                            if (M[x - 1][y] == 1) {
                                q.offer(new Pair(x - 1, y));
                                M[x - 1][y] = -1;
                            }
                        }
                        if (y + 1 < n) {
                            if (M[x][y + 1] == 1) {
                                q.offer(new Pair(x, y + 1));
                                M[x][y + 1] = -1;
                            }
                        }
                        if (y - 1 >= 0) {
                            if (M[x][y - 1] == 1) {
                                q.offer(new Pair(x, y - 1));
                                M[x][y - 1] = -1;
                            }
                        }
                        if (x + 1 < m && y + 1 < n) {
                            if (M[x + 1][y + 1] == 1) {
                                q.offer(new Pair(x + 1, y + 1));
                                M[x + 1][y + 1] = -1;
                            }
                        }
                        if (x - 1 >= 0 && y + 1 < n) {
                            if (M[x - 1][y + 1] == 1) {
                                q.offer(new Pair(x - 1, y + 1));
                                M[x - 1][y + 1] = -1;
                            }
                        }
                        if (x - 1 >= 0 && y - 1 >= 0) {
                            if (M[x - 1][y - 1] == 1) {
                                q.offer(new Pair(x - 1, y - 1));
                                M[x - 1][y - 1] = -1;
                            }
                        }
                        if (x + 1 < m && y - 1 >= 0) {
                            if (M[x + 1][y - 1] == 1) {
                                q.offer(new Pair(x + 1, y - 1));
                                M[x + 1][y - 1] = -1;
                            }
                        }
                    }

                    area = Math.max(area, ans);
                    ans = 0;
                }
            }
        }
        return area;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int M[][] = { { 0, 0, 1, 1, 0 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1 } };

        // Function call
        System.out.println(largestRegion(M));
    }
}

