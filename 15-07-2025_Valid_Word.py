class Solution(object):
    def isValid(self, word):
        """
        :type word: str
        :rtype: bool
        """
        if (word.isalnum() and len(word)>=3 and any(e in word.lower() for e in ['a','e','i','o','u']) and any(e in word.lower() for e in list("abcdfghjklmnpqrstvwxyz"))):
            return True
        else:
            return False      
