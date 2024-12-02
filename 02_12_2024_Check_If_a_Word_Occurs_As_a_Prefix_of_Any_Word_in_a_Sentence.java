import java.util.StringTokenizer;

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        int n = searchWord.length();
        int t = 0;
        
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            t++;
            if (searchWord.equals(word.substring(0, Math.min(n, word.length())))) {
                return t;
            }
        }
        return -1;
    }
}

