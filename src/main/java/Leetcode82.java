import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leetcode82 {
    //给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(-101010101, head);
        ListNode pre = sentinel;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next!=null&&cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return sentinel.next;
    }

    @Test
    public void test() {
        ListNode six = new ListNode(5, null);
        ListNode five = new ListNode(3, six);
        ListNode four = new ListNode(3, five);
        ListNode three = new ListNode(1, four);
        ListNode two = new ListNode(1, three);
        ListNode one = new ListNode(1, two);
        //ListNode nulltest = new ListNode(1);
        ListNode cur = deleteDuplicates(one);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
