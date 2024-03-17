class Solution:
    def countPair(self, head1, head2, n1, n2, x):
        '''
        head1:  head of linkedList 1
        head2:  head of linkedList 2
        n1:  len of  linkedList 1
        n2:  len of linkedList 1
        x:   given sum
        '''
        D = dict()
        count = 0
        
        while head1:
            D[x - head1.data] = D.get(x-head1.data, 0)+1
            head1 = head1.next
            
        while head2:
            count += D.get(head2.data, 0)
            head2 = head2.next
        return count
