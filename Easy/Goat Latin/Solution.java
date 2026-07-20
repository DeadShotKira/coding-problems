class Solution {
    public String toGoatLatin(String sentence) {
        return convertGoatLatin(sentence);
    }

    
 public String convertGoatLatin(String sentence){
    String a = "a";
    String[] words = sentence.split(" ");
    String vowels = "aeiouAEIOU";
    String iter = "";

    for(int i = 0;i<words.length;i++){
        iter = words[i];
        if(vowels.indexOf(iter.substring(0,1)) != -1){
            iter = iter += "ma";
        }else{
            iter = iter.substring(1) + iter.substring(0,1) + "ma";
        }
        iter += a;
        a += "a";
        words[i] = iter;
    }

    return String.join(" ", words);
    
 }
}