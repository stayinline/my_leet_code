package offer;


public class Case35 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }



    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        for (Node cur = head; cur != null; cur = cur.next.next) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
        }
        for (Node cur = head; cur != null; cur = cur.next.next) {
            Node copy = cur.next;
            copy.random = (cur.random != null) ? cur.random.next : null;
        }

        Node head2 = head.next;
        for (Node cur = head; cur != null; cur = cur.next) {
            Node copy = cur.next;
            cur.next = copy.next;
            copy.next = copy.next == null ? null : copy.next.next;
        }
        return head2;
    }

}
