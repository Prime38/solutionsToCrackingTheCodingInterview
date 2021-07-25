package linkedList;

public class Partition {
    static Node partiton(Node<Integer> node, int x){
        Node head=node;
        Node tail=node;
        while (node!=null){
            Node next=node.next;
            if(node.data<x){
                node.next=head;
                head=node;
            }else{
                tail.next=node;
                tail=node;
            }
            node=next;
        }
        tail.next=null;
        return head;
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
        list.head=partiton(list.head,4);
        list.print();
    }
}
