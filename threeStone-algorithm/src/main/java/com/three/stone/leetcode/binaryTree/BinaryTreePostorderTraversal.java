package com.three.stone.leetcode.binaryTree;

import com.three.stone.leetcode.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal {

    /**
     * 非递归版本，处理的有点慢
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.peek();
            /**
             * 若set.contains(node)，说明右子树已经处理过了
             */
            if (node.right != null && !set.contains(node)) {
                set.add(node);
                node = node.right;
            } else {
                result.add(node.val);
                stack.pop();
                /**
                 * 令node为null，表示处理stack中的下一个元素
                 */
                node = null;
            }
        }

        return result;
    }

    /**
     * 非递归版本2， 逆序按照 root->right->left去插入值
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ret = new LinkedList<>();

        if (root == null) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            /**
             * 头插，逆序
             */
            ret.add(0, curr.val);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }

        return ret;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorderHelper(root.left, list);
            postorderHelper(root.right, list);
            list.add(root.val);
        }
    }
}
