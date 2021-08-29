package deutsche;

public class ListNode implements Cloneable {
    private int value;
    private ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ListNode curr = this;
        ListNode cloneStart = null;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = new ListNode(curr.value);

            if (cloneStart == null) {
                cloneStart = temp;
                prev = temp;
            } else {
                prev.next = temp;
                prev = temp;
            }
            curr = curr.next;
        }
        return cloneStart;
    }

    public ListNode findElementFromEnd(int n) throws CloneNotSupportedException {
        int count = 1;
        ListNode curr = this.reverse();

        while (curr != null) {
            if (count == n) {
                return curr;
            } else {
                count++;
                curr = curr.next;
            }
        }

        return null;
    }

    public ListNode reverse() throws CloneNotSupportedException {
        ListNode curr = (ListNode) this.clone();
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);

        ListNode curr = null;
        try {
            curr = listNode1.reverse();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        while (curr != null) {
            System.out.print(curr.value);
            curr = curr.next;
        }
        System.out.println();

        ListNode result = listNode1.findElementFromEnd(2);
        System.out.println("Result value should be 4 = " + result.value);
    }
}
