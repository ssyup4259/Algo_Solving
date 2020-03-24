package OTHER;

import java.util.Scanner;

public class Main_백준_1978_소수찾기 {
	static boolean check(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num >= 2 && check(num)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
