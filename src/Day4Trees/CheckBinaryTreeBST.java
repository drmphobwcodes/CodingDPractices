package Day4Trees;

public class CheckBinaryTreeBST {
    public boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int minValue, int maxValue) {
        if(root == null) {
            return true;
        }

        if(root.val < minValue || root.val > maxValue) {
            return false;
        }

        return isBST(root.left, minValue, root.val - 1) && isBST(root.right, root.val + 1, maxValue);
    }
}
