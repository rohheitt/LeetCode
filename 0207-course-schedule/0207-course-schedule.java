//soln using kahn's algo!!
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : prerequisites){
            graph[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }

        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;

            for(int neighbour : graph[curr]){
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }

        return count == numCourses;
    }
}