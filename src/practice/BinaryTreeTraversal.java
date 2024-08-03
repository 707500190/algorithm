package practice;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeTraversal {

    // 广度优先遍历（BFS）
    public static void bfsTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left!= null) {
                queue.add(current.left);
            }
            if (current.right!= null) {
                queue.add(current.right);
            }
        }
    }

    // 深度优先遍历 - 前序遍历（DFS - Preorder）
    public static void dfsPreorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        dfsPreorderTraversal(root.left);
        dfsPreorderTraversal(root.right);
    }

    // 深度优先遍历 - 中序遍历（DFS - Inorder）
    public static void dfsInorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        dfsInorderTraversal(root.left);
        System.out.print(root.val + " ");
        dfsInorderTraversal(root.right);
    }

    // 深度优先遍历 - 后序遍历（DFS - Postorder）
    public static void dfsPostorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        dfsPostorderTraversal(root.left);
        dfsPostorderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("广度优先遍历:");
        bfsTraversal(root);

        System.out.println("\n深度优先遍历 - 前序:");
        dfsPreorderTraversal(root);

        System.out.println("\n深度优先遍历 - 中序:");
        dfsInorderTraversal(root);

        System.out.println("\n深度优先遍历 - 后序:");
        dfsPostorderTraversal(root);
    }
    // 二叉树节点类
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

}