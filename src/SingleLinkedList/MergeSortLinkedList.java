package SingleLinkedList;

public class MergeSortLinkedList {
    public Node getMiddle(Node root) {
        Node slow = root;
        Node fast = root;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node sortLists(Node left, Node right) {
        // base case . if one of the list is null return the other one
        if (left == null)
            return  right;

        if (right == null)
            return left;

        Node tmp;

        if (left.data < right.data) {
            tmp = left;
            tmp.next = sortLists(left.next, right);
        } else {
            tmp = right;
            tmp.next = sortLists(left, right.next);
        }

        return tmp;
    }
    public Node mergeSort(Node head) {
        if (head == null)
            return null;

        // get the middle of the list
        Node middle = getMiddle(head);

        // next of middle is the head of the second list
        Node middleNext = middle.next;

        // set next of middle to null
        middle.next = null;

        // recursively divide the first list
        Node left = mergeSort(head);

        // recursively divide the second half
        Node right = mergeSort(middleNext);

        // Now merge the two sub lists
        Node result = sortLists(left, right);

        return result;
    }
}
