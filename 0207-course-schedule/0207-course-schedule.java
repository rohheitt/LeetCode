class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : prerequisites){
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[graph.length];
        boolean[] path = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                if(dfs(graph, i, visited, path)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(ArrayList<Integer>[] graph, int curr, boolean[] visited, boolean[] path){
        visited[curr] = true;
        path[curr] = true;

        for(int neighbour : graph[curr]){
            if(path[neighbour]){
                return true;
            }

            if(!visited[neighbour]){
                if(dfs(graph, neighbour, visited, path)){
                    return true;
                }
            }
        }
        path[curr] = false;

        return false;
    }
}