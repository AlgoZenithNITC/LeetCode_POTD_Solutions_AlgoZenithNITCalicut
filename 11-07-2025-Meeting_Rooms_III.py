class Solution:
    def mostBooked(self, n: int, meetings: list[list[int]]) -> int:
        busy = [0] * n  # Room end times
        count = [0] * n  # Booking counts per room

        meetings.sort()

        for start, end in meetings:
            earliest = float('inf')
            room_index = -1
            assigned = False

            for i in range(n):
                if busy[i] < earliest:
                    earliest = busy[i]
                    room_index = i

                if busy[i] <= start:
                    busy[i] = end
                    count[i] += 1
                    assigned = True
                    break

            if not assigned:
                busy[room_index] += (end - start)
                count[room_index] += 1

        max_count = max(count)
        for i in range(n):
            if count[i] == max_count:
                return i
