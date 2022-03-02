package SingleLinkedList;

public class RemoveDuplicates {
    public void solution(Node head) {
        if (head == null)
            return;

        Node tmp = new Node(0);
        tmp.next = head;
        Node prev = tmp;
        Node cur = head;

        while (cur != null) {
            while (cur != null && cur.data == cur.next.data) {
                cur = cur.next;
            }

            if (prev.next == cur) {
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }

            cur = cur.next;
        }
    }
}
