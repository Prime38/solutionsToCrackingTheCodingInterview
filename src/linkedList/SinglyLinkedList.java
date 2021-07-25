package linkedList;

public class SinglyLinkedList<T> {
    Node head, tail;

    public SinglyLinkedList(Node head) {
        this.head = head;
    }
    public SinglyLinkedList(T headData) {
        this.head = new Node(headData);
    }

    public void addNodeLast(Node node) {
        if (this.head == null) {
            this.head = node;
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    public void addNodeLast(T val) {
        if (this.head == null) {
            this.head = new Node(val);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(val);
        }
    }

    public void addNodeFirst(Node node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next=this.head;
            this.head=node;
        }
    }
    public void addNodeFirst(T val) {
        if (this.head == null) {
            this.head = new Node(val);
        } else {
            Node node=new Node(val);
            node.next=this.head;
            this.head=node;
        }
    }

    public Node findNodeByValue(T val) {
        if (this.head == null) return null;
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == val) return cur;
        }
        return null;
    }

    public void deleteNode(Node del) {
        if (this.head == null) return;
        else if (this.head == del) {
            if (this.head.next != null) {
                this.head = this.head.next;
            } else {
                this.head = null;
            }
            return;
        }
        Node cur = this.head;
        while (cur.next != null ) {
            if(cur.next!=del){
                cur = cur.next;
            }else{
                cur.next=cur.next.next;
            }
        }
    }
    public void deleteNodeByVal(T val) {
        if (this.head == null) return;
        else if (this.head.data == val) {
            if (this.head.next != null) {
                this.head = this.head.next;
            } else {
                this.head = null;
            }
            return;
        }
        Node cur = this.head;
        while (cur.next != null ) {
            if(cur.next.data!=val){
                cur = cur.next;
            }else{
                cur.next=cur.next.next;
            }
        }
    }
    public void print(){
        StringBuilder sb=new StringBuilder();
        Node cur=this.head;
        while(cur!=null){
            sb.append(cur.data+" ");
            cur=cur.next;
        }
        System.out.println(sb.toString());
    }

}
