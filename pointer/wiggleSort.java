public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i=0;i<nums.length;i++) // traverse the array
            if(i%2==1){ // at odd position
               if(nums[i-1]>nums[i]) swap(nums,  i-1, i); // swap the ones that broke the rule
            }// at even position, change swap the ones that broke the rule
            else if(i!=0 && nums[i-1]<nums[i]) swap(nums, i-1, i);
    }

    public void swap(int[] nums, int startIndex, int endIndex){
    	int tmp = nums[startIndex];
    	nums[startIndex] = nums[endIndex];
    	nums[endIndex] =tmp;
    }

}