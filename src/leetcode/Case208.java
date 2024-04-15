package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Case208 {
    class Trie {
        private Trie[] children;
        private boolean isEnd;


        /**
         * Initialize your data structure here.
         */
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;

        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }

    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    public static class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean isEnd;


        public TrieNode() {
            this.children = new HashMap<>();
            this.isEnd = false;

        }

        public void insert(String word) {
            TrieNode cur = this;
            for (Character c : word.toCharArray()) {
                TrieNode node = cur.children.get(c);
                if (null == node) {
                    node = new TrieNode();
                    cur.children.put(c, node);
                }
                cur = node;
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {

            TrieNode ret = find(word);

            return ret != null ? ret.isEnd : false;

        }

        public boolean startsWith(String prefix) {

            TrieNode ret = find(prefix);

            return ret != null;

            // return ret != null? true : false;
            //  if(ret==null){
            //     return false;
            //  }else{
            //     return true;
            //  }
        }

        public TrieNode find(String word) {

            TrieNode cur = this;
            for (Character c : word.toCharArray()) {
                TrieNode node = cur.children.get(c);
                if (null == node) {
                    return null;
                }
                cur = node;
            }
            return cur;
        }
    }


    public static void main(String[] args) {
        TrieNode trieNode = new TrieNode();

        trieNode.insert("hello");

        System.out.println(trieNode.search("hello"));
    }

}
