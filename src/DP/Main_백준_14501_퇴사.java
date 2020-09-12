package DP;

import java.util.Scanner;

public class Main_백준_14501_퇴사 {
	static int N;
	static int[][] map;
	static int result;

	static void solve(int depth, int cost) {
		for (int i = depth; i <= N; i++) {
			if (i + map[0][i] <= N + 1) {
				int nextCost = cost + map[1][i];
				solve(i + map[0][i], nextCost);
			}
		}
		if (cost > result) {
			result = cost;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[2][N + 1];
		for (int i = 1; i <= N; i++) {
			map[0][i] = sc.nextInt();
			map[1][i] = sc.nextInt();
		}
		result = 0;
		solve(1, 0);
		System.out.println(result);
	}

}