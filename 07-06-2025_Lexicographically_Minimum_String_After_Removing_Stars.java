class Solution {
    public String clearStars(String s) {
        int n = s.length();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        Map<Character, Deque<Integer>> indexMap = new HashMap<>();
        boolean[] keep = new boolean[n];
        Arrays.fill(keep, true);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != '*') {
                pq.add(ch);
                indexMap.putIfAbsent(ch, new ArrayDeque<>());
                indexMap.get(ch).addLast(i);
            } else {
                char currentMin = pq.poll();
                int lastPos = indexMap.get(currentMin).removeLast();

                keep[i] = false;
                keep[lastPos] = false;

                if (indexMap.get(currentMin).isEmpty()) {
                    indexMap.remove(currentMin);  // Optional cleanup
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (keep[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
