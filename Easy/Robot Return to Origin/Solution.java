class Solution {
    public boolean judgeCircle(String moves) {
        if(moves.length() % 2 != 0){
            return false;
        }

        int[] mov = new int[26];

        for(char m : moves.toCharArray())mov[m - 'A']++;


        return (mov['U'-'A'] == mov['D'-'A'] && mov['R'-'A'] == mov['L'-'A']);
    }
}