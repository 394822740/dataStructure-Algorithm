public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        //edge case 
        if (dict == null) 
            return 0;

        if (start.equals(end))
            return 1;
        dict.add(start);
        dict.add(end);
        //init the to-visit queue *mark the 
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        // mark the queued node as to-visit (either on source or via a HashSet) 
        HashSet<String> hash = new HashSet<String>();
        hash.add(start);

        //while nextGeneration available 
        int length = 1;
        while(!queue.isEmpty()) {
            //generationCounter, generationSize
            length++;
            int size = queue.size();
            // traverse the to-visit-nodes at the current generation
            for (int i = 0; i < size; i++) {
                //examine to-visit node  (poll the to-visit-node from the queue) 
                String word = queue.poll();
                //create its surNode of the to-visit node
                ArrayList<String> surNodes = getNextWords(word, dict);
                //traverse the sur nodes, around the current visited node
                for (String nextWord: surNodes) {
                    //check InBound(surNode), check to-visit(surNode)
                    if (hash.contains(nextWord)) 
                        continue;
                    if (nextWord.equals(end)) 
                        return length;
                    //if(valid), queue the surNode  * mark it as to-visit 
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }

    // replace character of a string at given index to a given character
    // return a new string
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
}