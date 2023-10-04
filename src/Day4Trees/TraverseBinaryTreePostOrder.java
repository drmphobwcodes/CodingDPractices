package Day4Trees;

public class TraverseBinaryTreePostOrder {
    public void traversePostOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.println(root.val);
    }
}
