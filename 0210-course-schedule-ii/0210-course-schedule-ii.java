class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : prerequisites){
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[graph.length];
        boolean[] path = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                if(dfs(graph, i, visited, path, s)){
                    return new int[0];
                }
            }
        }

        int[] result = new int[numCourses];

        for(int i=0; i<result.length; i++){
            result[i] = s.pop();
        }

        return result;

    }

    public boolean dfs(ArrayList<Integer>[] graph, int i, boolean[] visited, boolean[] path, Stack<Integer> s){
        visited[i] = true;
        path[i] = true;

        for(int neighbour : graph[i]){
            if(path[neighbour]){
                return true;
            }
            if(!visited[neighbour]){
                if(dfs(graph, neighbour, visited, path, s)){
                    return true;
                }
            }
        }
        path[i] = false;
        s.push(i);

        return false;
    }
}