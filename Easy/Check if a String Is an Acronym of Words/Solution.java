class Solution {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder x = new StringBuilder();

        for(String str : words){
            x.append(str.charAt(0));
        }

        if(s.equals(x.toString())){
            return true;
        }

        return false;
    }
}