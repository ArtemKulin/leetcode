import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 * Constraints:
 *
 * n == number of nodes in the linked list
 * 0 <= n <= 104
 * -106 <= Node.val <= 106
 */



public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))));

        System.out.println(listNode);
        System.out.println(oddEvenList(listNode));
    }


    public static ListNode oddEvenList(ListNode head) {
        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenHead = even;

        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}