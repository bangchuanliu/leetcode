package leetcode.linkedlist;

import common.ListNode;

public class InsertIntoASortedCircularLinkedList {
    public ListNode insert(ListNode head, int insertVal) {
        if (head == null) {
            ListNode n = new ListNode(insertVal);
            n.next = n;
            return n;
        }

        ListNode p = head;
        while (p.next != head) {
            if ((p.val <= p.next.val && insertVal >= p.val && insertVal <= p.next.val) || (p.val > p.next.val && (insertVal <= p.next.val || insertVal >= p.val))) {
                ListNode n = new ListNode(insertVal);
                n.next = p.next;
                p.next = n;
                return head;
            }

            p = p.next;
        }

        ListNode n = new ListNode(insertVal);
        n.next = p.next;
        p.next = n;

        return head;

    }
}
