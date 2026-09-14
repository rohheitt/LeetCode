class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];

        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int rootU = find(u, parent);
            int rootV = find(v, parent);

            if(rootU == rootV){
                return new int[]{u, v};
            }
            parent[rootV] = rootU;
        }

        return new int[] {};
    }

    public int find(int x, int[] parent){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x], parent);
    }
}