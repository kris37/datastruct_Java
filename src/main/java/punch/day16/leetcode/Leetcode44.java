package punch.day16.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-18 20:21
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode44 {
    private static final char STAR = '*';
    private static final char QMARK = '?';
    public boolean isMatch(String s, String p) {
        //if(p.equals(s)) return true;
        if(p.length() == 0){
            return s.length() == 0;
        }


        // dp[i][j] 表示 s[0:i] is or not matches p[0:j]
        //init
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        // if(p.charAt(0) == STAR){
        //     for (int i = 0; i <= s.length(); i++) {
        //         dp[i][1] = true;
        //     }
        // }else if(match(s.charAt(0),p.charAt(0))){
        //     dp[1][1] = true;
        // }

        for (int j = 1; j <= p.length() ; j++) {
            for (int i = 0; i <= s.length(); i++) {
                if(i == 0 ){
                    if(p.charAt(j-1) == STAR ){
                        dp[i][j] = dp[0][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                    continue;
                }
                if(match(s.charAt(i-1),p.charAt(j-1))){
                    dp[i][j] = dp[i-1][j-1];
                    if(p.charAt(j-1) == STAR) dp[i][j] = dp[i][j] || dp[i-1][j]||dp[i][j-1];
                }
            }
        }

        return dp[s.length()][p.length()];

    }

    private boolean match(char s,char p){
        return p == STAR || p == QMARK|| s==p ;
    }
}
