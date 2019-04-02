### todo list
* AVL Tree 自行手写
    * AVL 树高度平衡树,要求的是左右子树之间的高度相差 <= 1
    * 依据以上可以推出一颗 N层的AVL树最小的节点数是 f(N) = f(N-1) + f(N-2) +1 类似于斐波纳切数
* RBTree模仿,实现 RBTree & 区间树 理解区间树的应用
    * RBTree 性质
        1. R 节点子节点不能为R(R 节点的父亲节点不能为R)
        2.  Root 节点和 leaf 节点为黑色(Nil) 
        3.  从Root节点到 leaf 节点(Nil)的所有路径经过的黑色节点数相同
* Sweep Line 算法 扫描线算法的应用(Google Alarm Log,判断点是否被多边形内)
* SkipList