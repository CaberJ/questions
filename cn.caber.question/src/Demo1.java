/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo1 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        listNode2.setNext(listNode1);
        listNode3.setNext(listNode2);
        listNode4.setNext(listNode3);

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(1);
        node2.setNext(node1);
        node3.setNext(node2);
        node4.setNext(node3);
        addTwoNumbers(listNode4,node4);
    }

    public static int addTwoNumbers(ListNode l1, ListNode l2) {
        int add = add(l1, l2);
        System.out.println(add);
        char[] chars = (add + "").toCharArray();
        return add;

    }

    private static int add(ListNode l1, ListNode l2) {

        int val1, val2;
        if (l1 == null || l1.next == null) {
            val1 = 0;
        } else {
            val1 = l1.val;
        }
        if (l2 == null ||l2.next == null) {
            val2 = 0;
        } else {
            val2 = l2.val;
        }
        int add = val1 + val2;
        if(l1.next == null && l2.next == null){
            return add;
        }
        return add + add(l1.next, l2.next)*10;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}