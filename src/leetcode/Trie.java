package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Trie {

    private TrieNode root = new TrieNode('/');

    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            char c = text[i];
            int index = c - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(c);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            char c = text[i];
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        if (p.isEndingChar) {
            return true;
        } else {
            return false;
        }
    }

    public static class TrieNode {

        // 存储当前的字母
        public char data;

        // 指向下一节点的指针数组
        public TrieNode[] children;

        // 是否为结束字符
        public boolean isEndingChar;


        public TrieNode(char data) {
            this.data = data;
            // 用26个字母
            children = new TrieNode[26];
        }
    }


    public static void main(String[] args) {

        String[] arr = {"hello", "her", "how", "so", "see"};
        Trie trie = new Trie();
        for (String s : arr) {
            trie.insert(s.toCharArray());
        }
        System.out.println(trie);

    }
}
