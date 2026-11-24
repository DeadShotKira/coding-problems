
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}
