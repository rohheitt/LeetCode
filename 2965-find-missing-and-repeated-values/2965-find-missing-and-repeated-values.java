class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        int n = grid.length;
        int total = n * n;
        int expectedSum = total * (total + 1) / 2;
        int calSum = 0;

        for(int i=0; i<grid.length; i++){
            for(int num : grid[i]){
                if(set.contains(num)){
                    ans[0] = num;
                }else{
                    set.add(num);
                }
                calSum += num;
            }
        }

        ans[1] = expectedSum - (calSum - ans[0]);

        return ans;

        
    }
}