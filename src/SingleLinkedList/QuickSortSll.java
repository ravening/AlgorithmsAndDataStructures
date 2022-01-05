package SingleLinkedList;

/*
https://www.geeksforgeeks.org/quicksort-on-singly-linked-list/?ref=lbp
 */
public class QuickSortSll {
    static class Sll {
        Sll next;
        int data;

        Sll(int d) {
            this.data =d;
            this.next = null;
        }
    }

    Sll head, tail;

    public void addNode(int x) {
        Sll node = new Sll(x);
        if (head == null && tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }

    public void sort(Sll start, Sll end) {
        if (start == null || end == null || start == end) {
            return;
        }
        Sll pivot = partition(start, end);
        sort(start, pivot);
        if (pivot != null && pivot == start) {
            sort(pivot.next, end);
        } else if (pivot != null && pivot.next != null) {
            sort(pivot.next.next, end);
        }
    }

    public Sll partition(Sll start, Sll end) {
        int pivot = end.data;
        Sll prev = start;
        Sll cur = start;

        while (start != end) {
            if (start.data <= pivot) {
                prev = cur;
                int tmp = cur.data;
                cur.data = start.data;
                start.data  = tmp;
                cur = cur.next;
            }

            start = start.next;
        }

        int tmp = cur.data;;
        cur.data = pivot;
        end.data = tmp;

        return prev;
    }
}
