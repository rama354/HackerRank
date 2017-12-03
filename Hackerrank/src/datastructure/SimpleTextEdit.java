package datastructure;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEdit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int Q=sc.nextInt();
		String s=new String();
		Stack<Undo> undo_stack=new Stack<Undo>();
		
		while(Q>0){
			int t=sc.nextInt();
			switch(t){
				case 1: undo_stack.push(new Undo(s));s=append(s,sc.next());break;
				case 2: undo_stack.push(new Undo(s));s=delete(s,sc.nextInt());break;
				case 3: print(s,sc.nextInt());break;
				case 4: s=undo_stack.pop().undo_str;break;
			}
			Q--;
		}

	}

	private static void print(String str,int k) {
		if (k<=str.length())
			System.out.println(str.charAt(k-1));
	}

	private static String delete(String str,int k) {
		return str.substring(0,str.length()-k);
	}

	private static String append(String str,String append) {
		StringBuilder sb=new StringBuilder(str);
		return sb.append(append).toString();
	}

	private static class Undo{
		String undo_str;
		Undo(String undo_str)
		{
			this.undo_str=undo_str;
		}
	}
}
