package medium.p2.addTwoNumbers;




public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode currentNode = head;
        int ten = 0;

        while (!(l1 == null && l2 == null && ten == 0)) {
            int l1Value = l1 == null ? 0 : l1.val;
            l1 = l1 == null ? l1 : l1.next;

            int l2Value = l2 == null ? 0 : l2.val;
            l2 = l2 == null ? l2 : l2.next;

            int value = ten + l1Value + l2Value;
            ten = value / 10;

            currentNode = currentNode.next = new ListNode(value % 10);
        }
        return head.next;
    }

}
