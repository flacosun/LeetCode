/**
 * 211. Add and Search Word - Data structure design
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/10/2016.
 */
public class AddAndSearchWordDataStructureDesign {
    public class WordDictionary {

        TrieNode root = new TrieNode();

        // Trie tree.
        private class TrieNode {
            boolean isLeaf;
            TrieNode[] children;
            TrieNode() {
                isLeaf = false;
                this.children = new TrieNode[26];
            }
        }

        // Adds a word into the data structure.
        public void addWord(String word) {
            TrieNode n = root;
            for (char c : word.toCharArray()) {
                if (n.children[c - 'a'] == null) {
                    n.children[c - 'a'] = new TrieNode();
                }
                n = n.children[c - 'a'];
            }
            n.isLeaf = true;

        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return dfsSearch(word, 0, root);
        }

        private boolean dfsSearch(String word, int i, TrieNode root) {
            if (root == null) {
                return false;
            }
            if (i == word.length()) {
                return root.isLeaf;
            }
            char c = word.charAt(i);
            boolean result = false;
            if (c == '.') {
                for (TrieNode child : root.children) {
                    result = result || dfsSearch(word, i + 1, child);
                }
            } else {
                result = dfsSearch(word, i + 1, root.children[c - 'a']);
            }

            return result;
        }
    }
}
