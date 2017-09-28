public class Solution {
    /*
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] source) {
        //edge caase
        if(source == null || source.length ==0){
            return -1;
        }
        //main case
        int left = 0;
        int right = source.length - 1;
        
        while(left + 1 < right){
            // mid and tighten the bound 
            int mid = left + (right - left )/2;
            if(source[mid] <= source[mid+1]){
                left = mid;
            }else{
                right = mid;
            }
        }       
        
        
        //check the bound if applicable
        if(source[left] > source[right]){
            return left;
        }else{
            return right;
        }

        
        
    }
}