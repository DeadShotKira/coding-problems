class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int prev = head.val;
        int curr, next;

        ListNode temp = head.next;

        int firstidx = -1;
        int previdx = -1;
        int curridx = 1;

        int mindis = Integer.MAX_VALUE;
        int maxdis = 0;

        while (temp.next != null) {

            curr = temp.val;
            next = temp.next.val;

            if ((curr < prev && curr < next) ||
                (curr > prev && curr > next)) {

                // First critical point
                if (firstidx == -1) {
                    firstidx = curridx;
                }

                // We have a previous critical point
                if (previdx != -1) {
                    mindis = Math.min(mindis, curridx - previdx);
                }

                // Distance from first to current
                maxdis = curridx - firstidx;

                previdx = curridx;
            }

            prev = curr;
            temp = temp.next;
            curridx++;
        }

        if (previdx == -1 || firstidx == previdx) {
            return new int[]{-1, -1};
        }

        return new int[]{mindis, maxdis};
    }
}