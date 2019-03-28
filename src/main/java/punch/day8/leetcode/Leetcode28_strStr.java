package punch.day8.leetcode;

/**
 * Created with IntelliJ IDEA.
 *

 * @version punch
 * Date: 2019-03-28 20:40
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     字符串匹配
 *     实现KMP 算法
 * <br>
 */
public class Leetcode28_strStr {

    /**
     *  进行比较 当 s[i] != p[j] 的时候查询 j = next[j-1] 相等 继续 否则j 继续跳转直到 j= 0
     * @param s
     * @param p
     * @return
     */
    public int strStr(String s, String p) {

        if(p.length() > s.length()) return -1;
        if(p.length() == 0) return 0;
        int i = 0,j=0;
        // j 指向 needle 跳出时 说明已经匹配了
        int[] next = nextAC(p);
        while (j < p.length()){
            if(i >= s.length()) return -1;
            if(s.charAt(i) == p.charAt(j) || j == 0){
                i++;
                j++;
            }else {
                j = next[j-1];
            }
        }
        return i - j;
    }





    /**
     *  生成子串的 next 状态机数组
     *  目的就是为了找出字串的前后缀之间的状态跳转，避免 主串的回溯
     *  refer https://www.bilibili.com/video/av3246487?from=search&seid=4444494996401793907
     * @param p
     * @return
     */
    public static int[] nextAC(String p){
        if(p.length() == 1) return new int[0];
        // i ,j 表示在p中跳转索引
        int i = 0,j =1;
        int[] next = new int[p.length()];
        do {
            if(p.charAt(i) == p.charAt(j)){
                next[j++] = ++i;
            }else {
                if(i > 0){
                    i = next[i-1];
                }else {
                    next[j++] = 0;
                }
            }
        } while (j < p.length());
        return next;
    }

    public static void main(String [] args){
        String s = "aabaabaaa";
        int[] ints = nextAC(s);
        for (int anInt : ints) {
            System.out.print(anInt + "-> ");
        }

    }
}
