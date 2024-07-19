class Solution(object):
    def luckyNumbers (self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        rows=len(matrix)
        ans=0
        for r_idx,row in enumerate(matrix):
            min_ele=min(row)
            col_idx=row.index(min_ele)
            r=0
            while r<rows:
                if matrix[r_idx][col_idx]<matrix[r][col_idx]:
                    break
                r+=1
            if r==rows:
                return [min_ele]
