package Day2LinkedList;

public class IntersectionTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        while(currA != currB) {
            if(currA == null) {
                currA = headB;
            } else {
                currA = currA.next;
            }

            if(currB == null) {
                currB = headA;
            } else {
                currB = currB.next;
            }
        }

        return currA;
    }
}
