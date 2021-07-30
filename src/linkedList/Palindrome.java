package linkedList;

import java.util.Stack;

public class Palindrome {
    //book solution 1 -> reverse and compare
//    boolean isPalindrome(Node head){
//        return isEqual(head,reversedAndCloned(head));
//    }
    Node reversedAndCloned(Node node){
        Node reversedHead=null;
        while(node!=null){
            Node cur=new Node(node.data);
            cur.next=reversedHead;
            reversedHead=cur;
            node=node.next;
        }
        return reversedHead;

    }
    boolean isEqual(Node n1, Node n2){
        while(n1!=null && n2!=null){
            if(n1.data!=n2.data) return false;
            n1=n1.next;
            n2=n2.next;
        }
        return  n1==null && n2==null;
    }

    //book solution 2 -> iterative approach - very niceeeeee
    <T> boolean  isPalindrome(Node<T> head){
        Node<T> fast=head;
        Node<T> slow=head;
        Stack<T> stack=new Stack<>();
        while(fast!=null && fast.next!=null){
            stack.push(slow.data);
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        while(slow!=null){
            T top=(T)stack.pop();
            if(top!=slow.data) return false;
            slow=slow.next;
        }
        return true;
    }
    //book solution 3 -> recursive approach
    static class Result{
        public Node node;
        public boolean result;

        public Result(Node node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }
    static boolean isPal(Node head){
        int length=length(head);
        Result p=isPalRecurse(head,length);
        return p.result;
    }
    static Result isPalRecurse(Node head, int length){
        if(head==null || length<=0){ //even nodes
            return new Result(head,true);
        } else if(length==1){ //odd nodes
            return new Result(head.next,true);
        }
        //recurse on sublist
        Result res=isPalRecurse(head.next,length-2);
        return res;
    }

    static int length(Node head){
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }

    //book solution 3 -> recursive approach
    <T>boolean isPalind(Node<T> head){
        int len=length(head);
        Result p=isPalindRecurse(head, len);
        return p.result;
    }

    <T>Result isPalindRecurse(Node<T> head,int length){
        if(head==null|| length==0){
            return new Result(head,true);
        } else if(length==1){
            return new Result(head.next,true);
        }
        Result res=isPalindRecurse(head.next,length-2);
        if(!res.result||res.node==null){
            return res;
        }
        res.result=(head.data==res.node.data);
        res.node=res.node.next;
        return res;
    }

}
