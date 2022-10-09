import java.util.Arrays;

/**
 * Description: Two strings are said to be anagram if we can form one string by arranging the characters of another string.
 */
public class Anagram {	  

	public static void main(String[] args) {
		Anagram.isAnagram( "Race", "Care");
		Anagram.isAnagram( "Wars", "Raw");
		Anagram.isAnagram( "King", "Ring");
	}
	
	private static void isAnagram(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		// convert strings to char array
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();

		// sort the char array
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);

		// check if sorted char arrays are same		
		boolean result = Arrays.equals(charArray1, charArray2);

		// If sorted array are the same and have same length then the string is anagram
		if(result && (str1.length() == str2.length())) {
			System.out.println(str1 + " & " + str2 + " are Anagram.");
		}
		else {
			System.out.println(str1 + " & " + str2 + " are NOT Anagram.");
		}
	}
}