package practice;

public class KNodeReverse {
    public ListNode reverseKGroup(ListNode head, int k) {
        //定义一个伪节点，用来返回结果
        ListNode dump = new ListNode(0);
        //将伪节点与链表的头节点相连。
        dump.next = head;
        //要反转链表头节点的上一个节点，将prev和end，先指向同一个位置
        //都指向要反转链表的头节点的上一个节点
        ListNode prev = dump;
        //要反转链表尾节点，
        ListNode end = dump;
        //end.next ！=null 表示链表到达链表的尾节点
        while (end.next != null) {
            //循环k 次，将end节点移动 k 步。end！=null，是为了防止 end=end.next报空指针。
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //当不足k倍时，不反转剩余链表的节点
            if (end == null) break;
            //反转链表的头部
            ListNode start = prev.next;
            //反转链表尾部指向的节点，先存储起来，为了内在反转后，能重新连接上未反转的链表
            ListNode next = end.next;
            //断开，要反转的链表和其余链表的连接
            end.next = null;
            //反转后，先连接上头节点。
            prev.next = reverse(start);
            //在连接尾节点，与不反转链表节点的连接
            start.next = next;
            //将prev，换成下次要反转链表头节点的上一个节点
            prev = start;
            //将end，也换成要反转链表头节点的上一个节点
            end = prev;
        }
        //返回伪节点的上一个节点
        return dump.next;
    }

    //反转链表
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        //定义一个要反转的节点
        ListNode cur = head;
        while (cur != null) {
            //用来连接反转后的链表节点，定义一个反转节点的下一个节点
            ListNode next = cur.next;
            //将第一个节点的指向，反转
            cur.next = prev;
            //将prev移动到，要反转节点的上一个节点
            prev = cur;
            //将cur，移动到要下一个要反转的节点
            cur = next;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
