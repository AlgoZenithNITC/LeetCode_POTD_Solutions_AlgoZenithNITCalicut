class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by their start time
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // PriorityQueue for available rooms (smallest room number first)
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) available.offer(i);

        // PriorityQueue for ongoing meetings: [endTime, roomNumber]
        PriorityQueue<long[]> ongoing = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        // Meeting count for each room
        int[] count = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // Free rooms whose meetings have ended
            while (!ongoing.isEmpty() && ongoing.peek()[0] <= start) {
                int freedRoom = (int) ongoing.poll()[1];
                available.offer(freedRoom);
            }

            long actualStart;
            int room;

            if (!available.isEmpty()) {
                room = available.poll();
                actualStart = start;
            } else {
                // Delay the meeting
                long[] earliest = ongoing.poll();
                actualStart = earliest[0];
                room = (int) earliest[1];
            }

            long actualEnd = actualStart + (end - start);
            ongoing.offer(new long[]{actualEnd, room});
            count[room]++;
        }

        // Find the room with the maximum number of meetings
        int maxMeetings = 0, resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxMeetings) {
                maxMeetings = count[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}
