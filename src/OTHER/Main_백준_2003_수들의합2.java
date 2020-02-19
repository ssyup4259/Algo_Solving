package OTHER;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_2003_수들의합2 {

	static int N, M;
	static int[] arr;
	static int cnt;

	static void solve(int start) {
		if (start == N + 1) {
			System.out.println(cnt);
			return;
		}
		int sum = 0;
		for (int i = start; i <= N; i++) {
			sum = sum + arr[i];
			if (sum > M) {
				break;
			}
			if (sum == M) {
				cnt++;
				break;
			}
		}
		solve(start + 1);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		cnt = 0;
		solve(1);
	}
}
