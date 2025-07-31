class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();

        for (int num : arr) {
            Set<Integer> newCur = new HashSet<>();
            newCur.add(num);
            for (int x : cur) {
                newCur.add(x | num);
            }
            cur = newCur;
            res.addAll(cur);
        }

        return res.size();
    }

}
