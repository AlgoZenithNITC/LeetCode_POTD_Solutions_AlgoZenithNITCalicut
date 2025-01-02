private boolean isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
}

private boolean search(String s) {
    boolean startsWithVowel = isVowel(s.charAt(0));
    boolean endsWithVowel = isVowel(s.charAt(s.length() - 1));
    return startsWithVowel && endsWithVowel;
}

public int[] vowelStrings(String[] words, int[][] queries) {
    int n = words.length;
    int[] binary = new int[n];
    
    for (int i = 0; i < n; i++) {
        if (search(words[i])) {
            binary[i] = 1;
        }
    }
    
    for (int i = 1; i < n; i++) {
        binary[i] += binary[i - 1];
    }
    
    int[] ans = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
        int l = queries[i][0];
        int r = queries[i][1];
        
        int temp;
        if (l == 0) {
            temp = binary[r];
        } else {
            temp = binary[r] - binary[l - 1];
        }
        ans[i] = temp;
    }
    
    return ans;
}
