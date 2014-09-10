import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GemStones {

	/**
	 * @param args
	 */
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		int numTc = Integer.parseInt(br.readLine());
		if (numTc<1 || numTc>100)
			return;
		
		int actualtc=1;
		List<String> compositions=new ArrayList<String>();
		
		while(actualtc<=numTc)
		{			
			compositions.add(br.readLine());
			actualtc++;		
		}
			
		int numGemElems=0;
		Set<Character> elemset= new HashSet<Character>();
		
		for (String composition:compositions)
		{
			char[] elems= composition.toCharArray();
			if (elems.length<1 ||elems.length>100)
				return;
			
			for (char element:elems)
			{
				elemset.add(new Character(element));
			}
			
		}
					
		for (char element:elemset)
		{
				if (element<97 || element>122)
					return;	
				else
				{				
					boolean isGemElem=true;
					for (String nestedcomp:compositions)
					{
						if (nestedcomp.indexOf(element)==-1)
							isGemElem=false;
					}
					
					if(isGemElem)
						numGemElems++;
				}					
		}		
						
		System.out.println(numGemElems);
		
	}

}
