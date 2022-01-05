// Given a linked list, swap two nodes

// we keep two pointers for x and y and two previous pointers of x and y
// first we swap the next pointers of x and y and then swap the next pointers
// of prev_x and prev_y
package SingleLinkedList;

public class SwapTwoNodes {
    public void solution(int x, int y) {
        Node head = new Node(5);
        Node curx = head, cury = head;
        Node prev_x = null, prev_y = null;

        while (curx != null && curx.data != x) {
            prev_x = curx;
            curx = curx.next;
        }

        while (cury != null && cury.data != y) {
            prev_y = cury;
            cury = cury.next;
        }

        // if either of the previous pointers are null then they point to head node
        // Make the other node as the head
        if (prev_x != null) {
            // if previous is not null point it to the other node
            prev_x.next = cury;
        } else {
            head = cury;
        }

        if (prev_y != null) {
            prev_y.next = curx;
        } else {
            head = cury;
        }

        // now swap the next pointers of the actual nodes
        Node tmp = curx.next;
        curx.next = cury.next;
        cury.next = tmp;
    }
}
