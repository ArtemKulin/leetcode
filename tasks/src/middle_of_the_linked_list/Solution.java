package middle_of_the_linked_list;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode next = head.next;
        double counter = 1;
        while (next != null) {
            next = next.next;
            counter++;
        }
        int middle =  (int) (Math.floor(counter/2));
        ListNode result = head;
        while (middle != 0) {
            result = result.next;
            middle--;
        }
        return result;
    }
}
