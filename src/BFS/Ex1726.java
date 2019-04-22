package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class InfoEx1726 {
	int r;
	int c;
	int dir;
	int cnt;

	public InfoEx1726(int r, int c, int dir, int cnt) {
		this.r = r;
		this.c = c;
		this.dir = dir;
		this.cnt = cnt;
	}
}

public class Ex1726 {
	// 상 우 하 좌
	static int[][] dir = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, -0 } };
	static int N, M;
	static int[][] map;
	static boolean[][][] visit;
	static List<InfoEx1726> list;
	static InfoEx1726 start, end;

	static boolean isRange(int r, int c) {
		if (r < 1 || r > N || c < 1 || c > M) {
			return false;
		}
		return true;
	}

	static void bfs(int r, int c, int d) {
		Queue<InfoEx1726> que = new LinkedList<>();
		que.add(new InfoEx1726(r, c, d, 0));

		while (!que.isEmpty()) {
			int nextR = que.peek().r;
			int nextC = que.peek().c;
			int nextD = que.peek().dir;
			int cnt = que.poll().cnt;
			System.out.println(nextR + " " + nextC + " " + nextD + " " + cnt);
			if (r == end.r && c == end.c && d == end.dir) {
				System.out.println("종료");
				return;
			}

			for (int i = 1; i <= 5; i++) {
				if (i == 4) { // i==4 좌회전, i==5 우회전
					nextR = r;
					nextC = c;
					if (d == 1) {
						nextD = 4;
					} else if (d == 2) {
						nextD = 3;
					} else if (d == 3) {
						nextD = 1;
					} else if (d == 4) {
						nextD = 2;
					}
				} else if (i == 5) {
					nextR = r;
					nextC = c;
					if (d == 1) {
						nextD = 3;
					} else if (d == 2) {
						nextD = 4;
					} else if (d == 3) {
						nextD = 2;
					} else if (d == 4) {
						nextD = 1;
					}
				} else {
					nextR = nextR + dir[d][0] * i;
					nextC = nextC + dir[d][1] * i;
					nextD = d;
				}

				if ((i == 4 || i == 5) && !isRange(nextR, nextC)) {
					i = i - 1;
				} else {
					if (visit[nextR][nextC][nextD] == true) {
						continue;
					}
				}
				visit[nextR][nextC][nextD] = true;
				que.add(new InfoEx1726(nextR, nextC, nextD, cnt + 1));
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1][4];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		start.r = sc.nextInt();
		start.c = sc.nextInt();
		start.dir = sc.nextInt();
		end.r = sc.nextInt();
		end.c = sc.nextInt();
		end.dir = sc.nextInt();
		visit[start.r][start.c][start.dir] = true;
		bfs(start.r, start.c, start.dir);
	}

}
