package com.kaka.algorithm.linked;


import java.util.Arrays;

/**
 * 链表增删操作
 */
public class LinkedList<T> {

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

    //###################################################### 双向链表 #####################################################

    /**
     * 头插
     *
     * @param element 元素
     */
    public void addFirst(T element) {
        Node<T> f = first;
        Node<T> newNode = new Node<>(null, element, f);
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
        //todo 存在没有将节点关联
        Node<T> newNode = new Node<>(null, element, null);
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
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, e, null);
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
        Node<T> pred = node.prev;
        //新节点的上一个节点就是 插入下标当前节点 的上一个节点
        //新节点的下一个节点就是 插入下标当前节点
        Node<T> newNode = new Node<>(pred, element, node);
        //设置 插入下标当前节点 的上一个节点为新建节点  将节点挂好
        node.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    /**
     * 根据线标删除节点
     * @param index     删除节点下标
     */
    // TODO: 2021/2/2 没考虑 first 和 last 节点更新情况 没考虑被卸载节点的回收问题
    void remove(int index){
        if(index < 0 || index > size) return;
        //删除节点
        Node<T> node = node(index);

        Node<T> prev = node.prev;
        Node<T> next = node.next;

        prev.next = next;
        next.prev = prev;
        size--;
    }

    /**
     * 删除头节点
     */
    // TODO: 2021/2/2 没有考虑两个节点的情况
    void removeFirst(){
        if (size < 0) return;
        //下节点
        Node<T> next = first.next;
        first.next = null;
        first = next;
        first.prev = null;
        size--;
    }

    /**
     * 删除尾节点
     */
    void removeLast(){
        if (size < 0) return;
        //下节点
        Node<T> prev = last.prev;
        last.prev = null;
        last = prev;
        last.next = null;
        size--;
    }

    private T unlinkFirst(Node<T> f) {
        // assert f == first && f != null;
        final T element = f.item;
        final Node<T> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    /**
     * Unlinks non-null last node l.
     */
    private T unlinkLast(Node<T> l) {
        // assert l == last && l != null;
        final T element = l.item;
        final Node<T> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }


    /**
     * 删除节点
     * @param x
     */
    void unlink(Node<T> x) {
        // assert x != null;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
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

    //###################################################### 单向链表 #####################################################

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

    /**
     * 单链表头插
     *
     * @param element 元素
     */
    public void addSingleFirst(T element) {
        Node<T> f = first;
        Node<T> newNode = new Node<>(element, f);
        if (f == null) {
            first = newNode;
            last = first;
        } else {
            first = newNode;
        }
        size++;
    }

    /**
     * 单链表尾插
     *
     * @param element 元素
     */
    public void addSingleLast(T element) {
        Node<T> f = first;
        Node<T> newNode = new Node<>(element, null);
        if (f == null)
            first = newNode;
        else
           last.next = newNode;
        last = newNode;
        size++;
    }

    /**
     * 单链表指定位置插入
     *
     * @param element  元素
     * @param index    插入下标当前节点
     */
    void addSingleBefore(T element,int index) {
        // TODO: 感觉不是很优雅

        //index = 0 需要更新头节点
        if (index == 0) {
            addSingleFirst(element);
            return;
        }

        //index = size - 1 需要更新尾节点
        if (index == (size - 1)) {
            addSingleLast(element);
            return;
        }

        Node<T> nextNode = sinleNode(index);
        Node<T> preNode = sinleNode(index - 1);
        Node<T> newNode = new Node<>(element, nextNode);
        newNode.next = nextNode;
        preNode.next = newNode;
        size++;
    }


    /**
     * 单查找指定下标节点
     *
     * @param index 指定下标
     * @return
     */
    Node<T> sinleNode(int index) {
        //if(index < 0 || index > size)  非法下标
        //根据下标位置设置从前往后还是从后往前查找
        if (index > size || index < 0)  return null;
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
    }


    public static void main(String[] args) {
//        LinkedList<String> headLinkedList = new LinkedList<>();
//        headLinkedList.addFirst("123");
//        headLinkedList.addFirst("1234");
//        headLinkedList.addFirst("1235");
//
//        headLinkedList.add(1, "fff");
//        Object[] array = headLinkedList.toArray();
//        System.out.println(Arrays.toString(array));


//        LinkedList<String> lastLinkedList = new LinkedList<>();
//        lastLinkedList.linkLast("1");
//        lastLinkedList.linkLast("2");
//        lastLinkedList.linkLast("3");
//        lastLinkedList.linkLast("4");
//        Object[] array1 = lastLinkedList.toArray();
//        System.out.println(Arrays.toString(array1));
//        //lastLinkedList.remove(1);
//        lastLinkedList.removeFirst();
//        Object[] array2 = lastLinkedList.toArray();
//        System.out.println(Arrays.toString(array2));
//        lastLinkedList.removeLast();
//        Object[] array3 = lastLinkedList.toArray();
//        System.out.println(Arrays.toString(array3));

        LinkedList<String> lastLinkedList = new LinkedList<>();
       lastLinkedList.addSingleLast("1");
        System.out.println("头节点:" + lastLinkedList.first.item);
        System.out.println("尾节点:" + lastLinkedList.last.item);
        lastLinkedList.addSingleLast("2");
//        lastLinkedList.addSingleLast("3");
//        lastLinkedList.addSingleLast("4");
        Object[] array3 = lastLinkedList.toArray();
        System.out.println(Arrays.toString(array3));
        lastLinkedList.addSingleBefore("5",1);
        Object[] array4 = lastLinkedList.toArray();
        System.out.println(Arrays.toString(array4));
        System.out.println("头节点:" + lastLinkedList.first.item);
        System.out.println("尾节点:" + lastLinkedList.last.item);


    }



}

