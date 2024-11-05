public class Main {

    public static int minChanges(String s) {
        int changes = 0;
        int n = s.length();
        
        // Iterate over the string, comparing adjacent characters
        for (int i = 0; i < n - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }
        
        return changes;
    }