package SIMULATION;
import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_17822_원판돌리기 {
	static int N, M, T;
	static int[][] map;

	static void move(int x, int d) {
		for (int i = 0; i < N; i++) {
			if ((i + 1) % x == 0) {
				if (d == 0) {
					int temp = map[i][M - 1];
					for (int j = M - 1; j >= 1; j--) {
						map[i][j] = map[i][j - 1];
					}
					map[i][0] = temp;
				} else if (d == 1) {
					int temp = map[i][0];
					for (int j = 0; j < M - 1; j++) {
						map[i][j] = map[i][j + 1];
					}
					map[i][M - 1] = temp;
				}
			}
		}
	}

	static void deleteAdj(int x) {
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == Integer.MIN_VALUE) {
					continue;
				}
				if (map[i][j] == map[i][(j + 1) % M]) {
					newMap[i][j] = Integer.MIN_VALUE;
					newMap[i][(j + 1) % M] = Integer.MIN_VALUE;
					flag = false;
				}
				if (map[i][j] == map[i][(j + M - 1) % M]) {
					newMap[i][j] = Integer.MIN_VALUE;
					newMap[i][(j + M - 1) % M] = Integer.MIN_VALUE;
					flag = false;
				}
				if (i != N - 1 && map[i][j] == map[(i + 1)][j]) {
					newMap[i][j] = Integer.MIN_VALUE;
					newMap[(i + 1)][j] = Integer.MIN_VALUE;
					flag = false;
				}
				if (i != 0 && map[i][j] == map[(i - 1)][j]) {
					newMap[i][j] = Integer.MIN_VALUE;
					newMap[(i - 1)][j] = Integer.MIN_VALUE;
					flag = false;
				}
			}

		}

		if (flag) {
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != Integer.MIN_VALUE) {
						sum += map[i][j];
						cnt++;
					}
				}
			}
			double avg = sum / (double) cnt;
			// System.out.println(sum + " " + cnt + " " + avg);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != Integer.MIN_VALUE) {
						if (map[i][j] > avg) {
							map[i][j]--;
						} else if (map[i][j] < avg) {
							map[i][j]++;
						}
					}
				}
			}
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = newMap[i][j];
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < T; i++) {
			int x = sc.nextInt(); // x의 배수 원판 모두 회전
			int d = sc.nextInt(); // 0시계->, 1반시계 <-
			int k = sc.nextInt();
			for (int j = 0; j < k; j++) {
				move(x, d);
			}
			// for (int j = 0; j < N; j++) {
			// System.out.println(Arrays.toString(map[j]));
			// }
			deleteAdj(x);
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			// System.out.println(Arrays.toString(map[i]));
			for (int j = 0; j < M; j++) {
				if (map[i][j] != Integer.MIN_VALUE) {
					sum += map[i][j];
				}
			}
		}
		System.out.println(sum);

	}

}
