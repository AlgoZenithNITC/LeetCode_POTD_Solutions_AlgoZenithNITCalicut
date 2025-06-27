public String longestSubsequenceRepeatedK(String s, int k) {
    String result = "";
    Queue<String> q = new LinkedList<>();
    q.offer("");

    while (!q.isEmpty()) {
        String curr = q.poll();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            String next = curr + ch;
            if (isK(next, s, k)) {
                if (next.length() > result.length() || 
                   (next.length() == result.length() && next.compareTo(result) > 0)) {
                    result = next;
                }
                q.offer(next);
            }
        }
    }

    return result;
}

private boolean isK(String sub, String t, int k) {
    int count = 0, i = 0;
    for (char ch : t.toCharArray()) {
        if (ch == sub.charAt(i)) {
            i++;
            if (i == sub.length()) {
                i = 0;
                count++;
                if (count == k) return true;
            }
        }
    }
    return false;
}
