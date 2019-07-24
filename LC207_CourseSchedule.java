package leetcode_study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Q. There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 
 * you have to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, 
 * is it possible for you to finish all courses?
 * 
 * Input: 2, [[1,0]], Output: true
 * Input: 2, [[1,0],[0,1]], Output: false
 * 
 * 
 * [Approach] Topological Sorting
 * 1. populate the data 
 *  -> build adjList.
 *  -> build indegree array.
 *  
 * 2. init queue & hashset with indegree-0 idx.
 * 
 * 3. bfs: while queue is not empty,
 *    - poll
 *    - iterate through neighbors 
 *       - indegree--
 *       - if it's 0? offer to the queue. add to visited.
 * 
 * 4. check visited size.
 * 
 * @author Sunny Park
 *
 */
public class LC207_CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] data) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        
        // d[1] => d[0]
        for (int[] d : data) {
            adjList.get(d[1]).add(d[0]);
            indegree[d[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
                visited.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adjList.get(curr)) {
                if (--indegree[next] == 0) {
                    q.offer(next);
                    visited.add(next);
                }
            }
        }
        
        return visited.size() == numCourses;
    }
    
    public static void main(String[] args) {
        int[][] arr1 = {{1,0}};
        int[][] arr2 = {{1,0},{0,1}};
        System.out.println(canFinish(2, arr1));
        System.out.println(canFinish(2, arr2));
    }
}
