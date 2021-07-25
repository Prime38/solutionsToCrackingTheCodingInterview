package linkedList;



public class RemoveDuplicates {
    //using hashtable
//    static void removeDups(SinglyLinkedList<Integer> linkedList){
//        HashSet<Integer> set=new HashSet<Integer>();
//        Node cur=linkedList.head;
//        set.add((Integer) cur.data);
//        while(cur.next!=null){
//            if(set.contains(cur.next.data)){
//                cur.next=cur.next.next;
//            }else{
//                set.add((Integer) cur.next.data);
//                cur=cur.next;
//            }
//        }
//    }
    //This code runs in O (1) space, but O (N^2) time
    static void removeDups(SinglyLinkedList<Integer> linkedList){
        Node cur=linkedList.head;
        while(cur!=null){
            Node runner=cur;
            while(runner.next!=null){
                if(cur.data==runner.next.data){
                    runner.next=runner.next.next;
                }else{
                    runner=runner.next;
                }
            }
            cur=cur.next;
        }
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
        list.print();



    }
}
