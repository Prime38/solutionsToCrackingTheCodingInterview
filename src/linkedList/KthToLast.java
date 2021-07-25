package linkedList;

public class KthToLast {
    //book solution 4 -> best solution in my opinion
    Node kthFromLast(Node head, int k){
        Node p1=head;
        Node p2=head;
        // move o1 k nodes into the list
        for(int i=0;i<k;i++){
            if(p1==null) return null;
            p1=p1.next;
        }
        //move p1 and p2 at same pace. when p1 hits the end, p2 will be at the right element
        while(p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }


    // book solution 3
    static class Index{
        public int val=0;
    }
    static Node kthToLast(Node head, int k){
        Index idx=new Index();
        return kthToLast(head,k,idx);
    }
    static Node kthToLast(Node head, int k, Index idx){
        if(head==null) return null;
        Node node=kthToLast(head.next,k,idx);
        idx.val++;
        if (idx.val==k){
            return head;
        }
        return node;
    }

    // book solution 1
    static int printKthToLast(Node head, int k){
        if(head==null) return 0;
        int index=printKthToLast(head.next,k)+1;
        if(index==k){
            System.out.println(k+ "th last node is "+head.data);
        }
        return index;
    }

    //my solution
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
        printKthToLast(list.head,3);
        System.out.println(kthToLast(list.head,3).data);
    }
}
