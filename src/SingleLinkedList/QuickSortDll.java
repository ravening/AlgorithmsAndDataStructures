package SingleLinkedList;

public class QuickSortDll {
    DllNode head;

    static class DllNode {
        DllNode prev;
        DllNode next;
        int data;

        DllNode(int d) {
            this.data = d;
            this.next = this.prev = null;
        }
    }

    public void  push(int data) {
        DllNode node = new DllNode(data);
        if (head == null) {
            node.prev = null;
        } else {
            head.prev = node;
        }
        node.next = head;
        head = node;
    }
    public void quickSort(DllNode head, DllNode tail) {
        if (head != tail && head.next != tail) {
            DllNode tmp = partition(head, tail);
            quickSort(head, tmp.prev);
            quickSort(tmp.next, tail);
        }
    }

    public DllNode partition(DllNode head, DllNode tail) {
        DllNode pivot = tail;
        DllNode left = head.prev;
        DllNode cur = head;
        while (cur != tail) {
            if (cur.data <= pivot.data) {
                left = (left == null) ? head : left.next;
                int tmp = cur.data;
                cur.data = left.data;
                left.data = tmp;
                cur = cur.next;
            }
        }

        left = (left == null) ? head : left.next;
        int tmp = tail.data;;
        tail.data = left.data;;
        left.data = tmp;

        return left;
    }
}
