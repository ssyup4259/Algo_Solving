package SAMSUNG;

import java.util.Scanner;

public class Ex14501 {
	static int N;
	static int[][] map;
	static int result;

	static void solve(int depth, int cost) {
		for (int i = depth; i <= N; i++) {
			// 선택한 날 + 선택할 날의 수행기간 이 퇴사일+1보다 작다면
			// dfs 계속 진행
			if (i + map[0][i] <= N + 1) {
				int nextCost = cost + map[1][i];
				solve(i + map[0][i], nextCost);
			}
		}
		// 끝났을때 최대값 갱신
		if (cost > result) {
			result = cost;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[2][N + 1];
		for (int i = 1; i <= N; i++) {
			map[0][i] = sc.nextInt(); // 기간
			map[1][i] = sc.nextInt(); // 가격
		}
		result = 0;
		solve(1, 0);
		System.out.println(result);
	}

}
