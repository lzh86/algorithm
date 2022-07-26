package com.kaka.algorithm.linked;


/**
 * 反转链表
 */
public class ReverseList {

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        //构造双链表
        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        //构造单链表
        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseList(head.next);
        // 记住下一个节点指向当前节点
        head.next.next = head;
        //指向空避免产生环
        head.next = null;
        return newHead;
    }

    public  static Node reverseList2(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            //当前节点 next 节点
            Node next = curr.next;
            curr.next = prev;
            //先前节点 = 当前节点
            prev = curr;
            //当前节点 = 当前节点 next 节点
            curr = next;
        }
        return prev;
    }

    private static void printAll(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.item + ",");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //第三个节点
        Node threeNode = new Node<>("3",null);
        Node twoNode = new Node<>("2",threeNode);
        Node oneNode = new Node<>("1",twoNode);
        printAll(oneNode);
        Node node = reverseList(oneNode);
        Node node2 = reverseList2(oneNode);
        System.out.println("反转链表之后");
        printAll(node);
    }








}
