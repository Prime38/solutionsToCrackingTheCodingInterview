package linkedList;

public class DeleteMiddleNode {
    static void delete(Node node){
        if(node==null || node.next==null) return;
        node.data=node.next.data;
        node.next=node.next.next;
    }


    public static void main(String[] args) {
        SinglyLinkedList<Integer> list=new SinglyLinkedList<>(1);
        list.addNodeLast(1);
        list.addNodeLast(2);
        list.addNodeLast(3);
        list.addNodeLast(4);
        list.addNodeLast(4);
        list.addNodeLast(5);
        list.addNodeLast(5);
        list.addNodeLast(1);
        list.addNodeLast(9);
        list.addNodeLast(8);
        list.addNodeLast(7);
        list.print();
        delete(list.head.next.next.next);
        list.print();
    }

}
