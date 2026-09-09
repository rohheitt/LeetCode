class Solution {
    public boolean check(int[] nums) {
        int rotated = 0;

        for(int i=1; i<nums.length; i++){
            if(nums[i] < nums[i-1]){
                rotated++;
            }
        }

        if (nums[nums.length - 1] > nums[0]) {
            rotated++;
        }

        return rotated <= 1;
    }
}