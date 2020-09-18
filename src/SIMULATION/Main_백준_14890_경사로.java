package SIMULATION;

import java.util.Scanner;

public class Main_백준_14890_경사로{
	static int N, L;
	static int[][] map;
	static int xCnt;

	static void solveRight(int r, int c) {
		int cnt = 1;
		for (int i = 0; i < N - 1; i++) {
			if (map[r][c + i + 1] == map[r][c + i]) {
				cnt++;
			} else if (map[r][c + i + 1] > map[r][c + i] + 1) {
				xCnt++;
				return;
			} else if (map[r][c + i + 1] < map[r][c + i] - 1) {
				xCnt++;
				return;
			// 지금 보다 층고가 높아졌을때
			} else if (map[r][c + i + 1] == map[r][c + i] + 1) {
				// 지금가지 같은 높이였던 갯수가 경사로의 길이 L 보다 크다면 경사로 놓을 수 있다.
				if (cnt >= L) {
					cnt = 1;
				} else {
					xCnt++;
					return;
				}
			// 지금 보다 층고가 낮아졌을때	
			} else if (map[r][c + i + 1] == map[r][c + i] - 1) {
				int flag = 1;
				// 층고가 낮아진 순간 부터 같은 층고의 갯수를 센다.
				for (int j = 1; j < N - (c + i + 1); j++) {
					if (map[r][c + i + 1 + j] == map[r][c + i + 1]) {
						flag++;
					} else {
						break;
					}
				}
				// 같은 층고의 갯수가 경사로의 길이 L보다 크다면 된다.
				if (flag >= L) {
					i = i + L - 1;
					cnt = 0;
				} else {
					xCnt++;
					return;
				}
			}
		}
	}

	static void solveDown(int r, int c) {
		int cnt = 1;
		for (int i = 0; i < N - 1; i++) {
			if (map[r + i + 1][c] == map[r + i][c]) {
				cnt++;
			} else if (map[r + i + 1][c] > map[r + i][c] + 1) {
				xCnt++;
				return;
			} else if (map[r + i + 1][c] < map[r + i][c] - 1) {
				xCnt++;
				return;
			} else if (map[r + i + 1][c] == map[r + i][c] + 1) {
				if (cnt >= L) {
					cnt = 1;
				} else {
					xCnt++;
					return;
				}
			} else if (map[r + i + 1][c] == map[r + i][c] - 1) {
				int flag = 1;
				for (int j = 1; j < N - (r + i + 1); j++) {
					if (map[r + i + 1 + j][c] == map[r + i + 1][c]) {
						flag++;
					} else {
						break;
					}
				}
				if (flag >= L) {
					i = i + L - 1;
					cnt = 0;
				} else {
					xCnt++;
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			solveRight(i, 0);
			solveDown(0, i);
		}
		System.out.println(N * 2 - xCnt);
	}

}
