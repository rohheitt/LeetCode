class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY;
        double currAvg = 0;
        int left = 0;
        for(int right=0; right<nums.length; right++){
            currAvg += nums[right];
            if(right - left + 1 == k){

                maxAvg = Math.max(maxAvg, currAvg / k);

                currAvg -=nums[left];
                left++;
            }
        }
        return maxAvg;
    }
}