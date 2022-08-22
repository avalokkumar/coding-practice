package stack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BalancedBraces {
    public static void main(String[] args) {
        Map<String, String> bracesMap = new HashMap<>()
        {{
            put( "}", "{");
            put("]", "[");
            put(")", "(" );
        }};

        String braces = "{[{}]}";
        System.out.println(isBalanced(braces, bracesMap));
    }

    private static boolean isBalanced(String braces, Map<String, String> bracesMap) {
        String[] openingBraces = {"{", "[", "("};
        String[] closingBraces = {"}", "]", ")"};
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < braces.length(); i++) {
            String currentBrace = String.valueOf(braces.charAt(i));

            if (isOpeningBrace(currentBrace)) {
                stack.push(currentBrace);
            }

            if (isClosingBrace(currentBrace)) {
                String lastStackElem = stack.peek();
                if (bracesMap.get(currentBrace).equals(lastStackElem)) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isClosingBrace(String currentBrace) {

        return List.of("}", "]", ")").contains(currentBrace);
    }

    private static boolean isOpeningBrace(String currentBrace) {

        return List.of("{", "[", "(").contains(currentBrace);
    }
}
