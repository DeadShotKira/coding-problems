class Solution {
    public int majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i : nums){
            list.add(i);
        }
        int ans = 0;
        int max = 0;
        Set<Integer> uniqueSet = new HashSet<>(list);
        for (int i : uniqueSet){
            int freq = Collections.frequency(list,i);
            if(freq > max){
                max = freq;
                ans = i;
            }
           
        }
        return ans;
    }
}