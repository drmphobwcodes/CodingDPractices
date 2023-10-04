package Day4Trees;

import javax.swing.tree.TreeNode;

public class InsertNodeBST {
    public TreeNode insertNode(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }

        if(val < root.val) {
            root.left = insertNode(root.left, val);
        } else {
            root.right = insertNode(root.right, val);
        }

        return root;
    }
}
