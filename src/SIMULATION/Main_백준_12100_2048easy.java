package SIMULATION;

import java.util.Scanner;

public class Main_백준_12100_2048easy {
	static int N;
	static int[][] map;
	// 상 우 하 좌
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int result;

	static void dfs(int depth) {
		if (depth == 5) {
			int max = 0;
			// 현재 블록들 중에서 최대값을 찾는다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max < map[i][j]) {
						max = map[i][j];
					}
				}
			}
			if (result < max) {
				result = max;
			}
			return;
		}
		
		//4방향에 대해서 dfs
		for (int d = 0; d < 4; d++) {
			int[][] temp = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp[i][j] = map[i][j];
				}
			}
			solve(d);
			dfs(depth + 1);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[i][j];
				}
			}
		}
	}

	static void solve(int d) {
		if (d == 1) {
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				int flag = 0;
				for (int j = N - 1; j >= 0; j--) {
					// 0의 갯수만큼 자리를 이동해야한다.
					if (map[i][j] == 0) {
						cnt++;
					} else {
						if (flag == map[i][j]) {
							map[i][j + cnt + 1] = map[i][j] + map[i][j];
							map[i][j] = 0;
							flag = 0;
							cnt++;
						} else {
							map[i][j + cnt] = map[i][j];
							flag = map[i][j];
							if (cnt != 0) {
								map[i][j] = 0;
							}
						}
					}
				}
			}
		} else if (d == 3) {
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				int flag = 0;
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						cnt++;
					} else {
						if (flag == map[i][j]) {
							map[i][j - cnt - 1] = map[i][j] + map[i][j];
							map[i][j] = 0;
							flag = 0;
							cnt++;
						} else {
							map[i][j - cnt] = map[i][j];
							flag = map[i][j];
							if (cnt != 0) {
								map[i][j] = 0;
							}
						}
					}
				}
			}
		} else if (d == 0) {
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				int flag = 0;
				for (int j = 0; j < N; j++) {
					if (map[j][i] == 0) {
						cnt++;
					} else {
						if (flag == map[j][i]) {
							map[j - cnt - 1][i] = map[j][i] + map[j][i];
							map[j][i] = 0;
							flag = 0;
							cnt++;
						} else {
							map[j - cnt][i] = map[j][i];
							flag = map[j][i];
							if (cnt != 0) {
								map[j][i] = 0;
							}
						}
					}
				}
			}
		} else if (d == 2) {
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				int flag = 0;
				for (int j = N - 1; j >= 0; j--) {
					if (map[j][i] == 0) {
						cnt++;
					} else {
						if (flag == map[j][i]) {
							map[j + cnt + 1][i] = map[j][i] + map[j][i];
							map[j][i] = 0;
							flag = 0;
							cnt++;
						} else {
							map[j + cnt][i] = map[j][i];
							flag = map[j][i];
							if (cnt != 0) {
								map[j][i] = 0;
							}
						}
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		result = 0;
		dfs(0);
		System.out.println(result);
	}

}
