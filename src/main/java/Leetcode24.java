import org.junit.Test;

public class Leetcode24 {
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
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode sen = new ListNode(-1, head);
        ListNode cur = sen;

        while (cur.next!=null && cur.next.next!=null){
            ListNode cur1 = cur.next;
            ListNode cur2 = cur.next.next;
            cur.next = cur2;
            cur1.next = cur2.next;
            cur2.next = cur1;
            cur = cur1;
        }
        return sen.next;
    }

    @Test
    public void test() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4,five);
        ListNode three = new ListNode(3,four);
        ListNode two = new ListNode(2,three);
        ListNode one = new ListNode(1,two);
        ListNode nulltest = new ListNode(1);
        ListNode cur = swapPairs(one);
        while (cur!= null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

    }
}
