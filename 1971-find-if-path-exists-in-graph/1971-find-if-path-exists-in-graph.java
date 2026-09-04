class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        q.add(source);
        visited[source] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            if(curr == destination){
                return true;
            }

            for(int neighbour : graph[curr]){
                if(!visited[neighbour]){
                    q.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        return false;
    }
}