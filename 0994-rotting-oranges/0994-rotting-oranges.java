class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int minutes = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;

            for(int i=0; i<size; i++){
                int[] cell = q.poll();

                for(int k=0; k<4; k++){
                    int newRow = cell[0] + dr[k];
                    int newCol = cell[1] + dc[k];

                    if((0 <= newRow && newRow < grid.length) && (0 <= newCol && newCol < grid[0].length)){
                        if(grid[newRow][newCol] == 1 && !visited[newRow][newCol]){
                            q.add(new int[]{newRow, newCol});
                            visited[newRow][newCol] = true;
                            grid[newRow][newCol] = 2;
                            rotted = true;
                        }
                    }

                }
            }

            if(rotted){
                minutes++;
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return minutes;
    }
}