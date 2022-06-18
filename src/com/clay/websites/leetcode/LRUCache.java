package websites.leetcode;

public class LRUCache {
    private int capacity;
    private int size;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        Node node = findNode(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = findNode(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        node = new Node(key, value);
        if (size == capacity) {
            removeTail();
        } else {
            size++;
        }
        addToHead(node);
    }

    private void removeTail() {
        Node node = tail.pre;
        node.next = null;
        tail = node;
    }

    private void addToHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
    }

    private void moveToHead(Node node) {
        if (node == head) {
            return;
        }
        if (node == tail) {
            tail = node.pre;
            tail.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        addToHead(node);
    }

    private Node findNode(int key) {
        Node node = head;
        while (node != null) {
            if (node.key == key) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
