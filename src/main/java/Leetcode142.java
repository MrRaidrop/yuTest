public class Leetcode142 {
// 环形链表 II 并输出头
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast==slow) {
                ListNode forward = head;
                ListNode back = fast;
                while (forward!=null) {
                    if (forward == back) {
                        return forward;
                    }
                    forward = forward.next;
                    back = back.next;
                }
            }
        }
        return null;
    }
}
