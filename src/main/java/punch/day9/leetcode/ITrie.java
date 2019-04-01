package punch.day9.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-31 12:25
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     数组构建字典树
 *
 * <br>
 */
public class ITrie {

    private class Node{
        boolean isEnd = false;
        char ch;
        Node []sub = new Node[26];
        public Node(char ch) {
            this.ch = ch;
        }

        public Node(boolean isEnd,char ch) {
            this(ch);
            this.isEnd = isEnd;
        }
    }
    private Node root ;
    /** Initialize your data structure here. */
    public ITrie() {
        root = new Node(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Node node = cur.sub[word.charAt(i) - 'a'];
            if(node == null){
                node = new Node(word.charAt(i));
                cur.sub[word.charAt(i) - 'a'] = node;
            }
            cur = node;
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.length() == 0) return true;
        Node cur = root;
        for (int i = 0; i < word.length() ; i++) {
            cur = cur.sub[word.charAt(i) - 'a'];
            if(cur == null ) return false;
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.length() == 0) return true;
        Node cur = root;
        for (int i = 0; i < prefix.length() ; i++) {
            cur = cur.sub[prefix.charAt(i) - 'a'];
            if(cur == null ) return false;
        }
        return true;

    }

}
