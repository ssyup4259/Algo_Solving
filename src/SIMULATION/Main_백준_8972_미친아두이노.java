package SIMULATION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_백준_8972_미친아두이노 {
	static final int[][] dir = { {}, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { -1, -1 },
			{ -1, 0 }, { -1, 1 }, };
	static int R, C;
	static char[][] map;
	static List<Integer>[][] board;
	static Info jongsu;
	static List<Info> list = new ArrayList<>();

	static class Info {
		int r, c, num;

		public Info(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}

	static int len(int ar, int br, int ac, int bc) {
		return Math.abs(ar - br) + Math.abs(ac - bc);
	}

	static boolean solve(int d) {

		// 1. 종수 이동
		map[jongsu.r][jongsu.c] = '.';
		jongsu.r += dir[d][0];
		jongsu.c += dir[d][1];
		// 2. 종수가 아두이노 쪽으로 이동 끝
		if (map[jongsu.r][jongsu.c] != '.') {
			return false;
		}
		map[jongsu.r][jongsu.c] = 'I';

		// 3. 아두이노 이동
		for (int i = 0; i < list.size(); i++) {
			Info now = list.get(i);
			if (now.r == -1 && now.c == -1) {
				continue;
			}
			int flag = 0;
			int min = 1000;
			board[now.r][now.c].remove(Integer.valueOf(i));
			map[now.r][now.c] = '.';
			for (int j = 1; j < 10; j++) {
				int nextR = now.r + dir[j][0];
				int nextC = now.c + dir[j][1];
				int len = len(jongsu.r, nextR, jongsu.c, nextC);
				if (min > len) {
					min = len;
					flag = j;
				}
			}
			now.r += dir[flag][0];
			now.c += dir[flag][1];
			// 4. 아두이노가 종수 쪽으로 이동하면 끝
			if (map[now.r][now.c] == 'I') {
				return false;
			}
			map[now.r][now.c] = 'R';
			board[now.r][now.c].add(i);
		}

		// 5. 두개 이상 아두이노 모이면 사라짐
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j].size() == 0) {
					if (map[i][j] != 'I') {
						map[i][j] = '.';
					}
				} else if (board[i][j].size() >= 2) {
					for (int k = 0; k < board[i][j].size(); k++) {
						Info now = list.get(Integer.valueOf(board[i][j].get(k)));
						// 이거 왜 null 로 안바뀌지
						// now =null;
						now.r = -1;
						now.c = -1;
					}
					board[i][j].clear();
					if (map[i][j] != 'I') {
						map[i][j] = '.';
					}
				} else {
					map[i][j] = 'R';
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		board = new ArrayList[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				board[i][j] = new ArrayList<>();
			}
		}

		int num = 0;
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') {
					jongsu = new Info(i, j, -1);
				} else if (map[i][j] == 'R') {
					list.add(new Info(i, j, num));
					board[i][j].add(num);
					num++;
				}
			}
		}

		String dirOrder = sc.next();
		for (int i = 0; i < dirOrder.length(); i++) {
			int d = Integer.parseInt(dirOrder.substring(i, i + 1));
			boolean flag = solve(d);
			if (!flag) {
				System.out.println("kraj " + (i + 1));
				return;
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
