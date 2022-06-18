package algods.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class CustomHashMap<K, V> {
    private static int CAPACITY = 10; // default capacity
    private CustomNode<K, V>[] bucket = new CustomNode[CAPACITY];   // array of nodes
    private Set<K> keySet = new HashSet<>();    // key set

    public V put(K key, V value) {

        V returnedValue = null; // return value
        if (key == null) {
            return null;
        }

        int index = key.hashCode() % CAPACITY;  // index of the bucket
        keySet.add(key);    // add key to key set

        if (bucket[index] == null) {    // if bucket is empty
            bucket[index] = new CustomNode<>();   // create new node
            bucket[index].setKey(key);  // set key
            bucket[index].setValue(value);  // set value
            bucket[index].setNext(null);
            returnedValue = bucket[index].getValue();   // return value

        } else {

            if (key.equals(bucket[index].getKey())) {   // if key is already present
                bucket[index].setValue(value);  // set value
                returnedValue = bucket[index].getValue();   // return value

            } else if (bucket[index].next == null) {
                bucket[index].next = new CustomNode<>();
                bucket[index].next.setKey(key);
                bucket[index].next.setValue(value);
                bucket[index].next.setNext(null);
                returnedValue = bucket[index].next.getValue();
            }
            else {
                while (bucket[index].next != null) {
                    if (key.equals(bucket[index].getKey())) {
                        bucket[index].setValue(value);
                        returnedValue = bucket[index].getValue();
                    }
                    bucket[index] = bucket[index].next;
                }
            }
        }

        return returnedValue;
    }

    public V get(K key) {

        V returnedValue = null;

        int index = key.hashCode() % CAPACITY;
        if (bucket[index] == null) {
            return null;
        } else {
            if (bucket[index].next == null && key.equals(bucket[index].getKey())) {
                returnedValue = bucket[index].getValue();
            } else {
                while (bucket[index].next != null) {
                    if (key.equals(bucket[index].getKey())) {
                        returnedValue = bucket[index].getValue();
                        break;
                    }
                    bucket[index] = bucket[index].next;
                }
            }
        }
        return returnedValue;
    }

    public V remove(K key) {
        V returnedValue = null;

        int index = key.hashCode() % CAPACITY;

        if (bucket[index] == null) {
            return null;
        } else {
            keySet.remove(key);
            if (key.equals(bucket[index].getKey()) && bucket[index].next == null) {
                returnedValue = bucket[index].getValue();
                bucket[index] = null;
            } else {
                while (bucket[index].next != null) {
                    if (key.equals(bucket[index].getKey())) {
                        returnedValue = bucket[index].getValue();
                        bucket[index] = bucket[index].next.next;
                    }
                    bucket[index] = bucket[index].next;
                }
            }
        }

        return returnedValue;
    }

    public Set<K> keySet() {
        return this.keySet;
    }

    public int size() {
        return CAPACITY;
    }

    public void resize(int newSize) {
        CAPACITY = CAPACITY + newSize;
    }


    public static void main(String[] args) {

        CustomHashMap<String, String> hashMap = new CustomHashMap<>();
        hashMap.put("A", "A");
        hashMap.put("B", "B");
        hashMap.put("C", "C");
        hashMap.put("D", "D");
        hashMap.put("E", "E");
        hashMap.put("F", "F");
        hashMap.put("G", "G");
        hashMap.put("H", "H");
        hashMap.put("I", "I");
        hashMap.put("J", "J");
        hashMap.put("K", "K");

        System.out.println(hashMap.get("A"));
        System.out.println(hashMap.get("B"));
        System.out.println(hashMap.get("C"));
        System.out.println(hashMap.get("D"));
        System.out.println(hashMap.get("E"));
        System.out.println(hashMap.get("F"));
        System.out.println(hashMap.get("G"));
        System.out.println(hashMap.get("H"));
        System.out.println(hashMap.get("I"));
        System.out.println(hashMap.get("J"));
        System.out.println(hashMap.get("K"));

    }
}

class CustomNode<K, V> {
    private K key;
    private V value;
    CustomNode<K, V> next;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public CustomNode<K, V> getNext() {
        return next;
    }

    public void setNext(CustomNode<K, V> next) {
        this.next = next;
    }
}

