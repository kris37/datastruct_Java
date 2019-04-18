package punch.day15.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-15 08:48
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode210_CourseSchedule {
    /**
     *  toplogy sort and check circle
     *  1.使用kahn 出入度算法
     *  2.使用DFS 记录节点算法
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        LinkedList<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>(numCourses << 1);
        LinkedList<Integer>[] adj = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        for (int[] prerequisite : prerequisites) {
            adj[prerequisite[1]].add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(!findByDFS(i,visited,adj,stack)){
                return new int[0];
            }
        }
        int [] res = new int[numCourses];
        for (int i = 0 ;i < numCourses ;i++){
         res[i] = stack.pop();
        }
        return res;

    }

    /**
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private int[] findByKahn(int numCourses, int[][] prerequisites){
        // 一共n个课程
        //build adj
        LinkedList<Integer>[] adj = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        // [a,b] 表示 a 依赖于b 顺序应该是 b->a
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]] ++;
            adj[prerequisite[1]].add(prerequisite[0]);
        }
        int[] res = new int[numCourses];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int num = 0;
        while (!queue.isEmpty()){
            Integer first = queue.removeFirst();
            res[num++] = first;
            for (Integer integer : adj[first]) {
                // reduce indegree[next] --; if indegree [next] == 0 add queue
                indegree[integer] --;
                if(indegree[integer] == 0)queue.add(integer);
            }
        }
        return num == numCourses?res:new int[0];
    }

    private boolean findByDFS(int vertex, Map<Integer,Integer> visited, LinkedList<Integer> [] adj, LinkedList<Integer> stack){
        if(visited.containsKey(vertex)){

            // 访问过
            return visited.get(vertex) == 1;
        }else {
            // 没访问过
            if(adj[vertex].size() == 0){
                stack.push(vertex);
                visited.put(vertex,1);
                return true;
            }else {
                visited.put(vertex,0);
                for (Integer next : adj[vertex]) {
                   boolean ok =  findByDFS(next,visited,adj,stack);
                   if(!ok) return false;
                }
                stack.push(vertex);
                visited.put(vertex,1);
                return true;
            }
        }

    }
}
