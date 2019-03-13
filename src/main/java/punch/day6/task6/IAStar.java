package punch.day6.task6;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-12 13:52
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     A* 算法 S -> T
 *     对于任意一点 n 权衡函数f(n) = g(S,n) + h(n,T)
 *     g(S,n) 从初S到任意结点n的代价 （走了多远）
 *     h(n,T) 是 预估 n -> T 的启发式估算 代价
 *
 *     1。 当 h(n,T) 的估算一直为 =0 即对任意一点启发式函数都不起作用 那么A* 就退化为 Dijkstra 算法
 *     2。 当 h(n,T) 一直远大与 g(n) 时，忽略g(n) 则 退化为 BFS 搜索
 *
 *
 *     实现思路是
 *     0。OPENList （ProrityQueue） CloseSet
 *     1. 确定对于任意一个点 n 到 T 的 h(n,T)
 *     2. g(S,n) 已经花费的代价
 *     3. Node(n,h,g)
 *     4. ProrityQueue 选出 h+g 最小的 节点 n
 *     5 节点 n 选出邻接表中的节点 x, if(x in closeSet && x.花费 < closet.(x)) remove x，x put open else pass
 *     6重复 4
 *
 * <br>
 */
public class IAStar {

}
