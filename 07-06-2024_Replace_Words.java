import java.util.List;
import java.util.StringJoiner;

class Solution {
    public static class Trie {
        private Trie[] children = new Trie[26];
        private boolean isEnd;

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public String findRoot(String word) {
            Trie node = this;
            StringBuilder prefix = new StringBuilder();
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    break;
                }
                node = node.children[index];
                prefix.append(c);
                if (node.isEnd) {
                    return prefix.toString();
                }
            }
            return word;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String root : dictionary) {
            trie.insert(root);
        }
        
        StringJoiner result = new StringJoiner(" ");
        String[] words = sentence.split(" ");
        for (String word : words) {
            result.add(trie.findRoot(word));
        }
        
        return result.toString();
    }
}
