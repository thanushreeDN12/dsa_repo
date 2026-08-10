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
    int dia=0;
    public int getHeight(TreeNode node){

        if(node == null) return 0;

        int lh= getHeight(node.left);
        int rh= getHeight(node.right);

        dia= Math.max(dia, lh+rh);

        return 1+Math.max(lh,rh);
        

    }
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return dia;
        
    }
}