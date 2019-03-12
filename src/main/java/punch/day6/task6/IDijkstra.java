package punch.day6.task6;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-12 13:52
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * 算法描述
 * 求 S -> N  的最短路径，或者 从 S ->空间中任意一点的最短路径
 *
 * 对于不含负权的有向图，这是当前已知的 [最快的单源最短路径算法]。
 * 贪心思想
 *  假设 S -> N 路径上的点 x  x -> N 一定也是最短路径
 *  可以由动态规划推演出来 =>
 * 1。开放最短路径优先算法在陆游中的应用
 * <br>
 */
public class IDijkstra {


    private static class Node{
        private char tag;
        private int dis;

        public Node(char tag, int dis) {
            this.tag = tag;
            this.dis = dis;
        }
    }
    /**
     * 记录路径 parent
     * 记录path 的长度
     * @param graph
     * @return
     */
    public static int dij(IGraph.AdjTable graph,char start,char tar) {
        List<IGraph.Vertex> linked = graph.getLinked(start);

        //
        Set<Character> visited = new HashSet<>();
        // 记录 src 到 当前 char 的最短距离
        Map<Character, Integer> distanceMap = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dis - o2.dis;
            }
        });
        if(linked == null) return -1;
        priorityQueue.add(new Node(start,0));

        while (!priorityQueue.isEmpty()){
            Node poll = priorityQueue.poll();
            if(distanceMap.getOrDefault(poll.tag,Integer.MAX_VALUE)
                    > poll.dis){
                distanceMap.put(poll.tag,poll.dis);
            }
            if(!visited.contains(poll.tag)){
                visited.add(poll.tag);
                for (IGraph.Vertex vertex : linked) {
                    priorityQueue.add(new Node(vertex.getMark(),vertex.getWeight()));
                }
            }
        }

        return distanceMap.getOrDefault(tar,-1);

    }



}
