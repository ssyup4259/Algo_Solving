package DFS;

import java.util.Scanner;

public class Ex1952 {
	static int[] month = new int[12];
	static int[] costArr = new int[4];
	static int min;

	static void dfs(int idx, int cost) {
		// 12월 계산 끝나면 최저값 갱신
		if (idx >= 12) {
			if (cost < min)
				min = cost;
			return;
		}
		// 1일 이용권
		dfs(idx + 1, cost + costArr[0] * month[idx]);
		// 1달 이용권
		dfs(idx + 1, cost + costArr[1]);
		// 3달 이용권
		dfs(idx + 3, cost + costArr[2]);
		// 1년 이용권
		dfs(idx + 12, cost + costArr[3]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			for (int i = 0; i < 4; i++) {
				costArr[i] = sc.nextInt();
			}
			for (int i = 0; i < 12; i++) {
				month[i] = sc.nextInt();
			}
			dfs(0, 0);

			System.out.println("#" + tc + " " + min);
		}
	}
}
