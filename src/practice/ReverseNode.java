package practice;


public class ReverseNode {

    //以链表1->2->3->4->5举例
    public static Node reverse2(Node root){
        if (root == null) return null;
        Node curr = root;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }



    //以链表1->2->3->4->5举例
    public static Node reverseNode(Node root){
        if (root == null || root.next == null) return root;
        Node newRoot = reverseNode(root.next);
        root.next.next = root;
        root.next = null;
        return newRoot;
    }



    public static void main(String[] args) {
        Node root = new Node(1);
        root.appendValue(2).appendValue(3).appendValue(4).appendValue(5);

        Node root2 = reverse2(root);
        printNode(root2);
    }


    private static void printNode(Node root) {
        if (root == null) {
            return;
        }
        while (root != null){
            System.out.print(root.value + " ");
            root = root.next;
        }
    }

    /**
     * 以链表1->2->3->4->5举例
     *
     * @param head
     * @return
     */
    public static Node reverse1(Node head) {
        if (head == null || head.next == null) {
            /*
                直到当前节点的下一个节点为空时返回当前节点
                由于5没有下一个节点了，所以此处返回节点5
             */
            return head;
        }
        //递归传入下一个节点，目的是为了到达最后一个节点
        Node newHead = reverse1(head.next);
                /*
            第一轮出栈，head为5，head.next为空，返回5
            第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
                      把当前节点的子节点的子节点指向当前节点
                      此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
                      此时链表为1->2->3->4<-5
                      返回节点5
            第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
                      此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
                      此时链表为1->2->3<-4<-5
                      返回节点5
            第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
                      此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
                      此时链表为1->2<-3<-4<-5
                      返回节点5
            第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
                      此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
                      此时链表为1<-2<-3<-4<-5
                      返回节点5
            出栈完成，最终头节点5->4->3->2->1
         */
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static class Node {
        public Object value;
        public Node next;

        public Node(Object value, Node next) {
            this.value = value;
        }

        public Node(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


        public Node appendValue(Object value) {
            this.next = new Node(value);
            return this.next;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
