// 606. Construct String from Binary Tree
package Medium;

public class Medium_606_Construct_String_from_Binary_Tree {
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
    public static String tree2str(TreeNode root) {
        StringBuilder answer = new StringBuilder();
        construct(root, answer);
        return answer.toString();
    }
    private static void construct(TreeNode root, StringBuilder str) {
        if (root == null) return;
        str.append(root.val);

        if (root.left != null) {
            str.append("(");
            construct(root.left, str);
            str.append(")");
        }
        if (root.right != null) {
            if (root.left == null) str.append("()");
            str.append("(");
            construct(root.right, str);
            str.append(")");
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(tree2str(root));
    }
}
