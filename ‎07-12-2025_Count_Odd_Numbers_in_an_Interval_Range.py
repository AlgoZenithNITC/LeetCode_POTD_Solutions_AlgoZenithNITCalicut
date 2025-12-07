class Solution(object):
    def countOdds(self, low, high):
        """
        :type low: int
        :type high: int
        :rtype: int
        """
        if high%2==0:
            if low%2==0:
                return (high-low)//2   
            else:
                return ((high-low)/2)+1
        else:
            if low%2==0:
                return (high+1-low)/2
            else:
                return ((high-low)/2)+1
