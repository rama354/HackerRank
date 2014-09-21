package findcommonancestor;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MyFindCommonAncestor implements FindCommonAncestor {

	private Set<String> ancestorset=new LinkedHashSet<String>();
	private Set<String> multilancestors=new HashSet<String>();
	
	@Override
	public String findCommmonAncestor(String[] commitHashes,
			String[][] parentHashes, String commitHash1, String commitHash2) {
		 
		int hash1idx=findHashIdx(commitHashes,commitHash1);
		int hash2idx=findHashIdx(commitHashes,commitHash2);
		String commonAncestor=null;
		
		if (commitHash1.equalsIgnoreCase(commitHash2))
				return commitHash1;
		
		ancestorset.add(commitHash1);
		commonAncestor=addParent(hash1idx,commitHashes,parentHashes);
		
		if (ancestorset.contains(commitHash2))
						return commitHash2;
			
			commonAncestor=addParent(hash2idx,commitHashes,parentHashes);
		
		
		if (multilancestors.size()>1)
			commonAncestor=recenttAnscetor(parentHashes,commitHashes);
				
		return commonAncestor;
	}

	
	private String recenttAnscetor(String[][] parentHashes, String[] commitHashes) 
	{
		 for(String node:multilancestors)
		 {
			 String[] parentnodes=parentHashes[findHashIdx(commitHashes,node)];
			 for (String parent:parentnodes)
			 	 if (multilancestors.contains(parent))
				 	return node;
			 
		 }
		
		 return null;
	}


	private String addParent(int hashidx, String[] commitHashes,
												String[][] parentHashes) 
	{
		String node=null;
		String[] parentHash=parentHashes[hashidx]; 
		if (parentHash!=null)
		{
			for (String hash:parentHash)
			{
				if(ancestorset.contains(hash))
					return  hash;
				ancestorset.add(hash);
				
			}
			
			for (String hash:parentHash)
			{
				node=addParent(findHashIdx(commitHashes,hash),commitHashes,parentHashes);
				if (node!=null)
					multilancestors.add(node);
			}
		}
		return node;
	}

	
	private int findHashIdx(String[] commitHashes, String commitHash) 
	{
		int idx=-1;
		for(int i=0;i<commitHashes.length;i++)
			idx=(commitHashes[i].equalsIgnoreCase(commitHash))?i:idx;
		
			
		return idx;
	}

}
