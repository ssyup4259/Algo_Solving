package OTHER;

import java.util.Scanner;

public class Main_백준_8958_OX퀴즈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int cnt = 0;
			int sum = 0;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == 'O') {
					cnt++;
					sum += cnt;
				} else {
					cnt = 0;
				}
			}
			System.out.println(sum);
		}

	}

}
