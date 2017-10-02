//this it the top down = recursive approach
static int fib(int n){
	
	//create the memoization data structure to store the optimal values
	HashMap<Integer, Integer> map =  new HashMap<Integer, Integer>();
	fibHelper(n, map);
	return map.get(n);

}

static int fibHelper(int n, HashMap<Integer, Integer> map){

	//compute and memoize the base case solutions
	if(n==0){
		map.put(0,0)
	}
	if(n==1{
		map.put(1,1)
	}
	//if (memoized)
	if(map.containKey(n)){
		//return the result 
		return map.get(n);
	}//if (not memoized)
	else{
		// compute the new optimal sub-solution based on the previous optimal subsolution  -  top down approach = recursive approach
		int result = fibHelper(n-1, map) + fibHelper(n-2, map); 
		//memoize
		map.put(n, result);
	}
	
	//return the memoized solution
	return result;

	}
}


// this is the bottom up = iterative approach 
static int fib(int n){
	//create the memoization data structure 
	HashMap<Integer, Integer> map = new HAshMap<Integer, Integer>();

	//compute and memoize the base case solutions
	if(n==0){
		map.put(0,0)
	}
	if(n==1{
		map.put(1,1)
	}



	//since it's bottom up, so every answer is memoized  - if(memoized is neglected here)
		// no need to return result neither

	//if (not memoized), bottom up calculation
	for(int i = 2; i <=n; i++){
		// compute the new optimal sub-solution based on the previous optimal subsolution  - bottom up = iterative approach
		int result = map.get(i-1) + map.get(i-2);
		//memoize
		map.put(i, result);
	}		
	//return the memoized solution
	return map.get(n);
}








