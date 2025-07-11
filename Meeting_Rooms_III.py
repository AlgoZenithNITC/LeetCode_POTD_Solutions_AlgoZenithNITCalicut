class Solution:
    def mostBooked(self, n: int, meetings: list[list[int]]) -> int:
        # Sort meetings by start time
        meetings.sort()

        # Min-heap for available rooms
        available = list(range(n))
        heapq.heapify(available)

        # Min-heap for ongoing meetings: (end_time, room_number)
        ongoing = []

        # Count of meetings per room
        count = [0] * n

        for start, end in meetings:
            # Free rooms where meeting has ended
            while ongoing and ongoing[0][0] <= start:
                end_time, room = heapq.heappop(ongoing)
                heapq.heappush(available, room)

            if available:
                # Assign room directly
                room = heapq.heappop(available)
                real_start = start
            else:
                # Delay meeting until the earliest room is free
                end_time, room = heapq.heappop(ongoing)
                real_start = end_time

            duration = end - start
            real_end = real_start + duration
            heapq.heappush(ongoing, (real_end, room))
            count[room] += 1

        # Return the room with the most meetings, smallest number if tie
        max_count = max(count)
        for i in range(n):
            if count[i] == max_count:
                return i
       
