// Given a single linked list with next and arbitrary pointer, write a program to copy the list

// Idea is to copy the first node and attach next to it. copy the second node and attach next to it
// Do it for all the nodes. Now start copying the arbitrary pointers
// node->next->arbirtary = node->arbitrary-next
// this is because node->arbitrary->next is nothing but the clone of itself
// After this have two pointers for the original and the clone list and preparing the lists
package SingleLinkedList;

class ListArbitNode {
    int data;
    ListArbitNode next;
    ListArbitNode arbitrary;

    public ListArbitNode(int data) {
        this.data = data;
        this.next = null;
        this.arbitrary = null;
    }
}

public class CopyWithArbitPointer {
    public ListArbitNode solution(ListArbitNode head) {
        if (head == null)
            return null;

        ListArbitNode copy = head;
        ListArbitNode tmp = head;
        // create a node and attach next to it.
        while (copy.next != null) {
            ListArbitNode temp = copy.next;
            copy.next = new ListArbitNode(copy.data);
            copy.next.next = temp;
            copy = temp;
        }

        copy = head;

        while (copy != null) {
            if (copy.arbitrary != null) {
                // point the arbitraty of the next node to the arbitrary of the current node
                copy.next.arbitrary = copy.arbitrary.next;
            }

            if (copy.next != null) {
                copy = copy.next.next;
            }
        }

        copy = head.next;
        ListArbitNode duplicate = copy;
        while (tmp.next != null) {
            tmp.next = tmp.next.next;
            copy.next = copy.next.next;
        }

        return duplicate;
    }
}
