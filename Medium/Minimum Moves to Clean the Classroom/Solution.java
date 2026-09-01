import java.util.*;

class Solution {

    private static final int[][] STEP = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    private static class State {
        int cell;
        int cleaned;
        int power;

        State(int cell, int cleaned, int power) {
            this.cell = cell;
            this.cleaned = cleaned;
            this.power = power;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int height = classroom.length;
        int width = classroom[0].length();
        int cells = height * width;

        char[][] room = new char[height][];

        // litterBit[cell] tells which litter is present at that cell
        int[] litterBit = new int[cells];

        int start = -1;
        int litterCount = 0;

        // Convert strings to char arrays and locate S and L
        for (int r = 0; r < height; r++) {

            room[r] = classroom[r].toCharArray();

            for (int c = 0; c < width; c++) {

                int cell = r * width + c;

                if (room[r][c] == 'S') {
                    start = cell;
                }

                else if (room[r][c] == 'L') {
                    litterBit[cell] = 1 << litterCount;
                    litterCount++;
                }
            }
        }

        // Example:
        // 3 litter -> 111 -> all litter collected
        int allClean = (1 << litterCount) - 1;

        /*
         * strongest[mask][cell]
         *
         * Maximum energy with which we have reached
         * this cell after collecting exactly 'mask'.
         */
        int[][] strongest = new int[1 << litterCount][cells];

        for (int[] row : strongest) {
            Arrays.fill(row, -1);
        }

        ArrayDeque<State> queue = new ArrayDeque<>();

        // Starting state
        queue.addLast(new State(start, 0, energy));
        strongest[0][start] = energy;

        int moves = 0;

        // BFS
        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                State cur = queue.removeFirst();

                // All litter collected
                if (cur.cleaned == allClean) {
                    return moves;
                }

                /*
                 * If we already reached this exact
                 * (cell, mask) with more energy,
                 * this state is useless.
                 *
                 * Also, with 0 energy we cannot make
                 * another move.
                 */
                if (cur.power < strongest[cur.cleaned][cur.cell]
                        || cur.power == 0) {
                    continue;
                }

                int r = cur.cell / width;
                int c = cur.cell % width;

                // Try all 4 directions
                for (int[] direction : STEP) {

                    int nr = r + direction[0];
                    int nc = c + direction[1];

                    // Outside grid
                    if (nr < 0 || nr >= height ||
                        nc < 0 || nc >= width) {
                        continue;
                    }

                    // Obstacle
                    if (room[nr][nc] == 'X') {
                        continue;
                    }

                    int nextCell = nr * width + nc;

                    // Moving costs 1 energy
                    int nextPower = cur.power - 1;

                    // R resets energy
                    if (room[nr][nc] == 'R') {
                        nextPower = energy;
                    }

                    // Collect litter if present
                    int nextMask =
                            cur.cleaned | litterBit[nextCell];

                    /*
                     * Dominance check:
                     *
                     * If we have already reached this
                     * (cell, mask) with equal or greater
                     * energy, this state cannot help us.
                     */
                    if (nextPower <= strongest[nextMask][nextCell]) {
                        continue;
                    }

                    // This is now the strongest state
                    strongest[nextMask][nextCell] = nextPower;

                    queue.addLast(
                            new State(
                                    nextCell,
                                    nextMask,
                                    nextPower
                            )
                    );
                }
            }

            moves++;
        }

        // Impossible to collect all litter
        return -1;
    }
}