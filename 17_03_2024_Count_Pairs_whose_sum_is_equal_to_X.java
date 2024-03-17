class Solution {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                          int x) {
        // add your code here
        HashSet<Integer> set = new HashSet<>();
        for(int i : head2)set.add(i);
        int count = 0;
        for(int i : head1){
            int val = x-i;
            if(set.contains(val))count++;
        }
        return count;
    }
}
