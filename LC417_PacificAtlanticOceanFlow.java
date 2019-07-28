package leetcode_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, 
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" 
 * touches the right and bottom edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a cell 
 * to another one with height equal or lower.
 * 
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * 
 * 
 * [Approach] dfs
 * 0. using 2d boolean arrays for pacific. atlantic. 
 *    -> fill true values for possible cells.
 *    
 * 1. starting from left/top edges -> dfs for pacific
 * 2. starting from right/bottom edges -> dfs for atlantic
 * 
 * 3. build result looking for cells with true values from both arrs.
 * 
 * => Helper method for dfs
 *    params: boolean arr, matrix arr, starting point info, min value to check.
 *  
 *    1. check bound.
 *    2. check if it's already true.
 *    3. if curr cell >= min
 *        -> dfs calls to the 4 neighbors.
 * 
 * @author Sunny Park
 *
 */
public class LC417_PacificAtlanticOceanFlow {
    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<>();
        
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            dfs(pacific, matrix, i, 0, Integer.MIN_VALUE);
            dfs(atlantic, matrix, i, matrix[0].length - 1, Integer.MIN_VALUE);
        }
        
        for (int j = 0; j < matrix[0].length; j++) {
            dfs(pacific, matrix, 0, j, Integer.MIN_VALUE);
            dfs(atlantic, matrix, matrix.length - 1, j, Integer.MIN_VALUE);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    
    private static void dfs(boolean[][] cache, int[][] matrix, int row, int col, int min) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) return;
        if (cache[row][col]) return;
        int curr = matrix[row][col];
        if (curr >= min) {
            cache[row][col] = true;
            dfs(cache, matrix, row + 1, col, curr);
            dfs(cache, matrix, row - 1, col, curr);
            dfs(cache, matrix, row, col + 1, curr);
            dfs(cache, matrix, row, col - 1, curr);
        }
    }
    
    public static void main(String[] args) {
        
    }
}
