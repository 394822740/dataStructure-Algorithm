/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     public int maxDepth(TreeNode root) {
         //base case 
        if(root==null){
            return 0;
        }
         //divide the problem recursively 
         int left = maxDepth(root.left) +1 ;
         int right = maxDepth(root.right)+1;
        //conquer 
         int max = Math.max(left, right);
         
         //combine
         
        return max;
    }
}