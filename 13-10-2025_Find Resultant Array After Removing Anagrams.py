class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        ans = [words[0]]
        
        for i in range(1, len(words)):
            a_sorted = ''.join(sorted(words[i]))
            b_sorted = ''.join(sorted(ans[-1]))
            
            if a_sorted != b_sorted:
                ans.append(words[i])
                
        return ans