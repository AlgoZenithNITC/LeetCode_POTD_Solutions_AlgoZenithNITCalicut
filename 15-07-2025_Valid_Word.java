public class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3 || !word.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        String lower = word.toLowerCase();
        boolean hasVowel = false, hasConsonant = false;

        for (char c : lower.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                hasVowel = true;
            } else if ("bcdfghjklmnpqrstvwxyz".indexOf(c) >= 0) {
                hasConsonant = true;
            }
        }

        return hasVowel && hasConsonant;
    }
}
