class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLength = 1;
        int chainEnd = pairs[0][1];
        for(int i=0; i<pairs.length; i++){
            if(pairs[i][0] > chainEnd){
                chainLength++;
                chainEnd = pairs[i][1];
            }
        }
        return chainLength;
    }
}