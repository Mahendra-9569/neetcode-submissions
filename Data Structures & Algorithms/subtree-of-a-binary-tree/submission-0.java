class Solution {

    public static boolean isCorrect(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isCorrect(root1.left, root2.left)
            && isCorrect(root1.right, root2.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (isCorrect(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }
}