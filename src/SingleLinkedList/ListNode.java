package SingleLinkedList;

public class ListNode {
    private ListNode next;
    private ListNode prev;
    private int data;

    ListNode(int x) {
        this.data = x;
        this.next = this.prev = null;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPrev() {
        return prev;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
