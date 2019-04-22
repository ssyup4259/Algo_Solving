package OTHER;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex4485 {
	static int N;
	static int[][] map, dist;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	
	//좌표 가중치
	static class Info {
		int r, c, w;

		Info(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}

	static void solve() {
		Queue<Info> que = new LinkedList<>();
		//시작은 왼쪽 위
		dist[0][0] = map[0][0];
		que.add(new Info(0, 0, map[0][0]));
		
		while (!que.isEmpty()) {
			int r = que.peek().r;
			int c = que.peek().c;
			int w = que.poll().w;
			for (int i = 0; i < 4; i++) {
				int nextR = r + dir[i][0];
				int nextC = c + dir[i][1];

				if (isRange(nextR, nextC)) {
					//r,c 좌표를 거쳐 nextR,nextC 를 가는 값이 dist 보다 작다면 갱신
					if (dist[nextR][nextC] > dist[r][c] + map[nextR][nextC]) {
						dist[nextR][nextC] = dist[r][c] + map[nextR][nextC];
						que.add(new Info(nextR, nextC, dist[nextR][nextC]));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		while (true) {
			N = sc.nextInt();
			if (N == 0) {
				break;
			}
			map = new int[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			tc++;
			solve();
			System.out.println("Problem " + tc + ": " + dist[N - 1][N - 1]);
		}
	}

}
