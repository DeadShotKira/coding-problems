class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] sCount = new int[26];

        // Count characters in s
        for (char ch : s.toCharArray()) {
            sCount[ch - 'a']++;
        }

        // Match target as far as possible
        int startIndex = 0;

        while (startIndex < target.length()
                && sCount[target.charAt(startIndex) - 'a'] > 0) {

            sCount[target.charAt(startIndex) - 'a']--;
            startIndex++;
        }

        // Try to increase at the first unmatched position,
        // then backtrack from right to left if necessary
        for (int i = startIndex; i >= 0; i--) {

            // Restore the character that was previously matched
            if (i < startIndex) {
                sCount[target.charAt(i) - 'a']++;
            }

            // i == n means target was matched completely,
            // so we must backtrack first
            if (i >= target.length()) {
                continue;
            }

            int targetChar = target.charAt(i) - 'a';

            // Find smallest available character greater than target[i]
            for (int c = targetChar + 1; c < 26; c++) {

                if (sCount[c] > 0) {

                    StringBuilder result = new StringBuilder();

                    // Keep identical prefix
                    result.append(target.substring(0, i));

                    // Make it strictly greater here
                    result.append((char) (c + 'a'));
                    sCount[c]--;

                    // Smallest possible suffix
                    for (int j = 0; j < 26; j++) {
                        while (sCount[j] > 0) {
                            result.append((char) (j + 'a'));
                            sCount[j]--;
                        }
                    }

                    return result.toString();
                }
            }
        }

        return "";
    }
}