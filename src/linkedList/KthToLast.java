package linkedList;

public class KthToLast {
    static Node findKthToLast(SinglyLinkedList<Integer> linkedList, int k){
        int total=0;
        Node cur=linkedList.head;
        while(cur!=null){
            total++;
            cur=cur.next;
        }
        int count=0;
        cur=linkedList.head;
        while(count!=(total-k)){
            count++;
            cur=cur.next;
        }
        return cur;
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
        System.out.println(findKthToLast(list,3).data);
    }
}
