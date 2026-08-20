class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0,ans = 0;
        
        for (int right = 0; right < s.length(); right++){
            char c = s.charAt(right);

            if(window.containsKey(c) && window.get(c) >= left){
                left = window.get(c) + 1;
            } 

            window.put(c,right);

            ans = Math.max(ans, right - left+1);
        }
        return ans;

    }
}