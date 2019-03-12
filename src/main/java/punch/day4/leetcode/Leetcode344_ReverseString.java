package punch.day4.leetcode;

/**
 * Created with IntelliJ IDEA.
 * @version punch
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode344_ReverseString {

    public void reverseString(char[] s) {
        int i = 0,j = s.length-1;
        while (i < j){
            swap(s,i,j);
            j--;
            i++;
        }

    }

    private void swap(char[] s,int i,int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

}
