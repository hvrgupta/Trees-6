// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        helper(root, low, high);
        return sum;
    }

    private void helper(TreeNode root, int l, int r) {
        if (root == null)
            return;

        if (l > root.val) {
            helper(root.right, l, r);
        }

        if (root.val > l) {
            helper(root.left, l, r);
        }

        if (root.val >= l && root.val <= r) {
            sum += root.val;
            helper(root.right, l, r);
        }
    }
}
