package linkedList;

public class Node<T> {
    T data;
    Node next;

    public Node(T val) {
        this.data = val;
        this.next=null;
    }

    public Node(T val, Node next) {
        this.data = val;
        this.next = next;
    }
}
