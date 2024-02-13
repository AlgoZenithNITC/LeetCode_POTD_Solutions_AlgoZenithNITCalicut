public class Solution {
    public String firstPalindrome(String[] words) {
        
        for (String word : words) {
            if (new StringBuilder(word).reverse().toString().equals(word)) {
                return word;
            }
        }
        return "";
    }
}
