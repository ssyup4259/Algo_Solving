package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_1149_RGB거리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int[][] memo = new int[N][3];
		memo[0][0] = arr[0][0];
		memo[0][1] = arr[0][1];
		memo[0][2] = arr[0][2];
		for (int i = 1; i < N; i++) {
			memo[i][0] = (memo[i - 1][1] < memo[i - 1][2] ? memo[i - 1][1] : memo[i - 1][2]) + arr[i][0];
			memo[i][1] = (memo[i - 1][0] < memo[i - 1][2] ? memo[i - 1][0] : memo[i - 1][2]) + arr[i][1];
			memo[i][2] = (memo[i - 1][0] < memo[i - 1][1] ? memo[i - 1][0] : memo[i - 1][1]) + arr[i][2];
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (min > memo[N - 1][i]) {
				min = memo[N - 1][i];
			}
		}
		System.out.println(min);
	}

}
