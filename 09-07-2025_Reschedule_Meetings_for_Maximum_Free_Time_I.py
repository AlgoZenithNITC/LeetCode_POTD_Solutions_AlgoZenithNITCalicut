def maxFreeTime(self, eventTime: int, k: int, startTime: List[int], endTime: List[int]) -> int:
    n = len(startTime)
    l, r = 0, k - 1
    ans = 0
    temp = sum(endTime[i] - startTime[i] for i in range(k))

    left = 0
    right = endTime[k - 1]

    while r < n:
        if l - 1 >= 0:
            left = endTime[l - 1]
        else:
            left = 0

        if r + 1 < n:
            right = startTime[r + 1]
        else:
            right = eventTime

        ans = max(ans, right - left - temp)

        temp -= endTime[l] - startTime[l]
        l += 1
        r += 1
        if r >= n:
            break
        temp += endTime[r] - startTime[r]

    return ans
