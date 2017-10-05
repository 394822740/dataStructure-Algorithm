class Solution {
      public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        // edge case
        if(digits == null || digits.length() == 0)
            return result;

        // 1 input graph 
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");
        //INSIGHT: subResult needs to be dynamic, turn String into ArrayList<Char>
          // later you need a method to turn the ArrayList<Char> back to the String 
        ArrayList<Character> subResult = new ArrayList<Character>();


        //DFS
        getString(digits, subResult, result, map, 0); 
        return result;
    }
    
    
    public void getString(String digits, ArrayList<Character> subResult, ArrayList<String> result,  HashMap<Integer, String> map, int levelIndex){
           //build the masterResult with conditional restriction
        if(levelIndex == digits.length()){
            result.add(convertToString(subResult));
            return;
        }
       

        //build the recursive tree:
        //won't need a formal base case 
        //clarify the levelIndex        
        String letters = map.get(Character.getNumericValue(digits.charAt(levelIndex)));
        
        //clarify the children nodes to the parent node
        for(int i=0; i<letters.length(); i++){
            System.out.println("loop entered");
            subResult.add(letters.charAt(i));
            System.out.println(letters.charAt(i));
            getString(digits, subResult, result, map, levelIndex+1);
            subResult.remove(subResult.size()-1);
        }
      
    }
    
    
    //INSIGHT: turn dynamic ArrayList<Char> back to String
    private String convertToString(ArrayList<Character> input){
        String subResult = "";
        for(Character c : input){
            subResult = subResult + c;
        }   
        return subResult;
    }
}


