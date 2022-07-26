package com.kaka.algorithm.linked;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 */
public class InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    List<Integer> arrayList = new ArrayList<>();

    /**
     * 递归方式实现
     *
     * @param root
     * @return
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (null == root) return arrayList;
//        inorderTraversal(root.left);
//        arrayList.add(root.val);
//        inorderTraversal(root.right);
//        return arrayList;
//    }

    /**
     * 迭代方式实现前序遍历
     * 1.首先申请一个新的栈，记为stack；
     * 2.声明一个结点treeNode，让其指向node结点；
     * 3.如果treeNode的不为空，将treeNode的值打印，并将treeNode入栈，然后让treeNode指向treeNode的右结点，
     * 4.重复步骤3，直到treenode为空；
     * 5.然后出栈，让treeNode指向treeNode的右孩子
     * 6.重复步骤3，直到stack为空.
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode ;
        treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                arrayList.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        return arrayList;
    }


    /**
     * 迭代方式实现中序遍历
     *
     * 1.申请一个新栈，记为stack，申请一个变量cur，初始时令treeNode为头节点；
     * 2.先把treeNode节点压入栈中，对以treeNode节点为头的整棵子树来说，依次把整棵树的左子树压入栈中，
     * 即不断令treeNode=treeNode.leftChild，然后重复步骤2；
     * 3.不断重复步骤2，直到发现cur为空，此时从stack中弹出一个节点记为treeNode，打印node的值，并让treeNode= treeNode.right，
     * 4.然后继续重复步骤2；
     * 5.当stack为空并且cur为空时结束。
     * @param node
     * @return
     */
    public  List<Integer> inOrderTraveralWithStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        while(treeNode!=null || !stack.isEmpty()){
            while(treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if(!stack.isEmpty()){
                treeNode = stack.pop();
                arrayList.add(treeNode.val);
                treeNode = treeNode.right;
            }

        }
        return arrayList;
    }

    /**
     * 迭代方式实现后序遍历
     *
     * @param node
     */
    public List<Integer> postOrderTraveralWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        TreeNode lastVisit = null;   //标记每次遍历最后一次访问的节点
        while (treeNode != null || !stack.isEmpty()) {//节点不为空，结点入栈，并且指向下一个左孩子
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //栈不为空
            if (!stack.isEmpty()) {
                //出栈
                treeNode = stack.pop();
                /**
                 * 这块就是判断treeNode是否有右孩子，
                 * 如果没有输出treeNode.data，让lastVisit指向treeNode，并让treeNode为空
                 * 如果有右孩子，将当前节点继续入栈，treeNode指向它的右孩子,继续重复循环
                 */
                if (treeNode.right == null || treeNode.right == lastVisit) {
                    arrayList.add(treeNode.val);
                    lastVisit = treeNode;
                    treeNode = null;
                } else {
                    stack.push(treeNode);
                    treeNode = treeNode.right;
                }
            }
        }
        return arrayList;
    }


}
