            bit[i] ^= mask;
        }
    }

    int prefix(int i) {
        int result = 0;

        for (; i > 0; i -= i & -i) {
            result ^= bit[i];
        }

        return result;
    }
}

