public class Solution {
        public class ResultType {
        public int sum, size;
        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }           
    private TreeNode subtree = null;
    private ResultType subtreeResult = null;
    

    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return subtree;
    }
    
    private ResultType helper(TreeNode root) {
        
        //base case
        if (root == null) {
            return new ResultType(0, 0);
        }
        //divdie 
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        //conquer 
        ResultType result = new ResultType(
            left.sum + right.sum + root.val,
            left.size + right.size + 1
        );
        
        //combine
        if (subtree == null ||
            subtreeResult.sum * result.size < result.sum * subtreeResult.size//??
        ) {
            subtree = root;
            subtreeResult = result;
        }
        return result;
    }
}