package Day2LinkedList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null) {
            next = curr.next; // save next node
            curr.next = prev; // reverse
            prev = curr; // move prev to curr
            curr = next; // move curr to next
        }

        return prev;
    }
}
