class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check if palindrome is possible
        int oddCount = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                middle = (char) ('a' + i);
            }
        }

        if (oddCount > 1) return "";

        // Characters available for the first half
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        int halfLen = n / 2;
        char[] left = new char[halfLen];

        // Try to match target's first half exactly
        int i = 0;

        for (; i < halfLen; i++) {
            int c = target.charAt(i) - 'a';

            if (halfFreq[c] == 0) {
                break;
            }

            left[i] = target.charAt(i);
            halfFreq[c]--;
        }

        /*
         * Case 1:
         * We successfully matched the entire first half.
         *
         * The resulting palindrome might already be > target.
         */
        if (i == halfLen) {
            String candidate = buildPalindrome(left, middle, n);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * Case 2:
         * We need to increase some position.
         *
         * Start from the rightmost possible position
         * to get the smallest lexicographical increase.
         */
        for (int pos = Math.min(i, halfLen - 1); pos >= 0; pos--) {

            // Restore character used at this position
            if (pos < i) {
                halfFreq[left[pos] - 'a']++;
            }

            char targetChar = target.charAt(pos);

            // Find smallest available character > target[pos]
            for (int c = targetChar - 'a' + 1; c < 26; c++) {

                if (halfFreq[c] > 0) {
                    left[pos] = (char) ('a' + c);
                    halfFreq[c]--;

                    // Fill remaining positions minimally
                    int idx = pos + 1;

                    for (int k = 0; k < 26; k++) {
                        while (halfFreq[k] > 0) {
                            left[idx++] = (char) ('a' + k);
                            halfFreq[k]--;
                        }
                    }

                    return buildPalindrome(left, middle, n);
                }
            }
        }

        return "";
    }

    private String buildPalindrome(char[] left, char middle, int n) {
        StringBuilder sb = new StringBuilder(n);

        // Left half
        for (char c : left) {
            sb.append(c);
        }

        // Middle
        if (n % 2 == 1) {
            sb.append(middle);
        }

        // Right half
        for (int i = left.length - 1; i >= 0; i--) {
            sb.append(left[i]);
        }

        return sb.toString();
    }
}