class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] busy = new long[n]; // End times for each room
        int[] count = new int[n];  // Booking counts per room

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            long earliest = Long.MAX_VALUE;
            int roomIndex = -1;
            boolean assigned = false;

            for (int i = 0; i < n; ++i) {
                if (busy[i] < earliest) {
                    earliest = busy[i];
                    roomIndex = i;
                }

                if (busy[i] <= start) {
                    busy[i] = end;
                    count[i]++;
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                busy[roomIndex] += (end - start);
                count[roomIndex]++;
            }
        }

        int res = 0, maxCount = 0;
        for (int i = 0; i < n; ++i) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                res = i;
            }
        }

        return res;
    }
}
