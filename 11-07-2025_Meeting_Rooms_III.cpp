class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        // Sort meetings by start time
        sort(meetings.begin(), meetings.end());

        // Min-heap for available rooms (by room number)
        priority_queue<int, vector<int>, greater<int>> available;
        for (int i = 0; i < n; ++i) available.push(i);

        // Min-heap for ongoing meetings: [endTime, room]
        using pii = pair<long long, int>;
        priority_queue<pii, vector<pii>, greater<pii>> ongoing;

        // Count of meetings per room
        vector<int> count(n, 0);

        for (const auto& meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // Free up rooms where the meeting ended before or at current start time
            while (!ongoing.empty() && ongoing.top().first <= start) {
                available.push(ongoing.top().second);
                ongoing.pop();
            }

            int room;
            long long realStart;

            if (!available.empty()) {
                // Room is available
                room = available.top();
                available.pop();
                realStart = start;
            } else {
                // No room available, delay the meeting
                auto [finishTime, r] = ongoing.top();
                ongoing.pop();
                room = r;
                realStart = finishTime;
            }

            long long realEnd = realStart + (end - start);
            ongoing.push({realEnd, room});
            count[room]++;
        }

        // Find the room with the most meetings
        int maxMeetings = 0, roomNo = 0;
        for (int i = 0; i < n; ++i) {
            if (count[i] > maxMeetings) {
                maxMeetings = count[i];
                roomNo = i;
            }
        }
        return roomNo;
    }
};
