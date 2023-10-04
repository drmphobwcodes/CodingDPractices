package Day2LinkedList;

public class DetectCycleLinkedList {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) { // fast.next != null is to check if fast.next.next is null
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                ListNode slow2 = head;

                while(slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }

                return slow;
            }
        }

        return null;
    }
}
