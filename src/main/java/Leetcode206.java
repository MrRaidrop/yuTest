import org.junit.Test;

public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    @Test
    public void test() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4,five);
        ListNode three = new ListNode(3,four);
        ListNode two = new ListNode(2,three);
        ListNode one = new ListNode(1,two);
        ListNode nulltest = new ListNode(1);
        ListNode cur = reverseList(nulltest);
        while (cur!= null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}
