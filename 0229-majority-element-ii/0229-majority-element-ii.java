class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums){
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);

            if (freq > nums.length / 3 && !list.contains(num)){
                list.add(num);
            }
        }

        return list;
    }
}