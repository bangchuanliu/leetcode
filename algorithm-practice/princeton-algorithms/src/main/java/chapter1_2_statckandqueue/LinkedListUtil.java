package chapter1_2_statckandqueue;

public class LinkedListUtil {

    public static <Item> PrincetonListNode createLinkedList(Item[] a) {
        PrincetonListNode<Item> current = null;
        for (int i = a.length - 1; i >= 0; i--) {
            PrincetonListNode<Item> newListNode = new PrincetonListNode(a[i]);
            newListNode.next = current;
            current = newListNode;
        }
        return current;
    }

    public static void printLinkedList(PrincetonListNode first) {
        for (; first != null; first = first.next) {
            System.out.print(first.item + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5,6,7,8};
        PrincetonListNode first = createLinkedList(a);
        printLinkedList(first);
    }

}
