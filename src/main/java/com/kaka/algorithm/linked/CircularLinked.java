package com.kaka.algorithm.linked;

/***
 * 循环链表
 */
public class CircularLinked {
     class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode() {
        }
    }

    /**
     * 空间复杂度为O(1)  时间复杂度为O(n)
     * 检测循环链表     通过快慢指针的方式来判断
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (null == head || head.next == null) {
            return false;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;

        do {
            if (null == fastNode || fastNode.next == null) {
                return false;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

        } while (fastNode != slowNode);
        return true;
    }

}
