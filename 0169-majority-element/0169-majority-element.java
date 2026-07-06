class Solution {
    public int majorityElement(int[] nums) {
        int[] helper = new int[nums.length];
        int currmaj = 0;

        for(int i=0; i<nums.length; i++){
            currmaj = 0;
            for(int j=i; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    currmaj++;
                }
            }
            helper[i] = currmaj;
        }

        for(int i=0; i<helper.length; i++){
            if(helper[i] > nums.length / 2 ){
                return nums[i];
            }
        }
        return -1;
    }
}