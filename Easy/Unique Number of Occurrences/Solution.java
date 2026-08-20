class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        return checkOccurrence(arr);
    }

    public boolean checkOccurrence(int[] arr){
        HashMap <Integer,Integer> occurrence = new HashMap<>();

        for(int a : arr){
            occurrence.put(a,occurrence.getOrDefault(a,0)+1);
        } 

        HashSet<Integer> set = new HashSet<>();

        for(int freq : occurrence.values()){
            if(!set.add(freq)){
                return false;
            }
        }
        return true;
    }
}