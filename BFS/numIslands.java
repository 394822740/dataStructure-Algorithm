class Coordinate{
    int x;
    int y;
    public Coordinate(int x, int y){
        this.x =x; 
        this.y =y;
    }
}
public class Solution{
    private void BFS(boolean[][] grid, int x, int y){
        Queue<Coordinate> q = new LinkedList<Coordinate>();
        int[] xDelta = {0,-1,0,1};
        int[] yDelta = {-1,0,1,0};
        // Init the to-visit queue  * mark it via source or hashset
        q.offer(new Coordinate(x,y));
        grid[x][y] = false;

        // While (next generation available) 
        while(!q.isEmpty()){
            // Generation Counter, Generation Size
            
            int size = q.size();
            // traverse the to-visit-nodes at the current generation
            for(int j = 0; j < size; j++){
                 // poll the to-visit-node from the queue

                Coordinate cur = q.poll();
                //create  surNode of the to-visit node
                //traverse surNode of current to-visit node
                for(int i=0; i<4; i++){
                    Coordinate sur = new Coordinate(
                        cur.x + xDelta[i], 
                        cur.y + yDelta[i]);
                    //check InBound(surNode), check to-visit(surNode), continue
                    if(!inBound(sur, grid)){
                        continue;
                    }
                    //check queue’s conditional gate, queue the surNode  * mark it via       source or hashset
                    if(grid[sur.x][sur.y]){
                        q.offer(sur);
                        grid[sur.x][sur.y] = false;
                    }
                    
                }
            }
        }
    }
    private boolean inBound(Coordinate coor, boolean[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
    }

    public int numIslands(boolean[][] grid){
        int numIslands = 0;
        //edge case
        if(grid==null || grid.length ==0 || grid[0].length==0){
            return 0;
        }
        int v = grid.length; 
        int h = grid[0].length;
    
        //main case
        for(int i = 0; i< v; i++){
            for (int j = 0; j < h; j++){
                if(grid[i][j]){
                    BFS(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

}