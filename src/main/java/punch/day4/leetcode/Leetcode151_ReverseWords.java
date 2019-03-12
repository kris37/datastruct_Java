package punch.day4.leetcode;

import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-10 16:21
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode151_ReverseWords {
    public String reverseWords(String s) {
        char blank = ' ';
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length];
        int index = 0;
        boolean first = true;
        for (int i = 0 ,j = 0; i < chars.length; ) {

            while ( i < chars.length &&
                    chars[i] == blank){
                i++;
            }
            j = i;
            while (i < chars.length &&
                    chars[i] != blank){
                i++;
            }

            // boundary i== j 说明到结尾了而且 没有找到非空白字符
            if(i != j){
             if(first) {
                 first = false;
             }else {
                 res[index++] = blank;
             }
             index = fillByReverse(chars,j,i,res,index);
            }
        }



        swap(res,0,index);
        return new String(res,0,index);
    }

    /**
     *
     * @param src
     * @param l
     * @param r
     * @param tar
     * @param index
     */
    private  int  fillByReverse(char[] src,int l,int r,char[] tar,int index){
        while (r > l){
            r--;
            tar[index++] = src[r];
        }
        return index;
    }

    private void swap(char[] chars,int from,int to){
        while (from < to){
            to --;
            char tmp =  chars[to];
            chars[to] = chars[from];
            chars[from] = tmp;
            from++;
        }
    }

    public static void  main(String [] args){
        new Leetcode151_ReverseWords().reverseWords("the sky is blue");
    }
}
