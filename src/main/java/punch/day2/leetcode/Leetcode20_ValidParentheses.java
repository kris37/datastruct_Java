package punch.day2.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-03 21:21
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     利用stack 的思想匹配括号
 *    return stack.empty();
 * <br>
 */
public class Leetcode20_ValidParentheses {

    private static Map<Character,Character> map = new HashMap<Character,Character>(){
        {
            put(']','[');
            put('}','{');
            put(')','(');
        }
    };

    /**
     *  Runtime: 4 ms, faster than 98.12% of Java online submissions for Valid Parentheses.
     * Memory Usage: 37.2 MB, less than 18.74% of Java online submissions for Valid Parentheses.
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if("".equals(s) || null == s) return true;
        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : chars) {
            if(map.containsKey(c)){
                 char left = map.get(c);
                 if(stack.isEmpty()) return false;
                 if(left == stack.pop()){
                         continue;
                 }else{
                     return false;
                 }

            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
