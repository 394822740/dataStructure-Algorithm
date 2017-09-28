classical-binary-search-solution
public class Solution {
    /*
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        //edge case
        if(nums==null || nums.length ==0){
            return -1;
        }
        
        //main case 
        int left = 0; 
        int right = nums.length-1;
        
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                left = mid;
            }else{
                right = mid;
            }
        }
        return -1;
    }
}