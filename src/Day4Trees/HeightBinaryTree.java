package Day4Trees;

public class HeightBinaryTree {
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
