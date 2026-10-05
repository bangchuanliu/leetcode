package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node p = head;

        while (p != null) {
            Node newNode = new Node(p.val);
            Node next = p.next;
            p.next = newNode;
            newNode.next = next;
            p = next;
        }


        Node newHead = head.next;
        p = head;

        while (p != null) {
            Node next = p.next.next;
            if (p.random != null) {
                p.next.random = p.random.next;
            }

            p = next;
        }

        p = head;
        Node p2 = head.next;

        while (p != null) {
            p.next = p2.next;
            p2.next = p2.next != null ? p2.next.next : null;
            p = p.next;
            p2 = p2.next;
        }

        return newHead;

    }


    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    ;
}
