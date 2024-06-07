class Trie:
    def __init__(self):
        self.children = [None] * 26
        self.is_end = False

    def insert(self, word, pos=0):
        if pos < len(word):
            index = ord(word[pos]) - ord('a')
            if not self.children[index]:
                self.children[index] = Trie()
            if self.children[index].is_end:
                return
            self.children[index].insert(word, pos + 1)
        else:
            self.is_end = True

    def find(self, word, pos=0):
        if pos == len(word):
            return word, self.is_end
        index = ord(word[pos]) - ord('a')
        if self.children[index]:
            if self.children[index].is_end:
                return word[:pos + 1], True
            return self.children[index].find(word, pos + 1)
        return word, False


class Solution:
    def replaceWords(self, dictionary, sentence):
        trie = Trie()
        for root in dictionary:
            trie.insert(root)
        
        result = []
        words = sentence.split()
        for word in words:
            replacement, _ = trie.find(word)
            result.append(replacement)
        
        return ' '.join(result)
