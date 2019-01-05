package com.three.stone.leetcode.binaryTree;

import com.three.stone.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    /**
     * 非递归方式，只有右节点入栈
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
            }
            result.add(cur.val);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            cur = cur.left;
        }
        return result;
    }

    /**
     * 递归方式
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorderHelper(root.left, list);
            preorderHelper(root.right, list);
        }
    }


}
