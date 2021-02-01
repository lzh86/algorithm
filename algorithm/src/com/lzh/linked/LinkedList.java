package com.lzh.linked;


import java.util.Arrays;

/**
 * 链表增删操作
 */
public class LinkedList<T> {

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    //头节点
    private Node<T> first;
    //尾节点
    private Node<T> last;
    //大小
    private int size;

    //TODO: 2021/2/1
    // LinkedList 中有一个modCount字段,每次新增,删除,修改等引起列表长度变化的操作都会改变值大小
    // 迭代器会引用该值,可实现快速失败机制

    public LinkedList() {
    }

    /**
     * 头插
     *
     * @param element 元素
     */
    public void addFirst(T element) {
        LinkedList.Node<T> f = first;
        LinkedList.Node<T> newNode = new LinkedList.Node<>(null, element, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    /**
     * 尾插
     *
     * @param element 元素
     */
    public void addLast(T element) {
        LinkedList.Node<T> newNode = new LinkedList.Node<>(null, element, null);
        if (first == null)
            first = newNode;
        else
            last.next = newNode;
        last = newNode;
        size++;
    }

    /**
     * 尾插
     *
     * @param e 元素
     */
    void linkLast(T e) {
        final LinkedList.Node<T> l = last;
        final Node<T> newNode = new LinkedList.Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    /**
     * 指定位置插入
     *
     * @param element 元素
     * @param node    插入下标当前节点
     */
    void linkBefore(T element, Node<T> node) {
        LinkedList.Node<T> pred = node.prev;
        //新节点的上一个节点就是 插入下标当前节点 的上一个节点
        //新节点的下一个节点就是 插入下标当前节点
        Node<T> newNode = new LinkedList.Node<>(pred, element, node);
        //设置 插入下标当前节点 的上一个节点为新建节点  将节点挂好
        node.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    /**
     * 查找指定下标节点
     *
     * @param index 指定下标
     * @return
     */
    Node<T> node(int index) {
        //if(index < 0 || index > size)  非法下标
        //根据下标位置设置从前往后还是从后往前查找
        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }

    }


    /**
     * 指定节点插入
     *
     * @param index   节点下标
     * @param element 元素
     */
    public void add(int index, T element) {
        //checkPositionIndex(index);    检查下标合法性

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }


    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (LinkedList.Node<T> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }


    public static void main(String[] args) {
        LinkedList<String> headLinkedList = new LinkedList<>();
        headLinkedList.addFirst("123");
        headLinkedList.addFirst("1234");
        headLinkedList.addFirst("1235");

        headLinkedList.add(1, "fff");
        Object[] array = headLinkedList.toArray();
        System.out.println(Arrays.toString(array));


        LinkedList<String> lastLinkedList = new LinkedList<>();
        lastLinkedList.addLast("123");
        lastLinkedList.addLast("1234");
        lastLinkedList.addLast("1235");
        Object[] array1 = lastLinkedList.toArray();
        System.out.println(Arrays.toString(array1));


    }



}

