package punch.day6.task6;

import com.sun.xml.internal.ws.message.stream.StreamHeader11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-12 08:57
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class IGraph {

    /**
     *  邻接矩阵表示Graph
     *  对于带有权重的graph 在 adj 数组中 标记 1 替换为 weight
     */
    public static class AdjMatrixGraph{
        /**
         *
         * @param vertex {'A','B','C','D'}...
         * @param edge {'A,B','C,F'}
         * @param direct true 有向图
         *               false 无向图
         */

        private int [][]adj ;
        private HashMap<Character,Integer> vertexMap;
        public AdjMatrixGraph(char[] vertex,String [] edge,
                              boolean direct){

            for (int i = 0; i < vertex.length; i++) {
                this.vertexMap.put(vertex[i],i);
            }
            this.adj = new int[vertex.length][vertex.length];

            if(direct){
                buildDirectAdj( edge);
            }else {
                buildNoDirectAdj( edge);
            }
        }
        /**
         *  构建无向图
         */
        private void buildNoDirectAdj(String [] edge){
            for (String s : edge) {
                char[] split = s.toCharArray();
                if(split.length != 3) throw new IllegalArgumentException();
                Integer col = vertexMap.get(split[0]);
                Integer  row = vertexMap.get(split[2]);
                this.adj[col][row] = 1 ;
                this.adj[row][col] = 1;
            }

        }

        private void buildDirectAdj(String [] edge){
            for (String s : edge) {
                char[] split = s.toCharArray();
                if(split.length != 3) throw new IllegalArgumentException();
                Integer col = vertexMap.get(split[0]);
                Integer  row = vertexMap.get(split[2]);
                this.adj[col][row] = 1 ;
            }
        }

        public int[][] cloneAdj(){
            return this.adj.clone();
        }


        public int getWeight(char src,char tar){
            return this.adj[vertexMap.get(src)][vertexMap.get(tar)];
        }


    }


    public static class Vertex{
        private char mark;
        private int weight;

        public Vertex(char mark, int weight) {
            this.mark = mark;
            this.weight = weight;
        }

        public char getMark() {
            return mark;
        }

        public int getWeight() {
            return weight;
        }
    }

    /**
     * graph 邻接表表示方法
     * 带有weiht  默认为 1
     */
    public static class AdjTable{

        private HashMap<Character, List<Vertex>> adj;
        public AdjTable(char[] vertex,String [] edge,
                        boolean direct){
            this.adj = new HashMap<Character, List<Vertex>>(vertex.length << 1);
            if(direct){
                buildDirectAdj(edge);
            }else{
                buildNoDirectAdj(edge);
            }
        }

        /**
         *
         */
        private void  buildDirectAdj(String [] edge){
            for (String s : edge) {
                char[] chars = s.toCharArray();
                //default weight  = 1
                offer(chars[0],chars[2],1);
            }
        }

        /**
         *
         */
        private void  buildNoDirectAdj(String [] edge){
            for (String s : edge) {
                char[] chars = s.toCharArray();
                offer(chars[0],chars[2],1);
                offer(chars[2],chars[1],1);
            }
        }

        private void offer(char x,char y,int weight){
            if(adj.containsKey(x)){
                List<Vertex> vertices = adj.get(x);
                vertices.add(new Vertex(y,weight));
            }else {
                List<Vertex> vertices = new ArrayList<>();
                vertices.add(new Vertex(y,weight));
                adj.put(x,vertices);
            }
        }

        public List<Vertex> getLinked(char key){
            return this.adj.get(key);
        }

        public Map<Character, List<Vertex>> getAdj() {
            return adj;
        }
    }

}
