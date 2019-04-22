package SAMSUNG;

import java.util.Scanner;

public class Ex14890 {
	static int N, L;
	static int[][] map;
	static int xCnt; // 경로를 만들 수 없는 갯수

	// 행으로 탐색
	static void solveRight(int r, int c) {
		int cnt = 1; // 지금 칸과 높이 같은 것 찾는 변수
		for (int i = 0; i < N - 1; i++) {
			// 다음칸이 지금칸과 같으면 cnt증가
			if (map[r][c + i + 1] == map[r][c + i]) {
				cnt++;
				// 다음칸이 지금 칸보다 2이상 크다면 경로 안되고 메소드 종료
			} else if (map[r][c + i + 1] > map[r][c + i] + 1) {
				xCnt++;
				return;
				// 다음칸이 지금 칸보다 2이상 작다면 경로 안되고 메소드 종료
			} else if (map[r][c + i + 1] < map[r][c + i] - 1) {
				xCnt++;
				return;
				// 다음 칸이 지금 칸 보다 1 크다면
			} else if (map[r][c + i + 1] == map[r][c + i] + 1) {
				// cnt가 경사로 길이보다 길다면 cnt =1 만들어준다
				if (cnt >= L) {
					cnt = 1;
					// cnt가 작다면 경로 안되고 메소드종료
				} else {
					xCnt++;
					return;
				}
				// 다음칸이 지금 칸보다 1작다면
			} else if (map[r][c + i + 1] == map[r][c + i] - 1) {
				int flag = 1; // 다음 칸 부터 높이같은거 세는 변수
				for (int j = 1; j < N - (c + i + 1); j++) {
					if (map[r][c + i + 1 + j] == map[r][c + i + 1]) {
						flag++;
					} else {
						break;
					}
				}
				// 다음 칸부터 같은 높이가 경사로 길이보다 길다면
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
