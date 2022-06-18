package websites.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheTest {

    final Node head = new Node();
    final Node tail = new Node();

    Map<Integer, Node> map;
    int cacheCapacity;

    LRUCacheTest(int capacity) {
        cacheCapacity = capacity;
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    private int get(int key) {
        int result = -1;
        Node node = map.get(key);
        if (node != null) {
            result = node.val;
            remove(node);
            add(node);
        }

        return result;
    }

    private void put(int key, int newVal) {
        Node newNode = map.get(key);

        if (newNode != null) { //if true update the existing value and move the node to the head
            remove(newNode);
            newNode.val = newVal;
            add(newNode);
        } else {
            if (map.size() == cacheCapacity) { // if node not found and cache is full remove the last node
                map.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node node = new Node(); //create a new node
            node.key = key;
            node.val = newVal;

            map.put(key, node); // add in the map
            add(node);  //add in the doubly linked list
        }
    }

    private void add(Node node) {
        Node nextNode = head.next;
        node.next = nextNode;
        nextNode.prev = node;

        head.next = node;
        node.prev = head;
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public static void main(String[] args) {

        LRUCacheTest cache = new LRUCacheTest(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("cache.get(1) " + cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println("cache.get(2) "+ cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println("cache.get(1) "+ cache.get(1));       // returns -1 (not found)
        System.out.println("cache.get(3)  "+ cache.get(3));       // returns 3
        System.out.println("cache.get(4) "+ cache.get(4));       // returns 4
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;
}