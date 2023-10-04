package Day4Trees;

public class TraverseBinaryTreePreOrder {
    public void traversePreOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        System.out.println(root.val);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

}
