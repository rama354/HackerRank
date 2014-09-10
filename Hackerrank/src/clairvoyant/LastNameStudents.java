package clairvoyant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class LastNameStudents {

	/**
	 * @param args
	 */
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException 
	{
		int numOfStudents=Integer.parseInt(br.readLine());
		ArrayList<Student> studentlist=new ArrayList<Student>();
		
		for(int i=0;i<numOfStudents;i++)
		{
			String[] str=br.readLine().split(" ");
			studentlist.add(new Student(str[0],str[1]));
		}
			
		LinkedHashSet<Student> studentset=new LinkedHashSet<Student>();
		for(Student s:studentlist)
			studentset.add(s);
		
		for(Student s:studentset)
			System.out.println(s.getFirstName()+" "+s.getLastName());
	}

}
