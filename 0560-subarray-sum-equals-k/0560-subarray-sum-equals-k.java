class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;

        for(int i=0; i<nums.length; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int counter = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                int currSum = prefix[j + 1] - prefix[i];

                if(currSum == k){
                    counter++;
                }
            }
        }

        return counter;
    }
}