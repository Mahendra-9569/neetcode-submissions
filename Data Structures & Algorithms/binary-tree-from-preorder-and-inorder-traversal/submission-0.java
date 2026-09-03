class Solution {
    public TreeNode buildTrees(
            int preStart,
            int preEnd,
            int[] preorder,
            int inStart,
            int inEnd,
            int[] inorder,
            Map<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int idx = map.get(preorder[preStart]);
        int leftSize = idx - inStart;

        root.left = buildTrees(
                preStart + 1,
                preStart + leftSize,
                preorder,
                inStart,
                idx - 1,
                inorder,
                map
        );

        root.right = buildTrees(
                preStart + leftSize + 1,
                preEnd,
                preorder,
                idx + 1,
                inEnd,
                inorder,
                map
        );

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTrees(
                0,
                preorder.length - 1,
                preorder,
                0,
                inorder.length - 1,
                inorder,
                map
        );
    }
}