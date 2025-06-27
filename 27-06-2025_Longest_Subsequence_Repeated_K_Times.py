def longestSubsequenceRepeatedK(self, s: str, k: int) -> str:
    from collections import deque

    def isK(sub: str, t: str, k: int) -> bool:
        count = 0
        i = 0
        for ch in t:
            if ch == sub[i]:
                i += 1
                if i == len(sub):
                    i = 0
                    count += 1
                    if count == k:
                        return True
        return False

    result = ""
    q = deque()
    q.append("")

    while q:
        curr = q.popleft()
        for ch in map(chr, range(ord('a'), ord('z') + 1)):
            next_str = curr + ch
            if isK(next_str, s, k):
                if (len(next_str) > len(result)) or \
                   (len(next_str) == len(result) and next_str > result):
                    result = next_str
                q.append(next_str)

    return result
