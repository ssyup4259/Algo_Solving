import java.util.Scanner;

public class Main_백준_1107_리모컨 {
	static int N, toBin, min;

	static boolean check(int num) {
		if (num == 0) {
			if ((toBin & 1 << num) != 0) {
				return false;
			}
		} else {
			while (num != 0) {
				int a = num % 10;
				num = num / 10;
				if ((toBin & 1 << a) != 0) {
					return false;
				}
			}
		}
		return true;
	}

	static void solve() {
		int plusMinus = 0;
		while (true) {
			if (plusMinus > min) {
				break;
			}
			boolean flag = false;
			if (N - plusMinus >= 0) {
				if (check(N - plusMinus)) {
					int len = plusMinus + Integer.toString(N - plusMinus).length();
					min = Math.min(min, len);
					flag = true;
				}
			}
			if (check(N + plusMinus)) {
				int len = plusMinus + Integer.toString(N + plusMinus).length();
				min = Math.min(min, len);
				flag = true;
			}
			plusMinus++;
			if (flag) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		toBin = 0;
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			toBin = toBin | 1 << num;
		}

		if (N == 100) {
			System.out.println(0);
		} else {
			min = Math.abs(N - 100);
			solve();
			System.out.println(min);
		}
	}

}
