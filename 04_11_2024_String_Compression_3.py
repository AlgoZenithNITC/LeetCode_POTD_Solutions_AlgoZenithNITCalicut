class Solution:
    def compressedString(self, word: str) -> str:
        n = len(word)
        ans = []
        i = 1
        st = 0

        while i < n:
            while i < n and word[i - 1] == word[i] and (i - st) < 10:
                i += 1
            if i - st == 10:
                i -= 1
            ans.append(str(i - st))
            ans.append(word[st])
            st = i
            i += 1

        if st == n - 1:
            ans.append(str(i - st))
            ans.append(word[st])

        return ''.join(ans)