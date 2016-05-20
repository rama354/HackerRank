package euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NDigitFibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Map<Integer, Long> ndigitMap = new HashMap<Integer, Long>();
		while (T > 0) {
			int N = sc.nextInt();
			Long ans = ndigitMap.get(new Integer(N));
			if (ans == null)
				ans = fiboNacciSeries(N, ndigitMap);

			System.out.println(ans);
			T--;
		}
	}

	private static long fiboNacciSeries(int n, Map<Integer, Long> ndigitMap) {
		List<Integer> F1 = new ArrayList<Integer>();
		List<Integer> F2 = new ArrayList<Integer>();

		F1.add(1);
		F2.add(2);
		long fibidx = 3;
		int digitCount = 0;
		while (true) {
			List<Integer> tempfib = new ArrayList<Integer>(F2);
			addOperation(F2, F1);
			fibidx++;
			digitCount = F2.size();
			if (!ndigitMap.containsKey(digitCount)) {
				ndigitMap.put(digitCount, fibidx);
				if (digitCount == n)
					break;
			}

			F1 = tempfib;
		}

		return fibidx;
	}

	private static void addOperation(List<Integer> F2, List<Integer> F1) {
		int carry = 0;
		int F1len = F1.size();
		int F2len = F2.size();
		for (int i = 0; i < F1len; i++) {
			int sum = F2.get(i) + F1.get(i) + carry;
			F2.set(i, sum % 10);
			carry = sum / 10;

		}

		while (carry > 0) {
			int overflow = carry;
			if (F2len > F1len) {
				overflow = F2.get(F1len) + overflow;
				F2.set(F1len, overflow % 10);
				F1len++;
			} else
				F2.add(overflow);

			carry = overflow / 10;
		}

	}

}
