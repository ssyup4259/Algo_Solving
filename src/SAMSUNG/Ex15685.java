package SAMSUNG;

import java.util.Scanner;

public class Ex15685 {
	// 문제에 주어진 방향
	static int[][] dir = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	// 드래곤 커브 순서
	static int[] nOrder;
	// 꼭지점 체크
	static int[][] visit;

	// 드래곤 커브 순서 구하기
	static void curve(int[] order, int gen, int cnt) {
		if (gen == cnt) {
			return;
		} else {
			int len = order.length;
			nOrder = new int[len * 2];
			for (int i = 0; i < len; i++) {
				nOrder[i] = order[i];
				nOrder[i + len] = (order[len - 1 - i] + 1) % 4;
			}
			curve(nOrder, gen, cnt + 1);
		}
	}

	// 드래곤 커브 순서대로 방문 체크
	static void solve(int[] order, int r, int c, int n) {
		if (n == order.length) {
			return;
		}
		int nextR = r + dir[order[n]][0];
		int nextC = c + dir[order[n]][1];
		visit[nextR][nextC] = 1;
		solve(order, nextR, nextC, n + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][4];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// 한세대당 상하좌우로 커져봐야 한개씩 열세대라면 좌우로 20씩 커진다
		visit = new int[300][300];
		for (int i = 0; i < n; i++) {
			nOrder = null;
			// 드래콘커브 첫 시작은 배열의 세번째
			int[] start = { arr[i][2] };
			// 최종적으로 구하려는 세대
			int gen = arr[i][3];
			if (gen == 0) { // 0세대라면 바로 구할 수 있다.
				int r = arr[i][1] + 100; // 좌표의 시작값
				int c = arr[i][0] + 100;
				visit[r][c] = 1; // 0세대는 한줄 이니깐 2개의 꼭지점
				visit[r + dir[arr[i][2]][0]][c + dir[arr[i][2]][1]] = 1;
			} else {
				// 커브 순서 구하고
				curve(start, gen, 0);
				int r = arr[i][1] + 100;
				int c = arr[i][0] + 100;
				// 첫 시작 체크하고
				visit[r][c] = 1;
				solve(nOrder, r, c, 0);
			}
		}
		int cnt = 0;
		for (int i = 0; i < 300; i++) {
			for (int j = 0; j < 300; j++) {
				// 4꼭지점에 체크되어있다면 원하는 답
				if (visit[i][j] == 1 && visit[i + 1][j + 1] == 1 && visit[i][j + 1] == 1 && visit[i + 1][j] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);

	}

}
