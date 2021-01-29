package com.lzh.linked;


import java.util.Objects;

/**
 * 单链表增删操作
 */
public class Node<T> {
    //数值
    private T data;
    //下一个节点
    private Node nextNode;

    public Node(T data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public Node(T data) {
        this.data = data;
    }

    public Node() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * 递归打印所有节点
     *
     * @param node
     */
    public void printNodeValue(Node node) {
        if (!Objects.isNull(node)) {
            Object data = node.getData();
            System.out.println("节点值:" + data);
            if (!Objects.isNull(node.getNextNode())) {
                printNodeValue(node.getNextNode());
            }
        }
    }


    public Node insertNode(Node node, String value,Node insertNode) {
        Node rootNode = node;
        Node insert = insert(node, value, insertNode);

        printNodeValue(insert);
        return rootNode;
    }


    public Node insert(Node node, String value,Node insertNode){
        if (!Objects.isNull(node)) {
            if (value.equals(node.getData())) {
                Node nextNode = node.getNextNode();
                insertNode.setNextNode(nextNode);
                node.setNextNode(insertNode);
                return node;
            }

            if (!Objects.isNull(node.getNextNode())) {
                insert(node.getNextNode(), value,insertNode);
            }
        }
        return node;
    }




    public static void main(String[] args) {
        Node<String> fourNode = new Node<>(" D ");

        Node<String> threeNode = new Node<>(" C ");
        threeNode.setNextNode(fourNode);
        Node<String> secondNode = new Node<>(" B ");
        secondNode.setNextNode(threeNode);
        Node<String> headNode = new Node<>(" A ");
        headNode.setNextNode(secondNode);
        //打印列表
        headNode.printNodeValue(headNode);

        Node<String> insertNode = new Node<>("ZZ");
        headNode.insertNode(headNode,"C",insertNode);
        System.out.println("新增节之后");
        //打印列表
        headNode.printNodeValue(headNode);



    }









}

