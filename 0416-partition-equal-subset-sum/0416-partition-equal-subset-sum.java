class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i=0; i<nums.length; i++){
            totalSum += nums[i];
        }

        if( totalSum % 2 != 0){
            return false;
        }

        int target = totalSum / 2;

        dp = new Boolean[nums.length + 1][target + 1];

        return solve(nums, nums.length, target);
    }

    public boolean solve(int[] nums, int n, int target){
        if(target == 0){
            return true;
        }

        if(n == 0){
            return false;
        }

        if(dp[n][target] != null){
            return dp[n][target];
        }

        if(nums[n-1] <= target){
            boolean take = solve(nums, n - 1, target - nums[n-1]);
            boolean skip = solve(nums, n - 1, target);

            dp[n][target] = take || skip;
            return dp[n][target];
        }else{
            dp[n][target] = solve(nums, n-1, target);
        }

        return dp[n][target];
    }
}