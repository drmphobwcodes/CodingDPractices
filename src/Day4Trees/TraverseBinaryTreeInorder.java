package Day4Trees;

public class TraverseBinaryTreeInorder {
    public void traverseInorder(TreeNode root) {
        if(root == null) {
            return;
        }

        traverseInorder(root.left);
        System.out.println(root.val);
        traverseInorder(root.right);
    }
}
