class Solution:
    def countDominant(self, s: str) -> int:
        n = len(s)
        pref = [0] * (n + 1)
        zeroPos = []

        # prefix ones + collect zeros
        for i, c in enumerate(s):
            pref[i+1] = pref[i] + (c == '1')
            if c == '0':
                zeroPos.append(i)

        Z = len(zeroPos)
        K = int(n ** 0.5) + 3
        ans = 0

        # Case z = 0 → count substrings of only 1's
        cnt = 0
        for c in s:
            if c == '1':
                cnt += 1
            else:
                ans += cnt * (cnt + 1) // 2
                cnt = 0
        ans += cnt * (cnt + 1) // 2

        # z = 1..K zeros
        for z in range(1, K + 1):
            if z > Z:
                break

            for j in range(z - 1, Z):
                # Substring has z zeros: zeroPos[j-z+1] ... zeroPos[j]
                leftZero  = -1 if j - z < 0 else zeroPos[j - z]
                firstZero = zeroPos[j - z + 1]
                lastZero  = zeroPos[j]
                rightZero = zeroPos[j + 1] if j + 1 < Z else n

                # L in [leftZero+1, firstZero]
                # R in [lastZero, rightZero-1]
                for L in range(leftZero + 1, firstZero + 1):
                    lo, hi = lastZero, rightZero - 1
                    best = rightZero

                    # binary search for smallest R
                    while lo <= hi:
                        mid = (lo + hi) // 2
                        ones = pref[mid+1] - pref[L]
                        if ones >= z * z:
                            best = mid
                            hi = mid - 1
                        else:
                            lo = mid + 1

                    if best < rightZero:
                        ans += (rightZero - best)

        return ans
