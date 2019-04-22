import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex4179 {

	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Info ji; // 지훈이 정보
	static Queue<Info> fQue = new LinkedList<>(); // 불 넣는 큐

	static class Info {
		int r, c;

		public Info(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C) {
			return false;
		}
		return true;
	}

	private static void solve() {
		int time = 0;
		fQue.add(ji);
		visit[ji.r][ji.c] = true;

		while (!fQue.isEmpty()) {
			int queSize = fQue.size();

			for (int i = 0; i < queSize; i++) {
				Info fire = fQue.poll();
				if ((fire.r == 0 || fire.r == R - 1 || fire.c == 0 || fire.c == C - 1) && map[fire.r][fire.c] == '.') {
					System.out.println(time + 1);
					return;
				}

				for (int j = 0; j < 4; j++) {
					int nextR = fire.r + dir[j][0];
					int nextC = fire.c + dir[j][1];

					if (isRange(nextR, nextC)) {
						if (!visit[nextR][nextC] && map[nextR][nextC] == '.') {
							if (map[fire.r][fire.c] == 'F') {
								visit[nextR][nextC] = true;
								map[nextR][nextC] = 'F';
								fQue.add(new Info(nextR, nextC));
							} else if (map[fire.r][fire.c] == '.') {
								visit[nextR][nextC] = true;
								fQue.add(new Info(nextR, nextC));
							}
						}
					}
				}
			}
			time++;
		}
		System.out.println("IMPOSSIBLE");
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		map = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'F') {
					fQue.add(new Info(i, j));
				} else if (map[i][j] == 'J') {
					ji = new Info(i, j);
					map[i][j] = '.';
				}
			}
		}
		solve();
	}

}
