package Exercises.Trees;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    public static TreeNode insert(TreeNode root, int value) {
        if (root == null)
            root = new TreeNode(value);
        else if (value <= root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);
        return root;
    }
    public static boolean search(TreeNode root, int value) {
        if (root == null) return false;
        else if (root.value == value) return true;
        else if (value <= root.value) return search(root.left, value);
        else return search(root.right, value);
    }
    public static TreeNode insertIterative(TreeNode root, int value) {
        if (root == null)
            return new TreeNode(value);

        TreeNode temp = root;
        TreeNode parentNode = null;
        while (temp != null) {
            parentNode = temp;
            if (value <= temp.value)
                temp = temp.left;
            else temp = temp.right;
        }
        if (value <= parentNode.value)
            parentNode.left = new TreeNode(value);
        else parentNode.right = new TreeNode(value);

        return root;
    }
    public static boolean searchIterative(TreeNode root, int value) {
        if (root == null) return false;

        TreeNode temp = root;
        while (temp != null) {
            if (temp.value == value) return true;
            else if (value <= temp.value) temp = temp.left;
            else temp = temp.right;
        } return false;
    }
    public static int findMin(TreeNode root) {
        if (root == null) return -1;
        else if (root.left == null) return root.value;
        return findMin(root.left);
    }
    public static int findMinIterative(TreeNode root) {
        if (root == null) return -1;
        while (root.left != null)
            root = root.left;
        return root.value;
    }
    public static int findMax(TreeNode root) {
        if (root == null) return -1;
        else if (root.right == null) return root.value;
        return findMax(root.right);
    }
    public static int findMaxIterative(TreeNode root) {
        if (root == null) return -1;
        while (root.right != null)
            root = root.right;
        return root.value;
    }
    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }
    public static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }
    public static void inOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        // Keep going to the left and push to the stack till it reaches null
        // When there is no left, pop parent from stack and go to the right
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // Pop last inserted parent then goto right subtree
            current = stack.pop();
            System.out.print(current.value + " ");
            current = current.right;
        }
    }
    public static void preOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return;
        stack.push(root);

        while (!stack.isEmpty()) {
            // root is visited
            root = stack.pop();
            System.out.print(root.value + " ");
            // Push Right element first then left
            // So that on pop operation we have left element accessed first
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
        }
    }
    public static void postOrderTraversal(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // Add at the front as [queue]
            System.out.print(node.value + " ");

            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
    }
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }
    public static int findHeight(TreeNode root) {
        if (root == null) return -1;
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }
    public static TreeNode findMinInRight(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root;
    }
    public static TreeNode deleteNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        } else if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            // Found the target node, proceed on deletion
            // The target node is a leaf node
            if (root.left == null && root.right == null) {
                root = null;
            } // The target node has a right child
            else if (root.left == null) {
                root = root.right;
            } // The target node has a left child
            else if (root.right == null) {
                root = root.left;
            } // The target node has both child
            else {
                root.value = findMinInRight(root.right).value;
                root.right = deleteNode(root.right, root.value);
            }
        } return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root = insert(root, 10);
        root = insertIterative(root, 20);
        root = insert(root, 25);
        root = insertIterative(root, 8);
        root = insert(root, 12);
        root = insert(root, 13);
        System.out.println(search(root, 8));
        System.out.println(searchIterative(root, 8));
        System.out.println(search(root, 22));
        System.out.println(searchIterative(root, 22));
        System.out.println(findMin(root));
        System.out.println(findMinIterative(root));
        System.out.println(findMax(root));
        System.out.println(findMaxIterative(root));
        System.out.println("Pre-order");
        preOrder(root);
        System.out.println();
        System.out.println("In-order");
        inOrder(root);
        System.out.println();
        inOrderIterative(root);
        System.out.println();
        System.out.println("Post-order");
        postOrder(root);
        System.out.println();
        levelOrderTraversal(root);
        root = deleteNode(root, 12);
        System.out.println("\n");
        inOrder(root);
    }
}
