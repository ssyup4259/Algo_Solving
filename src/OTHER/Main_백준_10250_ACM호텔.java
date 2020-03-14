package OTHER;

import java.util.Scanner;

public class Main_백준_10250_ACM호텔 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();

			int w = (N - 1) / H;
			int h = (N - 1) % H;
			int result = (h + 1) * 100 + w + 1;
			System.out.println(result);
		}
	}

}
