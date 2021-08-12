package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Case138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 记录旧节点和新节点的映射关系
    Map<Node, Node> cachedNodeMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 如果当前结点的新节点不在Map中，说明还没创建出来，
        if (!cachedNodeMap.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNodeMap.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNodeMap.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        // 复制一个节点，链接到旧节点之后
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }

        cur = head;
        // 复制随机指针
        while (cur != null) {
            Node copy = cur.next;
            copy.random = (cur.random != null) ? cur.random.next : null;
            cur = cur.next.next;
        }
        Node headNew = head.next;
        cur = head;

        // 切分链表
        while (cur != null) {
            Node nodeNew = cur.next;
            cur.next = cur.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
            cur = cur.next;
        }
        return headNew;
    }

    public static void main(String[] args) {
        System.out.println(1 << 13);
    }


}
