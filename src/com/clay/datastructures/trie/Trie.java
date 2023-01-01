package datastructures.trie;

/**
 *  * Your Trie object will be instantiated and called as such:
 *  * Trie obj = new Trie();
 *  * obj.insert(word);
 *  * boolean param_2 = obj.search(word);
 *  * boolean param_3 = obj.startsWith(prefix);
 */
public class Trie {
    TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode('0'); //Dummy Node
    }

    public void insert(String word) {
        TrieNode currentNode = rootNode;
        for (Character ch : word.toCharArray()) {
            if (currentNode.childrens[ch - 'a'] == null) {
                currentNode.childrens[ch - 'a'] = new TrieNode(ch);
            }
            currentNode = currentNode.childrens[ch - 'a'];
        }

        currentNode.endOfCharacter = true;
    }

    public boolean search(String word) {
        TrieNode current = getLastValue(word);
        return current != null && current.endOfCharacter;
    }

    private TrieNode getLastValue(String word) {
        TrieNode current = rootNode;
        for (Character ch : word.toCharArray()) {
            if (current.childrens[ch - 'a'] == null) {
                return null;
            }
            current = current.childrens[ch - 'a'];
        }
        return current;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = getLastValue(prefix);
        return current != null;
    }
}

class TrieNode {
    Character value;
    TrieNode[] childrens;
    boolean endOfCharacter;

    TrieNode() {
    }

    TrieNode(Character value) {
        this.value = value;
        this.childrens = new TrieNode[26];
        this.endOfCharacter = false;
    }

}