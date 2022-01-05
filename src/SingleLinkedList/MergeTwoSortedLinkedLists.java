package SingleLinkedList;

/*
https://www.educative.io/m/merge-two-sorted-linked-lists
 */
public class MergeTwoSortedLinkedLists {
    public Node solution(Node head1, Node head2) {
        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        Node head, tail, tmp;

        if (head1.data <= head2.data) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }

        tail = head;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tmp = head1;
                head1 = head1.next;
            } else {
                tmp = head2;
                head2 = head2.next;
            }

            tail.next = tmp;
            tail = tmp;
        }

        if (head1 == null) {
            tail.next = head2;
        } else {
            tail.next = head1;
        }

        return head;

    }
}
