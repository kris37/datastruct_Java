package punch.day7.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-25 14:19
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     正则匹配
 *     状态转移 dp[i][j] 表示 p[0:i] 与 s[0:j] 是否匹配
 *
 *      for i in (0,len(p)):
 *          for j in (0,len(s)):
 *              dp[i][j] = (p[i]==star && (p[i-1] == DOT || dp[i-2][j]))
 *
 *
 * <br>
 */
public class Leetcode10_RegularExpressionMatching {
    private static final char DOT = '.';
    private static final char STAR = '*';

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;// 都为空 =true ,p 为空 s 不为空 都为false s为空 只有当 p[i] = * i>=1
        for (int i = 0; i <= p.length(); i++) {
            if (p.charAt(i) == STAR && dp[0][i-1]) dp[0][i+1] = true;
        }
        // 进行填充
        for (int i = 0; i < s.length() ; i++) {
            for (int j = 0; j < p.length() ; j++) {
                if(charMatch(s.charAt(i),p.charAt(j))){
                    dp[i+1][j+1] = dp[i][j];
                }else if(p.charAt(j) == STAR){
                    if (!charMatch(s.charAt(i),p.charAt(j-1))) {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        // case 3 match 0,1,或者多个
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }

            }
        }

        return dp[s.length()][p.length()];

    }


    private boolean charMatch(char s,char p){
        if(p == DOT) return true;
        return s == p;
    }
}
