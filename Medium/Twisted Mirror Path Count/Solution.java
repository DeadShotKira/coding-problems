                            ((long) right[i][j + 1] + down[i][j]) % MOD
                        );
                    }
                }
            }
        }

        // Total valid paths reaching destination
        return (int) (
            ((long) right[m - 1][n - 1]
            + down[m - 1][n - 1]) % MOD
        );
    }
}

