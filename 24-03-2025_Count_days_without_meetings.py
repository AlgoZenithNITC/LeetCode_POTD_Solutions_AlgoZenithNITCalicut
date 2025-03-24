def countDays(self, days: int, meetings: List[List[int]]) -> int:
    meetings.sort()
    r = 0
    ans = days

    for pair in meetings:
        if pair[1] <= r:
            continue
        else:
            ans -= (pair[1] - max(pair[0], r))
            if r < pair[0]:
                ans -= 1
            r = pair[1]
    
    return ans
