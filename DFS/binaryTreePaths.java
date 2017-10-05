/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution{
	public List<String> binaryTreePaths(TreeNode root){
		List<String> result = new ArrayList<String>();
		//edge case 
		if(root == null)
			return result;
		//main case 
		helper(root, result, "");
		return result;

	} 
	private void helper(TreeNode root, List<String> result, String subResult){
		//base case
		if(root == null){
			return;
		}
		//masterResult, whenever a leaf node is reached 
		if(root.left == null && root.right ==null){
			subResult += root.val;
			result.add(subResult);
			return; 
		}
		

		//subResult, whenever a returncurisve method is called
		subResult += root.val + "->";

		//recursive call
		helper(root.left, result, subResult);
		helper(root.right, result, subResult);

	}
}