/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    static int idx;
    static int ans;
    public static void smallest(TreeNode root, int k){
        if(root == null)return;

        smallest(root.left, k);
        idx++;
        if(idx == k){
            ans = root.val;
            return;
        }
        smallest(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        ans = -1;
        idx  = 0;
        smallest(root, k);
        return ans;
    }
}
