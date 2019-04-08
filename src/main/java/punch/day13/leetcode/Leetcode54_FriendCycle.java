package punch.day13.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     朋友圈问题
 *     并查集
 *     连通子图问题
 *     //
 *
 * <br>
 */
public class Leetcode54_FriendCycle {

    /**
     *
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        // bfs 遍历 i 将 col 索引加入 queue中
//        int total = 0;
//        boolean [] visited = new boolean[M.length];
//        for (int i = 0; i < M.length; i++) {
//            if(visited[i]) continue;
//            dfs(i,M,visited);
//            //bfs(i,M,visited);
//            total ++;
//        }
//        return total;

        return disjoinSet(M);

    }


    /**
     *  可以用着色的方式 类似于 200的岛屿问题
     *  dfs(BFS) 进行遍历拓展
     * @param M
     */
    private void bfs(int x,int [][] M,boolean[] visited){
       if(visited[x]) return;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(x);
        while (!queue.isEmpty()){
            Integer ele = queue.pollLast();
            if(visited[ele]) continue;
            for (int i = 0; i < M[ele].length; i++) {
                if(visited[i]) continue;
                if(M[ele][i] == 1)queue.add(i);
            }
            visited[ele] = true;
        }

    }

    private void dfs(int x,int [][] M,boolean[] visited){
        visited[x] = true;
        for (int i = 0; i < M[x].length; i++) {
            if(visited[i]) continue;
            if(M[x][i] == 1) dfs(i,M,visited);
        }
    }

    /**
     *  采用并查集的方式解决这种类似于
     *  连通子图的问题
     */
    private int disjoinSet(int[][] M){
        // 构建 roots ,parent[i] = i 每个数值初始化指向自己
        int []parent = new int[M.length ];
        int total = M.length;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        // find&union 连通图
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if(M[i][j] == 1){
                    total -= union(parent,i,j);
                }
            }
        }
        return total;





    }

    /**
     *   查找 x 的 根
     * @param roots
     * @param x
     * @return
     */
    private int getRoot(int[] roots,int x){
        while (x != roots[x]){
            x = roots[x];
        }
        return x;
    }

    private int union(int[] roots,int x,int y){
        if(x == y) return 0 ;
        int rootx = getRoot(roots,x);
        int rooty = getRoot(roots,y);
        if(rootx == rooty) return 0 ;
        // 优化避免成为单链,正常需要记录每个 i 的rank[rootx] rank[rooty]
        if(Math.random() > 0.5f){
            roots[rootx] = rooty;
        }else {
            roots[rooty] = rootx;
        }
        return 1;
    }

}
