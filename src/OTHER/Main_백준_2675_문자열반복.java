package OTHER;

import java.util.Scanner;

public class Main_백준_2675_문자열반복 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int R = sc.nextInt();
			String S = sc.next();
			String result = "";
			for (int i = 0; i < S.length(); i++) {
				for (int j = 0; j < R; j++) {
					result += S.substring(i, i + 1);
				}
			}
			System.out.println(result);
		}
	}

}
