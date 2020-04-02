package OTHER;

import java.util.Scanner;

public class Main_백준_1074_Z {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int len = 1;
		for (int i = 0; i < N; i++) {
			len *= 2;
		}
		int result = 0;
		while (true) {
			len = len / 2;
			if (r >= len && c >= len) { // 4사분면
				result += (len * len) * 3;
				r = r - len;
				c = c - len;
			} else if (r >= len && c < len) { // 3사분면
				result += (len * len) * 2;
				r = r - len;
			} else if (r < len && c >= len) { // 2사분면
				result += (len * len);
				c = c - len;
			}
			if (len == 1) {
				break;
			}
		}
		System.out.println(result);
	}

}
