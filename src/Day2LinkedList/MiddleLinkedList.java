package Day2LinkedList;

public class MiddleLinkedList {
    public <ListNode> ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) { // fast.next != null is to check if fast.next.next is null
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
