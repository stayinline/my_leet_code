package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class AC {

    private AcNode root = new AcNode('/');

    public void insert(char[] text) {
        AcNode p = root;
        for (int i = 0; i < text.length; i++) {
            char c = text[i];
            int index = c - 'a';
            if (p.children[index] == null) {
                AcNode newNode = new AcNode(c);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] text) {
        AcNode p = root;
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

    public void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            for (int i = 0; i < 26; ++i) {
                AcNode pc = p.children[i];
                if (pc == null) continue;
                if (p == root) {
                    pc.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (q != null) {
                        AcNode qc = q.children[pc.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    public static class AcNode {

        // 存储当前的字母
        public char data;

        // 指向下一节点的指针数组
        public AcNode[] children;

        public AcNode fail;

        // 是否为结束字符
        public boolean isEndingChar;


        public AcNode(char data) {
            this.data = data;
            // 用26个字母
            children = new AcNode[26];
        }
    }


    public static void main(String[] args) {

        String[] arr = {"hello", "her", "how", "so", "see"};
        AC AC = new AC();
        for (String s : arr) {
            AC.insert(s.toCharArray());
        }
        System.out.println(AC);

    }
}
