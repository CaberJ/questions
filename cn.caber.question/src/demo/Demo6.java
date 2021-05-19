package demo;

//给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
//      输入：lists = [[1,4,5],[1,3,4],[2,6]]
//      输出：[1,1,2,3,4,4,5,6]
//      解释：链表数组如下：
//      [
//      1->4->5,
//      1->3->4,
//      2->6
//      ]
//      将它们合并到一个有序链表中得到。
//      1->1->2->3->4->4->5->6


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Demo6 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(6);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(1, listNode2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(3, listNode4);
        ListNode listNode6 = new ListNode(1, listNode5);
        ListNode listNode7 = new ListNode(6);
        ListNode listNode8 = new ListNode(2, listNode7);

        ListNode[] listNodes = {listNode3, listNode6, listNode8};
        for (ListNode listNode : listNodes) {
            print(listNode);
        }
        ListNode listNode = mergeKLists(listNodes);

        System.out.println("----------------------------");
        print(listNode);
    }

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
    }


    public static ListNode mergeKLists(ListNode[] lists) {

        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Integer> newInts = null;
        for (ListNode list : lists) {
            newInts = getInt(integers, list);
        }

       /* newInts.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });*/

        for (int i = 0; i < newInts.size() - 1; i++) {
            for (int j = i ; j < newInts.size(); j++) {
                if (newInts.get(i) > newInts.get(j)) {
                    Integer a = newInts.get(i);
                    newInts.set(i, newInts.get(j));
                    newInts.set(j, a);
                }
            }
        }


        ListNode listNode = listToLN(newInts);
        return listNode;
    }

    public static ArrayList<Integer> getInt(ArrayList<Integer> integers, ListNode listNode) {
        if (listNode == null) {
            return integers;
        } else {
            integers.add(listNode.val);
            integers = getInt(integers, listNode.next);
        }
        return integers;
    }

    public static ListNode listToLN(List<Integer> collect) {
        ListNode listNode = null;
        for (int i = collect.size() - 1; i >= 0; i--) {
            Integer integer = collect.get(i);
            listNode = new ListNode(integer, listNode);
        }
        return listNode;
    }

    public static void print(ListNode listNode) {
        if (listNode != null) {
            System.out.println(listNode.val);
            print(listNode.next);
        }

    }

}
