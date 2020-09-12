package SIMULATION;

import java.util.Scanner;

public class Main_백준_14499_주사위굴리기 {
	static int N, M, x, y, K;
	static int[][] map;
	static int[] order;
	// 1. 동, 2. 서, 3. 북, 4. 남
	static int[][] dir = { {}, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	// 미리 주사위를 2차원 배열로 매핑
	// 문제에 주어진 형태로
	static int[][] dice = new int[4][3];

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return false;
		}
		return true;
	}

	static void rotate(int d) {
		// dice[3][1] : 바닥, dice[1][1] : 윗면
		if (d == 1) { // 동쪽으로 굴릴때
			int temp = dice[1][0];
			dice[1][0] = dice[3][1];
			dice[3][1] = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = temp;
		} else if (d == 2) { // 서쪽으로 굴릴때
			int temp = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = dice[3][1];
			dice[3][1] = temp;
		} else if (d == 3) { // 북
			int temp = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = temp;
		} else if (d == 4) {// 남
			int temp = dice[0][1];
			dice[0][1] = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = temp;
		}
	}

	static void solve(int d) {
		int nextX = x + dir[d][0];
		int nextY = y + dir[d][1];
		// 명령 수행이 범위를 벗어나면 명령 무시
		if (!isRange(nextX, nextY)) {
			return;
		} else {
			// 굴리고 문제처리 후 윗면 출력
			rotate(d);
			x = nextX;
			y = nextY;
			if (map[x][y] == 0) {
				map[x][y] = dice[3][1];
			} else {
				dice[3][1] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[1][1]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < K; i++) {
			int d = sc.nextInt();
			solve(d);
		}
	}

}
