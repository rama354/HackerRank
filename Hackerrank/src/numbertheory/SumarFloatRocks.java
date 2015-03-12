package numbertheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumarFloatRocks {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numoftcs = Integer.parseInt(br.readLine());

		// System.out.println("numoftcs "+numoftcs);

		if (numoftcs < 1 || numoftcs > 100000)
			return;

		while (numoftcs > 0) {

			String[] coordinates = br.readLine().split(" ");
			long x1 = Long.parseLong(coordinates[0]);
			if (x1 < Math.pow(-10, 9) || x1 > Math.pow(10, 9))
				return;

			long y1 = Long.parseLong(coordinates[1]);
			if (y1 < Math.pow(-10, 9) || y1 > Math.pow(10, 9))
				return;

			long x2 = Long.parseLong(coordinates[2]);
			if (x2 < Math.pow(-10, 9) || x2 > Math.pow(10, 9))
				return;

			long y2 = Long.parseLong(coordinates[3]);
			if (y2 < Math.pow(-10, 9) || y2 > Math.pow(10, 9))
				return;

			System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + "...."
					+ getRocksCount(x1, y1, x2, y2));

			numoftcs--;
		}

	}

	private static long getRocksCount(long x1, long y1, long x2, long y2) {
		long rockscount = 0;
		double slope = (double) (y1 - y2) / (x1 - x2);

		if (slope != 0.0) {
			if (x2 - x1 > 0) {
				for (long i = x1 + 1; i < x2; i++) {
					if (y2 - y1 > 0) {
						for (long j = y1 + 1; j < y2; j++) {
							if ((double) (j - y1) / (i - x1) == slope)
								rockscount++;
						}
					} else {
						for (long j = y2 + 1; j < y1; j++) {
							if ((double) (j - y1) / (i - x1) == slope)
								rockscount++;
						}
					}

				}
			} else if (x1 - x2 > 0) {
				for (long i = x2 + 1; i < x1; i++) {
					if (y2 - y1 > 0) {
						for (long j = y1 + 1; j < y2; j++) {
							if ((double) (j - y1) / (i - x1) == slope)
								rockscount++;
						}
					} else {
						for (long j = y2 + 1; j < y1; j++) {
							if ((double) (j - y1) / (i - x1) == slope)
								rockscount++;
						}
					}
				}
			} else {
				if (y1 - y2 > 0)
					rockscount = (y1 - y2) - 1;
				else
					rockscount = (y2 - y1) - 1;
			}
		} else {
			if (x1 - x2 > 0)
				rockscount = (x1 - x2) - 1;
			else
				rockscount = (x2 - x1) - 1;
		}
		return rockscount;

	}

}
