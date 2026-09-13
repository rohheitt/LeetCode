class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[edges.length + 1];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[graph.length];

            if(dfs(graph, u, v, visited)){
                return new int[] {u, v};
            }

            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);

        }

        return new int[] {};
    }

    public boolean dfs(ArrayList<Integer>[] graph, int u, int v, boolean[] visited){
        if(u == v){
            return true;
        }
        visited[u] = true;

        for(int neighbour : graph[u]){
            if(!visited[neighbour]){
                if(dfs(graph, neighbour, v, visited)){
                    return true;
                }
            }
        }

        return false;
    }
}