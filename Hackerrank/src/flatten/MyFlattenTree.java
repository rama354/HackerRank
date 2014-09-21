/**
 * 
 */
package flatten;

import java.util.ArrayList;
import java.util.List;

import flatten.Tree.Leaf;
import flatten.Tree.Node;

/**
 * @author asus
 * @param <T>
 *
 */
public class MyFlattenTree<T> implements FlattenTree<T> {

	@Override
	public List<T> flattenInOrder(Tree<T> tree) 
	{
		if(tree == null)
            throw new IllegalArgumentException();
		
		List<T> flattree=new ArrayList<T>();
		Either<T, Triple<Tree<T>>> either=null;
		
			
	}

}
