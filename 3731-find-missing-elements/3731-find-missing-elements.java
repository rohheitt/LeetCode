class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            int currMin = nums[i];
            min = Math.min(min, currMin);
        }
        for(int i=0; i<nums.length; i++){
            int currMax = nums[i];
            max = Math.max(max, currMax);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        while(min <= max){
            if(!set.contains(min)){
                list.add(min);
            }
            min++;
        }

        return list;
    }
}