package punch.day15.task;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-14 08:41
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     字符串查找
 *     KMP 算法实现
 * <br>
 */
public class IKMP {


    /**
     *  构建子串的 状态机 数组
     * @param sub
     * @return
     */
    public static int[] buildNext(String sub){
        int[] next = new int[sub.length()];

        for (int i = 0,j = 1; j < sub.length() ; ) {
            if(sub.charAt(i) == sub.charAt(j)){
                next[j++] = ++i;
            }else {
               if(--i >= 0){
                   i = next[i];
               }else {
                   i = 0;
                   next[j++] = 0;
               }
            }
        }
        return next;

    }

    public static void main(String [] args){
        String s = "aabaabaaa";
        int[] ints = buildNext(s);
        for (int anInt : ints) {
            System.out.print(anInt + " -> ");
        }
    }
}
