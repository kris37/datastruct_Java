### todo list
* AVL Tree 自行手写
    * AVL 树高度平衡树,要求的是左右子树之间的高度相差 <= 1
    * 依据以上可以推出一颗 N层的AVL树最小的节点数是 f(N) = f(N-1) + f(N-2) +1 类似于斐波纳切数
* RBTree模仿,实现 RBTree & 区间树 理解区间树的应用
    * RBTree 性质
        1. R 节点子节点不能为R(R 节点的父亲节点不能为R)
        2.  Root 节点和 leaf 节点为黑色(Nil) 
        3.  从Root节点到 leaf 节点(Nil)的所有路径经过的黑色节点数相同
    * 红黑树的Insert：
        1. 插入的节点都是红色的(这样做的好处是【不会增加某一路径的黑色节点数】)
        2. 假设插入后节点为 x, 一直找到root节点或者 x节点的颜色是黑色截止(!= RED) 
        while(x != root && color[x] == RED){
            do(recolor or rotation)
            x = update(x)
        }
        root.color = black;
        
* Sweep Line 算法 扫描线算法的应用(Google Alarm Log,判断点是否被多边形内)
* SkipList