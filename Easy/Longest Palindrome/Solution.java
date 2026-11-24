        }

        int result = 0;

        for (int c : count) {
            result += (c / 2) * 2;
        }

        if (result < s.length()) {
            result++;
        }

        return result;
    }
}
