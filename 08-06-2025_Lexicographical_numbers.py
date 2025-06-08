def lexicalOrder(self, n: int) -> List[int]:
    ans = []
    
    def solve(ans: List[int], n: int, num: int):
        if num > n:
            return
        for i in range(10):
            if num + i > n:
                break
            if num == 1 and i == 9:
                break
            ans.append(num + i)
            solve(ans, n, (num + i) * 10)
    
    solve(ans, n, 1)
    return ans
