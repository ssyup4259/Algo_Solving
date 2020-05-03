package SIMULATION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_백준_17837_새로운게임2 {
	static final int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static int N, K, map[][];
	static List<Integer>[][] board;

	static List<Info> list = new ArrayList<>();

	static class Info {
		int num, r, c, h, d;

		public Info(int num, int r, int c, int h, int d) {
			this.num = num;
			this.r = r;
			this.c = c;
			this.h = h;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Info [num=" + num + ", r=" + r + ", c=" + c + ", h=" + h + ", d=" + d + "]";
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N || map[r][c] == 2) {
			return false;
		}
		return true;
	}

	static int switchDir(int d) {
		int res = 0;
		if (d == 0) {
			res = 1;
		} else if (d == 1) {
			res = 0;
		} else if (d == 2) {
			res = 3;
		} else {
			res = 2;
		}
		return res;
	}

	static int solve() {
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			Info info = list.get(i);
			int nextR = info.r + dir[info.d][0];
			int nextC = info.c + dir[info.d][1];

			boolean flag = true;
			// 옮기려는 말들 중 제일 아래층만 위치가 지정되면 된다.
			if (!isRange(nextR, nextC)) { // 범위를 넘어가거나 파란색일 경우
				info.d = switchDir(info.d);
				nextR = info.r + dir[info.d][0];
				nextC = info.c + dir[info.d][1];
				if (!isRange(nextR, nextC)) {
					nextR = info.r;
					nextC = info.c;
					flag = false;
				}
			}

			// 흰색 칸과 빨간색 칸은 말의 위치, 방향은 그대로
			if (flag) { // 제자리가 아닌 애들
				int h = info.h;
				List<Integer> order = new ArrayList<>();
				for (int j = h; j < board[info.r][info.c].size(); j++) { // 현재 말보다 위에 층에 있는애들 넣기
					order.add(board[info.r][info.c].get(j));
					board[info.r][info.c].remove(j);
					j--;
				}
				if (map[nextR][nextC] == 0) {
					for (int j = 0; j < order.size(); j++) {
						Info now = list.get(order.get(j));
						now.r = nextR;
						now.c = nextC;
						now.h = board[nextR][nextC].size();
						board[nextR][nextC].add(now.num);
					}
				} else if (map[nextR][nextC] == 1) {
					for (int j = order.size() - 1; j >= 0; j--) {
						Info now = list.get(order.get(j));
						now.r = nextR;
						now.c = nextC;
						now.h = board[nextR][nextC].size();
						board[nextR][nextC].add(now.num);
					}
				}
				if (board[nextR][nextC].size() >= 4) {
					result = 1;
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		board = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				// 1 빨간색 위아래 순서 바꿈, //2 파란색 방향 반대 한칸이동
				board[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < K; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			int d = sc.nextInt() - 1;
			int h = board[r][c].size();
			board[r][c].add(i);
			list.add(new Info(i, r, c, h, d));
		}

		int cnt = 0;
		while (cnt <= 1000) {
			cnt++;
			if (solve() == 1) {
				break;
			}
		}
		if (cnt > 1000) {
			cnt = -1;
		}
		System.out.println(cnt);
	}

}
