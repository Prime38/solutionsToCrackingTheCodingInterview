package linkedList;

public class Intersection {
    static class Result{
        int len;
        Node tail;
        Result(int len,Node tail){
            this.len=len;
            this.tail=tail;
        }
    }
    static Result findLenAndTail(Node head){
        int len=0;
        while(head!=null){
            len++;
            if(head.next==null){
                return new Result(len,head);
            }else {
                head=head.next;
            }
        }
        return new Result(len,head);
    }
    Node findIntersectingNode(Node head1, Node head2){
        Result result1=findLenAndTail(head1);
        Result result2=findLenAndTail(head2);
        if(result1.tail!=result2.tail) return null;
        if(result1.len>result2.len){
            for(int i=0;i<result1.len-result2.len;i++){
                head1=head1.next;
            }
        }else if(result1.len<result2.len){
            for(int i=0;i<result2.len-result1.len;i++){
                head2=head2.next;
            }
        }
        while(head1.next!=null){
            if(head1==head2) return head1;
            head1=head1.next;
            head2=head2.next;
        }
        return null;
    }
}
