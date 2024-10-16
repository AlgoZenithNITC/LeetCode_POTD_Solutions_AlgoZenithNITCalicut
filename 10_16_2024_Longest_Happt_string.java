import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.count - x.count);
        
        if (a > 0) pq.add(new Pair(a, "a"));
        if (b > 0) pq.add(new Pair(b, "b"));
        if (c > 0) pq.add(new Pair(c, "c"));

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int count = current.count;
            String node = current.character;

            int len = result.length();
            if (len >= 2 && result.charAt(len - 1) == node.charAt(0) && result.charAt(len - 2) == node.charAt(0)) {
                if (pq.isEmpty()) break;
                Pair next = pq.poll();
                result.append(next.character);
                if (next.count - 1 > 0) {
                    pq.add(new Pair(next.count - 1, next.character));
                }
                pq.add(current);
            } else {
                result.append(node);
                count--;
                if (count > 0) {
                    pq.add(new Pair(count, node));
                }
            }
        }

        return result.toString();
    }

    class Pair {
        int count;
        String character;

        Pair(int count, String character) {
            this.count = count;
            this.character = character;
        }
    }
}
