public class Solution{
    public List<List<Integer>> subsets(int[] nums) {
    	
    	ArrayList<ArrayList<Integer>> masterResult = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> subResult = new ArrayList<Integer>();
    	//edge case 
    	if(nums == null || nums.length == 0){
    		return masterResult;
    	}

    	//main case
    	Arrays.sort(nums);
    	helper(subResult, nums, 0, masterResult);
    	return masterResult;
    	
	}

	public void helper(ArrayList<Integer> subResult, 
		int[] nums, 
		int startIndex, 
		List<List<Integer>> results){

		//building the masterResult
		masterResult.add(subResult);

		//building the subresult
		for(int i =startIndex; i < nums.length; i++){
			subResult.add(nums[i]);
			helper(subResult, nums, i+1, masterResult);
			subResult.remove(subResult.size()-1);
		}
		return; 
	}


}