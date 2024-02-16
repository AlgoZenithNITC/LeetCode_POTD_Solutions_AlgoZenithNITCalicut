public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> npp = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );
        for (int i : arr) {
            mpp.put(i, mpp.getOrDefault(i, 0) + 1);
        }
        npp.addAll(mpp.entrySet());
        while (k > 0 && !npp.isEmpty()) {
            Map.Entry<Integer, Integer> entry = npp.poll();
            if (k >= entry.getValue()) {
                k -= entry.getValue();
                mpp.remove(entry.getKey());
            } else {
                break;
            }
        }
        return mpp.size();
    }
}

