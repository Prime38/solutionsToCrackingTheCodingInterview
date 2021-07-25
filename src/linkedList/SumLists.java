package linkedList;

public class SumLists {
    //another solution is to reverse and add
    //book solution  - follow up
    static class PartialSum{
        public Node sum=null;
        public int carry=0;
    }
    static Node addLists(Node<Integer> l1, Node<Integer> l2){
        int len1=length(l1);
        int len2=length(l2);
        //add padding if necessary
        if(len1<len2) l1=padList(l1,len2-len1);
        if(len1>len2) l2=padList(l2,len1-len2);

        PartialSum sum=addListHelper(l1,l2);
        /* If there was a carry value left over, insert this at the front of the list.
             Otherwise, just return the linked list. */
        if(sum.carry==0) return sum.sum;
        else{
            Node result=insertBefore(sum.sum, sum.carry);
            return result;
        }
    }
    static PartialSum addListHelper(Node<Integer> l1, Node<Integer> l2){
        if(l1==null && l2==null){
            PartialSum sum=new PartialSum();
            return sum;

        }
        PartialSum sum=addListHelper(l1.next,l2.next);
        int val=sum.carry+l1.data+l2.data;
        Node fullresult=insertBefore(sum.sum,val%10);

        sum.sum=fullresult;
        sum.carry=val/10;
        return sum;
    }

    //add padding before the node
    static Node padList(Node l , int padding){
        Node head=l;
        for (int i=0;i<padding;i++){
            head=insertBefore(head,0);
        }
        return head;
    }
    static Node insertBefore(Node list, int data){
        Node node=new Node(data);
        if(list!=null){
            node.next=list;
        }
        return node;
    }
    static int length(Node head){
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }



    //book solution 1
//    Node addLists(Node<Integer> l1,Node<Integer> l2, int carry){
//        if(l1==null && l2==null & carry==0){
//            return null;
//        }
//        Node result=new Node(0);
//        int val=carry;
//        if(l1!=null){
//            val+=l1.data;
//        }
//        if(l2!=null){
//            val+=l2.data;
//        }
//        result.data=val%10;
//        if(l1!=null || l2!=null){
//            Node more=addLists(l1==null?null:l1.next,
//                    l2==null?null:l2.next,
//                    val>9?1:0);
//            result.next=more;
//        }
//        return result;
//    }

    //my solution
    static SinglyLinkedList<Integer> sumLists(SinglyLinkedList<Integer> list1, SinglyLinkedList<Integer> list2) {
        if(list1.head == null && list2.head == null) return null;
        if (list1.head == null) return list2;
        if (list2.head == null) return list1;
        Node<Integer> cur1 = list1.head;
        Node<Integer> cur2 = list2.head;
        Node<Integer> ans=new Node<>();
        Node<Integer> anshead=ans;
        int carry=0;
        while (cur1 != null || cur2 != null||carry==1) {
            ans.data=carry;
            if(cur1!=null){
                ans.data += cur1.data;
            }
            if(cur2!=null){
                ans.data += cur2.data;
            }
            carry=0;
            if(ans.data>9){
                carry=1;
                ans.data%=10;
            }
            if(cur1!=null) cur1=cur1.next;
            if(cur2!=null) cur2=cur2.next;
            if((cur1!=null&&cur1.next!=null)||(cur2!=null&&cur2.next!=null)||carry==1){
                ans.next=new Node();
                ans=ans.next;
            }
        }
        return new SinglyLinkedList<>(anshead);
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>(1);
        list1.addNodeLast(1);
        list1.addNodeLast(2);
        list1.addNodeLast(3);
        list1.addNodeLast(3);
        list1.print();

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>(1);
        list2.addNodeLast(9);
        list2.addNodeLast(6);
        list2.addNodeLast(8);
        list2.print();

//        sumLists(list1,list2).print();
        new SinglyLinkedList<Integer>(addLists(list1.head,list2.head)).print();
    }
}
