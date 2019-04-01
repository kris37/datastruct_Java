package punch.day9.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * Created with IntelliJ IDEA.
 * @version punch
 * Date: 2019-03-31 16:37
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     DFS + trie
 *     进行加速搜索
 * <br>
 */
public class Leetcode212_WordSearchII {

    private Set<String> result = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j < board[0].length;j++){
                dfs(i,j,trie.root,visited,board);
            }
        }
        return result.stream().collect(Collectors.toList());


    }

    private void dfs(int i , int j, Trie.TrieNode node, boolean[][] visited, char[][] board){
        if(visited[i][j] ){
            return;
        }
        if(!node.contains(board[i][j])) return;
        node = node.sub[board[i][j] - 'a'];
        if(node.isEnd){
            result.add(node.word);
        }
        visited[i][j] = true;
        // up
        if(j-1 >=0) dfs(i,j-1,node,visited,board);
        //down
        if(j+1 < visited[0].length) dfs(i,j+1,node,visited,board);
        //left
        if(i-1 >=0 ) dfs(i-1,j,node,visited,board);
        //right
        if(i+1 < visited.length) dfs(i+1,j,node,visited,board);
        visited[i][j] = false;

    }

    public static class Trie{
        private static class TrieNode{
            char ch ;
            boolean isEnd = false;
            private String word = null;
            TrieNode[] sub = new TrieNode[26];

            public TrieNode(char ch, boolean isEnd) {
                this.ch = ch;
                this.isEnd = isEnd;
            }
            public TrieNode(char ch){
                this(ch,false);
            }

            public boolean contains(char c){
                return this.sub[c -'a'] !=null;
            }
        }

        public Trie() {
            this.root = new TrieNode(' ',false);
        }
        private TrieNode root;
        public void insert(String str){
            TrieNode cur = root;
            for (int i = 0; i < str.length(); i++) {
                TrieNode node = cur.sub[str.charAt(i) - 'a'];
                if(node == null){
                    node = new TrieNode(str.charAt(i));
                    cur.sub[str.charAt(i) - 'a'] = node;
                }
                cur = node;
            }
            cur.isEnd = true;
            cur.word = str;
        }

        public boolean startwith(List<Character> list){
            TrieNode cur = root;
            for (char character : list) {
                cur = cur.sub[character - 'a'];
                if(cur == null) return false;
            }
            return true;
        }

        public boolean search(List<Character> list){
            TrieNode cur = root;
            for (char character : list) {
                cur = cur.sub[character - 'a'];
                if(cur == null) return false;
            }
            return cur.isEnd;
        }

    }

}
