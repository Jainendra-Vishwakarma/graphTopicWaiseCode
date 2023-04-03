import java.util.*;
class Solution {
    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int total = 0, rotten = 0, time = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    total++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        if (total == 0) {
            return 0;
        }
        while (! q.isEmpty()) {
            int size = q.size();
            rotten += size;

            if (rotten == total) {
                return time;
            }

            time++;

            for (int i = 0; i < size; i++) {
                Pair p = q.peek();

                if (p.x + 1 < grid.length && grid[p.x + 1][p.y] == 1) {
                    grid[p.x + 1][p.y] = 2;
                    q.offer(new Pair(p.x + 1, p.y));
                }
                if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1) {
                    grid[p.x - 1][p.y] = 2;
                    q.offer(new Pair(p.x - 1, p.y));
                }
                if (p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 1) {
                    grid[p.x][p.y + 1] = 2;
                    q.offer(new Pair(p.x, p.y + 1));
                }
                if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 1) {
                    grid[p.x][p.y - 1] = 2;
                    q.offer(new Pair(p.x, p.y - 1));
                }
                q.poll();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int grid[][] = {{2,1,0,2,1},
                       {1,0,1,2,1},
                       {1,0,0,2,1}};
        int ans = orangesRotting(grid);

        if(ans == -1){
            System.out.println("All oranges cannot rot");
        } else {
            System.out.println("Time required for all oranges to rot = " + ans);
        }

    }
}