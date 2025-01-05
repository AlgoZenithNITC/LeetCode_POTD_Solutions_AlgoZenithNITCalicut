class Solution:
    def shiftingLetters(self, s: str, shifts: list[list[int]]) -> str:
        n = len(s)
        
       
        diffArray = [0] * n
        
        for query in shifts:
            left, right, dir = query[0], query[1], 1 if query[2] == 1 else -1
            
            diffArray[left] += dir
            if right + 1 < n:
                diffArray[right + 1] -= dir
        
        prefixSum = 0
        result = list(s)  
        

        for i in range(n):
            pos = ord(result[i]) - ord('a')
            prefixSum += diffArray[i]
            newPos = (pos + prefixSum) % 26
            
            if newPos < 0:
                newPos += 26
            
            result[i] = chr(ord('a') + newPos) 
        
        return ''.join(result)  
