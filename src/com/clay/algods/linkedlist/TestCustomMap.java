package algods.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Design a HashMap in Java. Implement put, get, remove, resize methods.
public class TestCustomMap {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static CustomHashMap<String, String> customHashMap = new CustomHashMap<>();

    public static void main(String args[]) throws IOException {

        System.out.println("Enter\n1 display map value\n2 to add value\n3 to remove value\n4 to resize\n5 to exit");

        while (true) {
            int ch = Integer.parseInt(br.readLine());
            switch (ch) {
                case 1:
                    displayMap();
                    break;
                case 2:
                    System.out.println("Enter the key and value to be inserted in CustomMap");
                    String key = br.readLine();
                    String value = br.readLine();
                    customHashMap.put(key, value);
                    break;
                case 3:
                    System.out.println("Enter the key to remove value from CustomMap");
                    String keyToRemove = br.readLine();
                    customHashMap.remove(keyToRemove);
                    break;
                case 4:
                    System.out.println("Enter the new Size for custom map");
                    int newSize = Integer.valueOf(br.readLine());
                    customHashMap.resize(newSize);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    private static void displayMap() {
        for (String key : customHashMap.keySet()) {
            System.out.println(customHashMap.get(key));
        }
    }
}
