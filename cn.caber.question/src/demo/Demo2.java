package demo;


import java.util.Objects;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }
    }

    public static Integer addTwoNumbers(ListNode l1, ListNode l2) {
        Integer number1 = getNumber(l1, 0);
        Integer number2 = getNumber(l2, 0);
        Integer result = (number1 + number2) / 10;
        return result;
    }

    public static Integer getNumber(ListNode ln, int num) {
        int val = ln.getVal();
        num = (num + val) * 10;

        ListNode next = ln.getNext();
        if (Objects.nonNull(next)) {
            num = getNumber(next, num);
        }
        return num;
    }

    public static ListNode numToLN(Integer num) {

        ListNode listNode = stringToLN(num + "");

        return listNode;
    }

    public static ListNode stringToLN(String s) {
        s = s.trim();
        if (s.length() <= 0) {
            return null;
        } else {
            int j = Integer.parseInt(s.substring(s.length()-1));
            ListNode upLn = new ListNode(j);
            s = s.substring(0,s.length()-1);
            ListNode ln = stringToLN(s);
            upLn.setNext(ln);
            return upLn;
        }
    }


    public static StringBuilder lnShow(ListNode ln, StringBuilder sb) {

        int val = ln.getVal();
        sb.append(val);
        ListNode next = ln.getNext();
        if (Objects.isNull(next)) {
            return sb;
        } else {
            sb = lnShow(next, sb);
            return sb;
        }
    }

    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(4, listNode11);
        ListNode listNode13 = new ListNode(3, listNode12);


        ListNode listNode21 = new ListNode(5);
        ListNode listNode22 = new ListNode(6, listNode21);
        ListNode listNode23 = new ListNode(4, listNode22);


        Integer num = addTwoNumbers(listNode13, listNode23);
        System.out.println("number=" + num);
        ListNode listNode = numToLN(num);
        System.out.println("result="+listNode);
        String s = lnShow(listNode,new StringBuilder()).toString();
        System.out.println("resultStr="+s);

    }



}
