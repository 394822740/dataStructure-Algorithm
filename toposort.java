
//Coordinate with x y 

// edge case 

// main case 
    //traverse the map 
        // markByBFS()
        // islands++

//return islands 

class Coordinate{
    int x; 
    int y; 
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

}


public class Solution{
    // edge case 
    public int numislands(int[][] grid){
        int count = 0;
        // edge case 
        
        if(grid == null){
            return 0;
        }
        //main case 
        n = grid.length;
        m = grid[0].length; 
        //traverse the grid
        for(x = 0; x < n; x++){
            for(y = 0; y < m; y++){
                if(grid[x][y] == 1){
                    markByBFS(grid, x, y, count);
                }   
            }   
        }
        return count;
    }
    private void markByBFS(int[][] source, int x, int y, int count){
        //init center node queue (update   the source )   
        int[] dx = {0,-1,0,1};
        int[] dy = {-1, 0, 1, 0};
        Queue<Coordinate> q  = new LinkedList<>();
        q.offer(new Coordinate(x, y));
        source[x][y] = 0;

        while(!q.isEmpty()){
            Coordinate cur = q.poll();
            for(int i = 0; i < 4; i++){
                Coordinate sur = new Coordinate(cur.x + dx[i], 
                    cur.y + dy[i]);
                if(!inbound(source, sur)){
                    continue;
                }

                if (source[sur.x][sur.y] == 1) {
                    q.offer(sur);
                    //mark it as visited 
                    source[sur.x][sur.y] = 0;
                    count++;                   
                }
            }
        }
        //for each center node, create it sur node 

            //for each sur node
                // check if inbound
                // check if to queuee the sur node  (update the source if needed)
                // result related things 
            
            
    }
}


