package SIMULATION;

import java.util.Scanner;

public class Main_백준_15685_드래곤커브 {
	static int[][] dir = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	static int[] nOrder;
	static int[][] visit;
	
	// 이전 세대를 기반으로 새로운 세대의 방향들을 배열에 넣어 놓는다.
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

		visit = new int[300][300];
		for (int i = 0; i < n; i++) {
			nOrder = null;
			int[] start = { arr[i][2] };
			int gen = arr[i][3];
			if (gen == 0) {
				int r = arr[i][1] + 100;
				int c = arr[i][0] + 100;
				visit[r][c] = 1;
				visit[r + dir[arr[i][2]][0]][c + dir[arr[i][2]][1]] = 1;
			} else {
				curve(start, gen, 0);
				int r = arr[i][1] + 100;
				int c = arr[i][0] + 100;
				visit[r][c] = 1;
				solve(nOrder, r, c, 0);
			}
		}
		
		// 사방이 둘러쌓인곳 조사
		int cnt = 0;
		for (int i = 0; i < 300; i++) {
			for (int j = 0; j < 300; j++) {
				if (visit[i][j] == 1 && visit[i + 1][j + 1] == 1 && visit[i][j + 1] == 1 && visit[i + 1][j] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);

	}

}
