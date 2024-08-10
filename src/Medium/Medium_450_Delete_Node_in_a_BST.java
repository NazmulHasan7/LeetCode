// 450. Delete Node in a BST
package Medium;

public class Medium_450_Delete_Node_in_a_BST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int value){this.val = value;}
        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.val = value;
            this.left = left;
            this.right = right;
        }
    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            root = new TreeNode(val);
        else if (val <= root.val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
        return root;
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Target node is found and it is a leaf node
            if (root.left == null && root.right == null) {
                root = null;
            } // Target node has a right child
            else if (root.left == null) {
                root = root.right;
            } // Target node has a left child
            else if (root.right == null) {
                root = root.left;
            } // Target node has both child
            else {
                // Find the minimum key in the right subtree and replace
                TreeNode temp = root.right;
                while (temp.left != null)
                    temp = temp.left;

                root.val = temp.val;
                root.right = deleteNode(root.right, root.val);
            }
        } return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root = insertIntoBST(root, 10);
        root = insertIntoBST(root, 20);
        root = insertIntoBST(root, 25);
        root = insertIntoBST(root, 8);
        root = insertIntoBST(root, 12);
        root = insertIntoBST(root, 13);
        root = deleteNode(root, 15);
        System.out.println(root.val);
    }
}
