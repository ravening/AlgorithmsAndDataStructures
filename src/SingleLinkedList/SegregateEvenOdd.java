package SingleLinkedList;

/*
https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/?ref=lbp
 */
public class SegregateEvenOdd {
    public void solution(ListNode head) {
        ListNode evenStart = null, evenEnd = null;
        ListNode oddStart = null, oddEnd = null;
        ListNode current = head;

        while (current != null) {
            if (current.getData() %2 == 0) {
                if (evenStart == null) {
                    evenStart = current;
                    evenEnd = evenStart;
                } else {
                    evenEnd.setNext(current);
                    evenEnd = evenEnd.getNext();
                }
            } else {
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = oddStart;
                } else {
                    oddEnd.setNext(current);
                    oddEnd = oddEnd.getNext();
                }
            }

            current = current.getNext();
        }

        if (oddStart == null || evenStart == null)
            return;

        evenEnd.setNext(oddStart);
        oddEnd.setNext(null);

        head = evenStart;
    }
}
