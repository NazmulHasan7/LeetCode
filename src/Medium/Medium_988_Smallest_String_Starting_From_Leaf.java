// 988. Smallest String Starting From Leaf
package Medium;

public class Medium_988_Smallest_String_Starting_From_Leaf {
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
    static String answer = "~";
    public static String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return answer;
    }
    private static void dfs(TreeNode root, String currentPath) {
        // Preorder dfs -> root -> left -> right
        if (root == null) return;

        // Form the current path is reverse order
        // For each modification a new string is created and pushed into the stack
        currentPath = (char)(root.val+'a') + currentPath;

        if (root.left == null && root.right == null) {
            if (currentPath.compareTo(answer) < 0)
                answer = currentPath;
        }
        dfs(root.left, currentPath);
        dfs(root.right, currentPath);
    }
    static String answerStr = "~";
    public String smallestFromLeafBetter(TreeNode root) {
        dfsBetter(root, new StringBuilder());
        return answer;
    }
    private void dfsBetter(TreeNode root, StringBuilder currentPath) {
        // Preorder dfs -> root -> left -> right
        if (root == null) return;

        currentPath.append((char) (root.val + 'a'));

        if (root.left == null && root.right == null) {
            final String path = currentPath.reverse().toString();
            currentPath.reverse();
            if (path.compareTo(answer) < 0)
                answer = path;
        }
        dfsBetter(root.left, currentPath);
        dfsBetter(root.right, currentPath);
        // Since StringBuilder is mutable, the reference is passed
        currentPath.deleteCharAt(currentPath.length() - 1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(smallestFromLeaf(root));
    }
}
