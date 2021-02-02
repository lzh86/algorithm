package com.lzh.linked;

import java.util.Arrays;
import java.util.Scanner;

public class LRULinkedList<T> {
    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

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

    private static class Node<T> {
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


        //如果超过容量 删除尾节点 头节点重新插入
        if (size >= DEFAULT_CAPACITY) {
            removeSingleTail();
            addSingleHead(element);
        }

        //元素已添加 删除元素 头节点重新插入
        if(size > 0){
            Node<T> node = findByElement(element);
            if (null != node) {
                removeNode(node);
                addSingleHead(element);
            }
        }

        addSingleHead(element);
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
        LRULinkedList.Node<T> f = head;
        LRULinkedList.Node<T> newNode = new LRULinkedList.Node<>(element, f);
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
        for (LRULinkedList.Node<T> x = head; x.nextNode != null; x = x.nextNode) {
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

        LRULinkedList.Node<T> x = head;
        for (int i = 0; i < DEFAULT_CAPACITY - 1; i++)
            x = x.nextNode;
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
        for (LRULinkedList.Node<T> x = head; x != null; x = x.preNode)
            result[i++] = x.item;
        return result;
    }

    public static void main(String[] args) {
        LRULinkedList list = new LRULinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
