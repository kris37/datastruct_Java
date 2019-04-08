package punch.day13.task;

/**
 * Created with IntelliJ IDEA.
 *
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     并查集
 *     Disjoint Set 不交集的 查找及union 合并
 *     find 是查找两个元素 是否属于同一个集合
 *     union 将集合合并
 * <br>
 */
public class UnionFindSet {
    // i 表示节点的数值 roots[i] 表示 父亲节点的数值
    private int[] roots;
    public UnionFindSet(int N){
        roots = new int[N];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
    }

    public int findRoot(int v){
        while (v != roots[v]){
            v = roots[v];
        }
        //
        while (){

        }
    }

    public void union (x,y){

    }
}
