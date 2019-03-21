package punch.day7.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-21 16:41
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     电话 2-9 构成的字母组合
 * <br>
 */
public class Leetcode17_LCPN {

    /**
     *
     * @param digits
     * @return
     */
    private static Map<Character,String [] >  dict = new HashMap<>();
    static {
        dict.put('2',new String[]{"a","b","c"});
        dict.put('3',new String[]{"d","e","f"});
        dict.put('4',new String[]{"g","h","i"});
        dict.put('5',new String[]{"j","k","l"});
        dict.put('6',new String[]{"m","n","o"});
        dict.put('7',new String[]{"p","q","r","s"});
        dict.put('8',new String[]{"t","u","v"});
        dict.put('9',new String[]{"w","x","y","z"});
    }

    private  List<String> result = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() < 1) return result;
        recursive(digits,0,"");
        return result;
    }

    private void recursive(String digits,int index,String pre){
        if(index >= digits.length()) {
            result.add(pre);
            return;
        }
        String[] array = dict.get(digits.charAt(index));
        for (String s : array) {
            recursive(digits,index+1,pre+s);
        }
    }
}
