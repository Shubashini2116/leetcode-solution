import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        postorder(root, result);

        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {

        if (root == null)
            return;

        postorder(root.left, result);  // Left
        postorder(root.right, result); // Right
        result.add(root.val);          // Root
    }
}