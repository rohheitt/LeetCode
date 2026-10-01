class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length + 1][amount + 1];

        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(coins, amount, coins.length);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int solve(int[] coins, int amount, int i){
        if(amount == 0){
            return 0;
        }

        if(i == 0){
            return Integer.MAX_VALUE;
        }

        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        int coin = coins[i - 1];
        if(coin <= amount){
            int next = solve(coins, amount - coin, i);

            int take;
            if(next == Integer.MAX_VALUE){
                take = Integer.MAX_VALUE;
            }else{
                take = 1 + next;
            }

            int skip = solve(coins, amount , i-1);

            dp[i][amount] = Math.min(take, skip);
        }else{
            dp[i][amount] = solve(coins, amount, i - 1);
        }

        return dp[i][amount];
    }
}