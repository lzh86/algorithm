package com.kaka.algorithm.linked;

import java.util.Scanner;

public class LRULinkedList<T> {
    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 5;

    /**
     * 头结点
     */
    private Node<T> head;

    /**
     * 尾节点
     */
    private Node<T> tail;

    /**
     * 链表长度
     */
    private int size;

    private  class Node<T> {
        T item;
        Node<T> nextNode;
        Node<T> preNode;

        Node(T item, Node nextNode, Node preNode) {
            this.item = item;
            this.nextNode = nextNode;
            this.preNode = preNode;
        }

        Node(T item, Node nextNode) {
            this.item = item;
            this.nextNode = nextNode;
        }
    }

    /**
     * 添加元素
     *
     * @param element 需要添加元素
     */
    void add(T element) {
        Node<T> node = findByElement(element);
        if (null != node) {
            removeNode(node);
            addSingleHead(element);
        } else {
            if (head != null && element.equals(head.item)) return;

            if (size >= DEFAULT_CAPACITY) {
                removeSingleTail();
                addSingleHead(element);
            } else {
                addSingleHead(element);
            }
        }
    }

    /**
     * 删除改节点的下一个节点
     *
     * @param node
     */
    private void removeNode(Node<T> node) {
        Node<T> deleteNode = node.nextNode;
        node.nextNode = deleteNode.nextNode;
        deleteNode.nextNode = null;
        size--;
    }

    /**
     * 单链表头插
     *
     * @param element 元素
     */
    public void addSingleHead(T element) {
        Node<T> f = head;
        Node<T> newNode = new Node<>(element, f);
        if (f == null) {
            head = newNode;
            tail = head;
        } else {
            head = newNode;
        }
        size++;
    }

    /**
     * 根据元素查找节点
     *
     * @param element
     * @return
     */
    Node<T> findByElement(T element) {
        if (size == 0) return null;
        for (Node<T> x = head; x.nextNode != null; x = x.nextNode) {
            if (x.nextNode.item.equals(element)) {
                return x;
            }
        }
        return null;
    }


    /**
     * 删除尾节点
     */
    public void removeSingleTail() {
        if (size < 0) return;

        Node<T> x = head;
        for (int i = 0; i < DEFAULT_CAPACITY - 2; i++)
            x = x.nextNode;
        tail = x;
        x.nextNode = null;
        //断掉节点回收问题
        size--;
    }

    /**
     * 打印数组
     *
     * @return
     */
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> x = head; x != null; x = x.preNode)
            result[i++] = x.item;
        return result;
    }

    private void printAll() {
        Node node = head;
        while (node != null) {
            System.out.print(node.item + ",");
            node = node.nextNode;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRULinkedList list = new LRULinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            // System.out.println(Arrays.toString(list.toArray()));
            list.printAll();

        }
    }
}
