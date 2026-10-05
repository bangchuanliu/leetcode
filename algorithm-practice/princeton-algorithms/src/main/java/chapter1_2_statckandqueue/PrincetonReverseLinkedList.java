package chapter1_2_statckandqueue;

public class PrincetonReverseLinkedList {

    public static PrincetonListNode reverse(PrincetonListNode first) {
        if (first == null || first.next == null) {
            return first;
        }

        PrincetonListNode p = first;
        PrincetonListNode next = null;

        while (p != null) {
            PrincetonListNode q = p.next;
            p.next = next;
            next = p;
            p = q;
        }
        return next;
    }


    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7};
        PrincetonListNode first = LinkedListUtil.createLinkedList(a);
        LinkedListUtil.printLinkedList(first);
        PrincetonListNode listNode = reverse(first);
        LinkedListUtil.printLinkedList(listNode);
        PrincetonListNode first2 = LinkedListUtil.createLinkedList(a);
        PrincetonListNode listNode2 = reverse(first2);
        LinkedListUtil.printLinkedList(listNode2);
    }
}
