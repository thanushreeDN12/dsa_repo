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

    public void rightDfs(TreeNode node, int level, List<Integer> ans){
        if(node== null) return;
        if(ans.size() == level){
            ans.add(node.val);
        }

        rightDfs(node.right, level+1, ans);
        rightDfs(node.left, level+1, ans);
    }
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans=new ArrayList<>();
        rightDfs(root, 0, ans );
        return ans;
        
    }
}