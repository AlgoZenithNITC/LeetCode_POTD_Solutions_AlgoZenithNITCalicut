class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        st = []

        n = len(s)
        s_list = list(s)

        for i in range(n):
            if s[i] == '(':
                st.append(('(', i))
            if s[i] == ')':
                if not st:
                    s_list[i] = '#'
                else:
                    st.pop()

        while st:
            s_list[st[-1][1]] = '#'
            st.pop()

        s_list = [ch for ch in s_list if ch != '#']

        return ''.join(s_list)

        
