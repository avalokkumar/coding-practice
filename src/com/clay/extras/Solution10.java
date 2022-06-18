package extras;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Goodbye bye bye world world world
 *
 */
public class Solution10 {

	public static void main(String[] args) {

        String regex = "[a-z]+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        
        while (numSentences-- > 0) {
            String input = in.nextLine();
            boolean isMoreMatch = false;
            
            Matcher m = p.matcher(input);
            
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
            	
        		input = input.replaceAll(m.group(), "");
            	
            }
            // Prints the modified sentence.
            System.out.println(input);
        }
        
        in.close();
    }
}

/*
 * String text    =
		        "This is the text which is to be searched " +
		        "for occurrences of the word 'is'.";

		String regex = "is";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		int count = 0;
		while(matcher.find()) {
		    count++;
		    System.out.println("found: " + count + " : "
		            + matcher.start() + " - " + matcher.end());
		}
 * */