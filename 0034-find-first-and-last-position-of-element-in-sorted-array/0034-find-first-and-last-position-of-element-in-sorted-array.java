class Solution {

    public int firstOccurence(int[] nums, int target, int i){
        if(i == nums.length){
            return -1;
        }

        if(nums[i] == target){
            return i;
        }

        return firstOccurence(nums, target, i+1);
    }

    public int lastOccurence(int[] nums, int target, int i){
        if(i < 0){
            return -1;
        }
        if(nums[i] == target){
            return i;
        }
        return lastOccurence(nums, target, i-1);
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        ans[0] = firstOccurence(nums, target, 0);
        ans[1] = lastOccurence(nums, target, nums.length-1);

        return ans;
    }
}