class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid, new int[]{i, j}, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int[] cell, boolean[][] visited){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int row = cell[0];
        int col = cell[1];

        visited[row][col] = true;

        for(int k=0; k<4; k++){
            int newRow = row + dr[k];
            int newCol = col + dc[k];

            if(newRow >= 0 && newRow < grid.length &&
               newCol >= 0 && newCol < grid[0].length){

                if(grid[newRow][newCol] == '1' && !visited[newRow][newCol]){
                    dfs(grid, new int[]{newRow, newCol}, visited);
                }

            }
        }
    }
}