def maximumUniqueSubarray(self, arr: List[int]) -> int:
    n = len(arr)
    l = 0
    cum = 0
    ans = 0
    from collections import defaultdict
    mp = defaultdict(int)

    for r in range(n):
        mp[arr[r]] += 1
        cum += arr[r]

        # shrink window until all elements are unique
        while len(mp) < (r - l + 1):
            mp[arr[l]] -= 1
            cum -= arr[l]
            if mp[arr[l]] == 0:
                del mp[arr[l]]
            l += 1

        if len(mp) == (r - l + 1):
            ans = max(ans, cum)

    return ans
