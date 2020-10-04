package DFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_16234_인구이동 {
	static final int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static int N, L, R, map[][];
	static boolean[][] visit;
	static List<Info> list;
	static int result = 0;

	static class Info {
		int r, c, cnt;

		public Info(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}

	static void dfs(int r, int c, int cnt) {
		list.add(new Info(r, c, cnt));
		visit[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nextR = r + dir[d][0];
			int nextC = c + dir[d][1];

			if (isRange(nextR, nextC) && !visit[nextR][nextC]) {
				int dif = Math.abs(map[nextR][nextC] - map[r][c]);
				if (dif >= L && dif <= R && dif != 0) {
					dfs(nextR, nextC, cnt);
				}
			}
		}

	}

	static void solve() {
		while (true) {
			List<Info> resList = new ArrayList<>();
			int cnt = 0;
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						list = new ArrayList<>();
						// 인접한 국가 인구 차이 알아보기 위해
						dfs(i, j, cnt);
						if (list.size() > 1) {
							for (int k = 0; k < list.size(); k++) {
								resList.add(list.get(k));
							}
						}
						cnt++;
					}
				}
			}
			
			// 연합이 없다.
			if (resList.isEmpty()) {
				break;
			}
			
			// 연합이 생긴것이니 인구이도 횟수를 늘려주고
			// 조건에 맞는 인구수를 다시 구하여 지도에 표기 해야한다.
			result++;
			while (!resList.isEmpty()) {
				int sum = 0;
				int c = 0;
				int flag = resList.get(0).cnt;
				// 연합들의 인구수를 조건에 맞게 구한다.
				for (int i = 0; i < resList.size(); i++) {
					if (resList.get(i).cnt == flag) {
						Info info = resList.get(i);
						sum += map[info.r][info.c];
						c++;
					} else {
						break;
					}
				}
				int avg = sum / c;
				for (int i = 0; i < c; i++) {
					Info info = resList.get(0);
					map[info.r][info.c] = avg;
					resList.remove(0);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		solve();
		System.out.println(result);

	}

}