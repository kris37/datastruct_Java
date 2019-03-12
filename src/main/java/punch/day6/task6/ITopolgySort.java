package punch.day6.task6;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-12 08:55
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class ITopolgySort {


    /**
     * 判定是否为 DAG
     * 1. kahn 方法每次 轮训依次 删除 入度为一的点 直到最后队列为空
     * 2. dfs 遍历标记访问过的 顶点，直到
     *
     * 根据入度来进行处理，最后也能判定是否为DAG
     * 这里使用邻接矩阵处理
     * @return
     */
    public static List<Character> kahnSort(IGraph.AdjMatrixGraph adj){
        // row is income
        int[][] graph = adj.cloneAdj();
        /**
         *  col
         *
         *  x x x x x  row
         *  x x x x x
         *  x x x x x   ==>
         *  x x x x x
         *  x x x x x
         *
         *  每次遍历 rows for each is 0 end
         *
         */

        return null;
    }

    /**
     * 依照dfs 遍历进行拓补排序
     * @return
     */
    public static List<Character> dfsSort(IGraph.AdjTable adj){
        LinkedList<Character> stack = new LinkedList<Character>();
        Map<Character,Integer> visited = new HashMap<>(adj.getAdj().size());
        for (Character ch : adj.getAdj().keySet()) {
            dfs(ch,adj,visited,stack);
        }

        return stack;
    }

    private static void dfs(Character ch, IGraph.AdjTable adj, Map<Character,Integer> visited, LinkedList<Character> stack){
        if(visited.containsKey(ch)){
            if(visited.get(ch) == 0) throw new IllegalStateException(ch +" exist cycle, please check graph ");
            return;
        }else {
            visited.put(ch,0);
            List<IGraph.Vertex> linked = adj.getLinked(ch);
            if(linked != null) {
                for (IGraph.Vertex vertex : linked) {
                    dfs(vertex.getMark(), adj, visited, stack);
                }
            }

        }
        // mark finished loop
        stack.push(ch);
        visited.put(ch,1);
    }


    /**
     * dfs 遍历
     * @return
     */
    public static List<Character> dfs(){
        return null;
    }

    /**
     *  bfs 遍历
     */
    public static List<Character> bfs(){
        return null;
    }


    public static void main(String []args){
        //graph.addDirectEdge("f","c");

        char [] chs = {'a','b','c','d','e','f','g','h'};
        String [] link = {"o,a","b,a","a,c","a,d","d,e","e,h","c,g","g,f","f,c"};
        IGraph.AdjTable adjTable = new IGraph.AdjTable(chs,link,true);
        List<Character> characters = dfsSort(adjTable);
        characters.forEach(c -> System.out.print(c + " -> "));

    }

}
