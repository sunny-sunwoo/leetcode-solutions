package leetcode_study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class LC695_MaxAreaOfIsland {
        // using bfs.
        /**
        Queue. q
        HashSet. visited
        
        linear scan on grid.
        if curr is 1, add to the q.
        keep maxArea
        bfs.
         - poll,
         - area + 1
         - check neighbors 
             => if visited? continue.
             => if withinValidRange && 1 ? offer to the q.

        */
    public static int maxAreaOfIsland(int[][] grid) {
        Queue<Point> q = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                Point curr = Point.of(i,j);
                if (visited.contains(curr)) {
                    continue;
                }
                q.offer(curr);
                visited.add(curr);
                int area = bfs(q, visited, curr, grid);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    
    private static int bfs(Queue<Point> q, Set<Point> visited, Point curr, int[][] grid) {
        int area = 0;
        while (!q.isEmpty()) {
            Point top = q.poll();
            area++;
            for (Point neighbor : top.getNeighbors()) {
                if (visited.contains(neighbor)) continue;
                if (neighbor.isValidRange(grid.length, grid[0].length) && grid[neighbor.y][neighbor.x] == 1) {
                    q.offer(neighbor);
                    visited.add(neighbor);
                }  
            }
        }
        return area;
    }
        
        private static class Point {
            int y;
            int x;
            
            Point(int y, int x) {
                this.y = y;
                this.x = x;
            }
            
            static Point of(int y, int x) {
                return new Point(y, x);
            }
            
            boolean isValidRange(int yBound, int xBound) {
                if (y < 0 || x < 0) return false;
                return (y < yBound) && (x < xBound);
            }
            
            List<Point> getNeighbors() {
                return Arrays.asList(Point.of(y + 1, x), Point.of(y - 1, x),
                                    Point.of(y, x + 1), Point.of(y, x - 1));
            }
            
            @Override
            public int hashCode() {
                return Objects.hash(y,x);
            }
            
            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Point)) return false;
                Point p = (Point) obj;
                return p.y == this.y && p.x == this.x;
            }
        }
        
        public static void main(String[] args) {
            int[][] grid = {{0, 0, 0, 1}, {0, 0, 1, 1}};
            System.out.print(maxAreaOfIsland(grid));
        }
    
}
