package medium.p2.addTwoNumbers;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString() {
        return val + (next == null ? "" : " -> " + next.toString());
    }
}