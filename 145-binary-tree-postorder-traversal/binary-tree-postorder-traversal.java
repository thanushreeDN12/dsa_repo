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
    public List<Integer> postorderTraversal(TreeNode root) {
       Stack<TreeNode> st1 = new Stack<>();
       Stack<TreeNode> st2 = new Stack<>();
       ArrayList<Integer> li= new ArrayList<>();
        TreeNode node= root;


        if(root == null) return li;
        st1.push(node);
        
        while( !st1.isEmpty()){
            node= st1.pop();
            st2.push(node);

            if( node.left != null){
                st1.push(node.left);
            }
            if( node.right != null){
                st1.push(node.right);
            }


       }
       while(!st2.isEmpty()){
        li.add(st2.pop().val);
       }
    return li;
    }

    
}