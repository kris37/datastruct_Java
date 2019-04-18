package punch.day16.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-17 16:57
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode5_LPS {
    /**
     *

     foreach i,j > = i
     if(@i == @j){
     if(j - i <= 1) dp[i][j] = true;
     else dp[i][j] = dp[i+1][j-1];
     }else{
     dp[i][j] = false;
     }

     */

    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0,end =0, max = 0;
        for (int j = 0; j < s.length() ; j++) {
            for (int i = j; i >= 0 ; i--) {
               if(i ==j ||s.charAt(i) == s.charAt(j)) {
                    // s[i] == s[j]
                    if(j - i <= 2){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                   dp[i][j] = false;
               }
               //
                if(dp[i][j]){
                    if(max < j-i){
                        max = j-i;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }

}

