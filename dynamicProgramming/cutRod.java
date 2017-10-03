class RodCutting{
	static int cutRod(int prices[], int n){
		// create the memoization data structure 
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		int maxVal;
		
		//create the base case 
		if( n <= 0){
			map.put(0,0);
			return map.get(0);
		}

		//if(memoized) // not applicable here since it's bottom up here 

		//if (not memoized) bottom up calculation 
		for(int i =0 ; i < n; i++){
			//compute 
			int val = price[i] + cutRod(price, n-i-1);
			
			//memoize
			map.put(i, val);
			maxVal = Math.max(maxVal, val);
		}

		// return the memoized 
		return maxVal;
	}
}