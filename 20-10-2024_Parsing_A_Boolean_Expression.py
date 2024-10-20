class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        st1 = []
        st2 = []
        
        for exp in expression:
            if exp in ('&', '|', '!'):
                st1.append(exp)
            elif exp in ('t', 'f', '('):
                st2.append(exp)
            elif exp == ')':
                op = st1.pop()
                operand1 = st2.pop()
                if op == '!':
                    operand1 = 'f' if operand1 == 't' else 't'
                while st2[-1] != '(':
                    operand2 = st2.pop()
                    if op == '&':
                        operand1 = 't' if operand1 == 't' and operand2 == 't' else 'f'
                    elif op == '|':
                        operand1 = 'f' if operand1 == 'f' and operand2 == 'f' else 't'
                st2.pop()
                st2.append(operand1)
        
        return st2.pop() == 't'
