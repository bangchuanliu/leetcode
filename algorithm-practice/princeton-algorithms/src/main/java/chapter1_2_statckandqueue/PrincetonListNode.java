package chapter1_2_statckandqueue;

public class PrincetonListNode<Item> {
    
    public PrincetonListNode (Item item) {
        this.item = item;
        next = null;
    }
    
    public Item item;
    public PrincetonListNode<Item> next;
}
