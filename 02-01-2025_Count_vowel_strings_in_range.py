def is_vowel(self, ch):
    return ch in {'a', 'e', 'i', 'o', 'u'}

def search(self, s):
    starts_with_vowel = self.is_vowel(s[0])
    ends_with_vowel = self.is_vowel(s[-1])
    return starts_with_vowel and ends_with_vowel

def vowelStrings(self, words, queries):
    """
    :type words: List[str]
    :type queries: List[List[int]]
    :rtype: List[int]
    """
    n = len(words)
    binary = [0] * n
    
    for i in range(n):
        if self.search(words[i]):
            binary[i] = 1
    
    for i in range(1, n):
        binary[i] += binary[i - 1]
    
    ans = []
    for query in queries:
        l, r = query
        l -= 1  # Convert 1-based to 0-based index
        
        if l < 0:
            temp = binary[r]
        else:
            temp = binary[r] - binary[l]
        
        ans.append(temp)
    
    return ans
