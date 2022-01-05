// given a linked linst, arrange the odd and even positions node together
package SingleLinkedList;

public class RearrangeEvenOddPositions {
    public Node solution(Node root) {
        Node odd = root;
        Node even = root.next;
        Node evenFirst = root.next;

        while (true) {
            if (odd != null || even != null || even.next != null) {
                odd.next = evenFirst;
                break;
            }

            // point the next of odd to the next of even node
            odd.next = even.next;
            odd = odd.next;

            // if there are no more even nodes then point the next of
            // odd node to the first even node
            if (odd.next == null) {
                odd.next = evenFirst;
                break;
            }

            // point next of even to the next of odd node
            even.next = odd.next;
            even = even.next;
        }

        return root;
    }

    // Function to store all even values first followed by odd values
    public void evenAndOddValuesTogether(Node head) {
        if (head == null)
            return;

        Node current = head;
        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;

        while (current != null) {
            int val = current.data;
            if (val % 2 == 0) {
                // first node in the even list
                if (evenStart == null) {
                    evenEnd = current;
                    evenStart = current;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else {
                // first node in the odd list
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = current;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }

        // if both of the lists are null
        if (evenStart == null && oddStart == null)
            return;

        // If odd numbers should appear after even numbers then append
        // odd number list to end of even number list
        evenEnd.next = oddStart;
        oddEnd.next = null;
        head = evenStart;

        // If we want even and odd numbers alternatively.
        // Now we have two list. merge them alternatively
        Node result = null;
        while (evenStart != null && oddStart != null) {
            result = evenStart;
            evenStart = evenStart.next;

            result.next = oddStart;
            oddStart = oddStart.next;

            result = result.next;
        }

        if (evenStart != null) {
            result.next = oddStart;
        }

        if (oddStart != null) {
            result.next = evenStart;
        }
    }
}
