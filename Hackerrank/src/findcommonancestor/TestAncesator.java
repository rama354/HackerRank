/**
 * 
 */
package findcommonancestor;

/**
 * @author asus
 *
 */
public class TestAncesator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		String[] commits = {"G", "F", "E", "D", "C", "B", "A"};
		String[][] parents ={{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null}; 
		String commit1 = "B";
		String commit2 = "G";
		MyFindCommonAncestor mycommon=new MyFindCommonAncestor();
		System.out.println(mycommon.findCommmonAncestor(commits, parents, commit1, commit2));
	}

}
