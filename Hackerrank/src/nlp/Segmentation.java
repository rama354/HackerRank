package nlp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Segmentation {

	/**
	 * @param args
	 */
	private static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
	
	private static Map<Integer,StringBuilder> tokensMap=null;
	
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numTc = Integer.parseInt(br.readLine());

		int actualtc = 1;

		while (actualtc <= numTc) {

			String text = br.readLine();
			if (text.indexOf('.') != -1) {
				if (text.indexOf('.') != text.lastIndexOf('.')
						&& text.indexOf('.') == 3)
					text = text.substring(text.indexOf('.') + 1,
							text.lastIndexOf('.'));
				else
					text = text.substring(0, text.indexOf('.'));
			}

			if (text.indexOf("#") == 0) {
				text = text.substring(1);
			}
			
			tokensMap=new HashMap<Integer,StringBuilder>();
			StringBuilder tokensequence=new StringBuilder();
			segmentURLHashTagText(text,tokensequence,0);
			

			if (tokensMap.size() == 0)
				System.out.println(text);
			else
				System.out.println(compareTokensList(tokensMap,text));

			actualtc++;
		}
	}


	private static ArrayList<String> splitter(String text,StringBuilder tokens,int beginidx) 
																throws IOException
	{
		ArrayList<String> matches=new ArrayList<String>();
		String match="";
		boolean isTokenNumeric=false;
		int endidx = beginidx;
		
		while (endidx < text.length()) 
		{
			InputStream is = Segmentation.class
					.getResourceAsStream("words.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String word = br.readLine();
			while (word != null) 
			{
				String subtext = text.substring(beginidx, endidx + 1);
				if (subtext.equalsIgnoreCase(word)
						&& !tokens.toString().equalsIgnoreCase(word) && !matches.contains(word.toLowerCase())  ) {
					match = word.toLowerCase();
					matches.add(match);
					
				}

				if (isNumeric(subtext)
						&& !tokens.toString().equalsIgnoreCase(word)) {
					match = subtext;
					//matches.add(match);
					isTokenNumeric=true;
				}

				word = br.readLine();
			}
			
			br.close();
			endidx++;
		}
		
		if (isTokenNumeric)
			matches.add(match);
		
		return matches;
		
	}
	
	
	
	private static void segmentURLHashTagText(String text, StringBuilder tokensequence,int beginidx) throws IOException 
	{
    	while(true)
		{	
			List<String> tokens=splitter(text,tokensequence,beginidx);
			
			if (tokens.size()==0){
				tokensMap.put(tokensequence.length(), tokensequence);
				return;
			
			}
			for (String token:tokens)
			{
				StringBuilder newtokensequence=new StringBuilder(tokensequence);
				
				segmentURLHashTagText(text,newtokensequence.append(token).append(" "),getTokenSequenceLen(newtokensequence.toString()));
			}
			 
			return;
		}
			
	}

	
	private static int getTokenSequenceLen(String tokensequence) {
		 
		return tokensequence.replaceAll("\\s","").length();
	}


	// compare Valid tokens to get
	private static String compareTokensList(Map<Integer,StringBuilder> map,String text) 
	{
			List<StringBuilder> tokensList = new ArrayList<StringBuilder>(
					map.values());
			while (tokensList.size() >= 2) 
			{
				String first = tokensList.get(0).toString();				
				if(getTokenSequenceLen(first)!= text.length()){
					tokensList.remove(0);
					continue;
				}
				String[] firstokens = first.split(" ");
				
				String second = tokensList.get(1).toString();
				if(getTokenSequenceLen(second)!= text.length()){
					tokensList.remove(1);
					continue;
				}
				String[] secondtokens = second.split(" ");

				int len = (firstokens.length <= secondtokens.length) ? firstokens.length
						: secondtokens.length;
				for (int i = 0; i < len; i++) 
				{
					if (firstokens[i].length() > secondtokens[i].length()){
						tokensList.remove(1);
						break;
					}
					if (firstokens[i].length() < secondtokens[i].length()){
						tokensList.remove(0);
						break;
					}

				}

			}

			return tokensList.get(0).toString().trim();

		}

	private static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
