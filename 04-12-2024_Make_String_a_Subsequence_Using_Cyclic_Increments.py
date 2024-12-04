class Solution(object):
    def canMakeSubsequence(self, str1, str2):
        i=0
        j=0
        while (i<len(str1) and j<len(str2)):
            if (str1[i]==str2[j]):
                j=j+1
            elif  (str1[i]=="z"):
                if ("a"==str2[j]):
                    j=j+1
            elif (str1[i]!="z"):
                if (chr(ord(str1[i])+1)==str2[j]):
                    j=j+1
            i=i+1
        if (j==len(str2)):
            return True
        else:
            return False
