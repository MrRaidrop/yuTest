import org.junit.Test;

public class Leetcode19 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
     ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        while (n > 0) {
            cur = cur.next;
            n--;
        }
        if (cur == null) {
            return head.next;
        }
        ListNode waitToBeDel = head;
        while (cur.next != null) {
            cur = cur.next;
            waitToBeDel = waitToBeDel.next;
        }
        if (waitToBeDel.next!=null) {
            waitToBeDel.next = waitToBeDel.next.next;
        }
        return head;
    }
    

    @Test
     public void test() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4,five);
        ListNode three = new ListNode(3,four);
        ListNode two = new ListNode(2,three);
        ListNode one = new ListNode(1,two);
        ListNode nulltest = new ListNode(1);
        ListNode res = removeNthFromEnd(nulltest, 1);
        ListNode cur = res;
        System.out.println(cur.equals(null));
//        while (cur!= null) {
//            System.out.println(cur.val);
//            cur = cur.next;
//        }

    }
}
