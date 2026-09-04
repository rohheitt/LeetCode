class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];

        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int room : rooms.get(curr)){
                if(!visited[room]){
                    q.add(room);
                    visited[room] = true;
                }
            }
        }

        for(int i=0; i<visited.length; i++){
            if(visited[i] == false){
                return false;
            }
        }

        return true;
    }
}