package SingleLinkedList;// given two linked lists, merge them in reverse order

// Idea is same as merging two sorted linked lists. Instead of merging the nodes and moving right
// we add the current smallest node at the beginning and move left

public class MergeTwoListsReverse {
    public Node mergeListsReverse(Node node1, Node node2) {
        Node result = null;

        if (node1 == null && node2 == null)
            return null;

        while (node1 != null && node2 != null) {
            // get the smallest value and insert it at the beginning of the list
            if (node1.data < node2.data) {
                Node tmp = node1.next;
                node1.next = result;
                result = node1;
                node1 = tmp;
            }

            if (node2.data < node1.data) {
                Node tmp = node2.next;
                node2.next = result;
                result = node2;
                node2 = tmp;
            }
        }

        // if of the list is null, then just copy over the elements
        while (node1 != null) {
            Node tmp = node1.next;
            node1.next = result;
            result = node1;
            node1 = tmp;
        }

        while (node2 != null) {
            Node tmp = node2.next;
            node2.next = result;
            result = node2;
            node2 = tmp;
        }

        return result;
    }
}
