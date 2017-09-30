
public class Solution {
    /*
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
     
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        if(n == 1 ){
            return true;
        }
        if(n==2){
            return false;
        }
        if(edges == null ){
            return false;
        }
        // initialize n isolated islands
        
        for(int i =0; i <n; i++){
            parent[i] = i;
        }
    
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            //check if the root of the two nodes are already sharing the same root, i.e connected
            int t1 = edges[i][0];
            int t2 = edges[i][1];
            if (root(t1) == root(t2)){
                return false;  
            } 
            //unite the vertices
            
            unite(t1, t2);
        }
        return true;
    }
    
    
    
    private int root(int i){
        while(i != parent[i]){
            i = parent[i];
        }
        return i;
    }

    private void unite(int t1, int t2){
        parent[root(t1)] = root(t2);
    }
        
}