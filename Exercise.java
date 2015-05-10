public class Main {
	public static int lengthOfLastWord(String s) {
//		Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//				If the last word does not exist, return 0.
//
//				Note: A word is defined as a character sequence consists of non-space characters only.
//
//				For example, 
//				Given s = "Hello World",
//				return 5.
		String[] words = s.split(" ");
		if (words.length == 0) {
			return 0;
		}
		return words[words.length - 1].length();
	}

	public static boolean isIsomorphic(String s, String t) {
//		Given two strings s and t, determine if they are isomorphic.
//
//		Two strings are isomorphic if the characters in s can be replaced to get t.
//
//		All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
//		For example,
//		Given "egg", "add", return true.
//
//		Given "foo", "bar", return false.
//
//		Given "paper", "title", return true.
		String sKey = getKey(s);
		String tKey = getKey(t);

		if (sKey.equals(tKey)) {
			return true;
		}

		return false;
	}

	public static String getKey(String s) {
		// helper method used by isIsomorphic
		String history = "";
		String key = "";
		
		for (int i = 0; i < s.length(); i++) {
			
			String c = Character.toString(s.charAt(i));
			
			if (history.contains(c) == false) {
				history = history + c;
				key = key + history.indexOf(c);
			}

			else if (i == s.length() - 1) {
				return key;
			}

			else {
				key = key + history.indexOf(c);
			}
		}
		return "error";
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic("odd", "egg"));
		System.out.println(isIsomorphic("title", "paper"));
		System.out.println(isIsomorphic("wombo", "combo"));
		System.out.println(isIsomorphic("sdfsdf", "dfssdffdsfff"));
		
	}

}
