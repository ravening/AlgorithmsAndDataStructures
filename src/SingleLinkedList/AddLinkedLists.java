package SingleLinkedList;

/*
https://www.educative.io/m/add-two-integers
 */
public class AddLinkedLists {
    public void solution(Node list1, Node list2) {
        if (list1 == null || list2 == null)
            return;

        Node result = null;
        Node last = null;

        int carry = 0;
        int sum;

        while (list1 != null || list2 != null || carry > 0) {
            int first = list1 == null ? 0 : list1.data;
            int second = list2 == null ? 0 : list2.data;

            sum = first + second + carry;
            Node tmp = new Node(sum % 10);
            carry = sum / 10;

            if (result == null) {
                result = tmp;
            } else {
                last.next = tmp;
            }

            last = tmp;

            if (list1.next != null)
                list1 = list1.next;

            if (list2.next != null)
                list2 = list2.next;
        }
    }

}
