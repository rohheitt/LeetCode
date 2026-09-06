class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for(int i=0; i<isConnected.length; i++){
            if(!visited[i]){
                dfs(isConnected, i, visited);
                count++;
            }
        }

        return count;
    }

    public void dfs(int[][] isConnected, int idx, boolean[] visited){
        visited[idx] = true;
        for(int i = 0; i < isConnected.length; i++){
            if(isConnected[idx][i] == 1 && !visited[i]){
                dfs(isConnected, i, visited);
            }
        }
    }
}