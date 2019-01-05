package com.three.stone.leetcode.binaryTree;

import com.three.stone.leetcode.TreeNode;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 *
 * Example:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 */
public class DeleteNodeOfBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode p = null, parent = null, q = root;

        while (q != null) {
            if (key == q.val) {
                p = q;
                break;
            }

            parent = q;
            if (key > q.val) {
                q = q.right;
            } else {
                q = q.left;
            }
        }
        if (p == null) {
            return root;
        }

        if (p.left == null && p.right == null) {
            if (parent == null) {
                return null;
            }

            if (parent.left == p) {
                parent.left = null;
            }

            if (parent.right == p) {
                parent.right = null;
            }
            return root;
        }

        if (p.left == null) {
            if (parent == null) {
                return p.right;
            }

            if (parent.left == p) {
                parent.left = p.right;
            }
            if (parent.right == p) {
                parent.right = p.right;
            }
            return root;
        }

        if (p.right == null) {
            if (parent == null) {
                return p.left;
            }

            if (parent.left == p) {
                parent.left = p.left;
            }
            if (parent.right == p) {
                parent.right = p.left;
            }
            return root;
        }

        TreeNode leftMin = p.right, leftMinParent = p;
        while (leftMin.left != null) {
            leftMinParent = leftMin;
            leftMin = leftMin.left;
        }

        if (leftMinParent == p) {
            p.val = leftMin.val;
            p.right = p.right.right;
            return root;
        }

        leftMinParent.left = leftMin.right;
        p.val = leftMin.val;
        return root;
    }
}
