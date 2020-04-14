package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_9328_열쇠 {
	static final int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int h, w, key, max;
	static char[][] map;
	static boolean[][] visit;
	static HashMap<Integer, List<Info>> hm;

	static class Info {
		int r, c;

		public Info(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= h + 2 || c < 0 || c >= w + 2) {
			return false;
		}
		return true;
	}

	static void solve(int r, int c) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(r, c));
		while (!que.isEmpty()) {
			Info now = que.poll();
			for (int d = 0; d < 4; d++) {
				int nextR = now.r + dir[d][0];
				int nextC = now.c + dir[d][1];

				if (isRange(nextR, nextC) && !visit[nextR][nextC]) {
					if (map[nextR][nextC] == '.') {
						visit[nextR][nextC] = true;
						que.add(new Info(nextR, nextC));
					} else if ('A' <= map[nextR][nextC] && map[nextR][nextC] <= 'Z') {
						// System.out.println("문 만남");
						if ((key & (1 << map[nextR][nextC] - 'A')) >= 1) {
							// System.out.println(map[nextR][nextC] + " 열쇠 있음");
							visit[nextR][nextC] = true;
							que.add(new Info(nextR, nextC));
						} else {
							List<Info> list = hm.get(map[nextR][nextC] - 'A');
							if (list == null) {
								list = new ArrayList<>();
							}
							list.add(new Info(nextR, nextC));
							hm.put(map[nextR][nextC] - 'A', list);
						}
					} else if ('a' <= map[nextR][nextC] && map[nextR][nextC] <= 'z') {
						// System.out.println("열쇠 만남");
						if ((key & (1 << map[nextR][nextC] - 'a')) == 0) {
							key = key + (1 << map[nextR][nextC] - 'a');
							List<Info> list = hm.get(map[nextR][nextC] - 'a');
							// System.out.println(map[nextR][nextC] + "의 문 리스트");
							if (list != null) {
								for (int i = 0; i < list.size(); i++) {
									Info next = list.get(i);
									que.add(next);
								}
							}
						}
						visit[nextR][nextC] = true;
						que.add(new Info(nextR, nextC));
					} else if (map[nextR][nextC] == '$') {
						// System.out.println("문서 만남");
						max++;
						visit[nextR][nextC] = true;
						que.add(new Info(nextR, nextC));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			h = sc.nextInt();
			w = sc.nextInt();
			map = new char[h + 2][w + 2];
			hm = new HashMap<>();
			for (int i = 0; i < h + 2; i++) {
				for (int j = 0; j < w + 2; j++) {
					map[i][j] = '.';
				}
			}
			for (int i = 1; i <= h; i++) {
				String str = sc.next();
				for (int j = 1; j <= w; j++) {
					map[i][j] = str.charAt(j - 1);
				}
			}
			
			String str = sc.next();
			key = 0;
			if (!str.equals("0")) {
				for (int i = 0; i < str.length(); i++) {
					char c = str.charAt(i);
					key += (1 << c - 'a');
				}
			}

			max = 0;
			visit = new boolean[h + 2][w + 2];
			solve(0, 0);
			System.out.println(max);
		}
	}

}
