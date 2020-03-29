package OTHER;

import java.util.Scanner;

public class Main_백준_17626_FourSquares {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int len = (int) Math.sqrt(N) + 1;
		int[] arr = new int[len];
		int[] dp = new int[N + 1];
		for (int i = 1; i < len; i++) {
			arr[i] = i * i;
		}
		for (int i = 1; i <= N; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		dp[0] = 0;
		for (int i = 1; i < len; i++) {
			for (int j = arr[i]; j <= N; j++) {
				dp[j] = Math.min(dp[j - arr[i]] + 1, dp[j]);
			}
		}
		System.out.println(dp[N]);
	}

}
