package cryptography;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class KeywordCipher {

	/**
	 * @param args
	 */
	private static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
	private static Map<Character, Character> cipher = null;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numtc = Integer.parseInt(br.readLine());

		while (numtc != 0) {
			String keyword = br.readLine();
			if (keyword.length() > 7)
				return;
			
			//keyword = keyword.replaceAll("(.)(?=.*\\1)", "");		

			String encodedText = br.readLine();
			if (encodedText.length() > 255)
				return;
			
			cipher=new HashMap<Character, Character>();
			createCipher(refineKeyword(keyword));

			decipherMessage(encodedText);
			numtc--;
		}

	}

	private static String refineKeyword(String keyword) 
	{
		char[] keyletters=keyword.toCharArray();
		Set<Character> set=new LinkedHashSet<Character>();
		
		for(int i=0;i<keyletters.length;i++)
			set.add(new Character(keyletters[i]));
		
		Character[] refinedkey=new Character[set.size()];set.toArray(refinedkey);
		
		StringBuilder refinedKeyword=new StringBuilder();
		for(Character c:refinedkey)
			refinedKeyword.append(c.toString());
		
		return refinedKeyword.toString();
			
	}

	private static void createCipher(String keyword) {
		Map<Integer, String> tempcipher = new TreeMap<Integer, String>();
		int keywordlen = keyword.length();

		int letters = 65;
		while (letters < 91) 
		{
			for (int col = 0; col < keywordlen; col++) 
			{
				if (letters > 90) {
					break;
				}
				StringBuilder sb = null;
				if (tempcipher.get((int) keyword.charAt(col)) == null) {
					sb = new StringBuilder(Character.toString(keyword
							.charAt(col)));
					tempcipher.put((int) keyword.charAt(col), sb.toString());
				} else {
					sb = new StringBuilder(tempcipher.get((int) keyword
							.charAt(col)));

					while (keyword.indexOf(letters) != -1 && letters < 91)
						++letters;
					sb.append(Character.toString((char) letters++));

					tempcipher.put((int) keyword.charAt(col), sb.toString());
				}

			}

		}

		int alphabet = 65;
		
		for (String str : tempcipher.values()) 
		{
			for (int i = 0; i < str.length(); i++)
				cipher.put(new Character(str.charAt(i)), new Character(
						(char) alphabet++));
		}

	}

	private static void decipherMessage(String encodedText) {
		for (int i = 0; i < encodedText.length(); i++) 
		{
			char c = encodedText.charAt(i);
			if (c != ' ')
				System.out.print(cipher.get(new Character(c)));
			else
				System.out.print(" ");
		}
		System.out.println();
	}

}
