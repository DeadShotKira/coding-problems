class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());

        if(set.size() == nums.length){
            return false;
        }
        return true;
    }
}