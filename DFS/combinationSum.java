public class Solution{
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
	   	//edge case 
		if(candidates == null || candidates.length == 0){
		    return result;
		}
		//main case
        Arrays.sort(candidates);
		helper(candidates, target, result, subResult, 0);
		return result;
	}

	private void helper(int[] candidates, int target,List<List<Integer>> result,
	List<Integer> subResult, int level){
	    //build masterResult with conditional gate
		if(target == 0){
            result.add(new ArrayList<Integer>(subResult));
			return;
		}
		//clarify the levelIndex, each level how to represent the children 
		for(int i = level; i < candidates.length; i++){
			// build subResult with conditional gate, return
            if(candidates[i] > target){
                return;
            }
			subResult.add(candidates[i]);
			//recurisvely go deeper
			helper(candidates, target - candidates[i], result, subResult, i);
			subResult.remove(subResult.size()-1);
		}
	}
}