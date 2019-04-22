package SAMSUNG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex13460 {
	static int N, M;
	static char[][] map;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static class Info {
		int rR, cR, rB, cB; // 빨간공 파랑공 좌표
		int cnt; // 기울인 수

		Info(int rR, int cR, int rB, int cB, int cnt) {
			this.rR = rR;
			this.cR = cR;
			this.rB = rB;
			this.cB = cB;
			this.cnt = cnt;
		}
	}

	static void bfs(int rR, int cR, int rB, int cB) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(rR, cR, rB, cB, 0));

		while (!que.isEmpty()) {
			rR = que.peek().rR;
			cR = que.peek().cR;
			rB = que.peek().rB;
			cB = que.peek().cB;
			int cnt = que.poll().cnt;

			if (cnt > 10) { // 10번 이하로 답이 안나온다면 -1 출력
				System.out.println(-1);
				return;
			}

			// 빨간공이 구멍에 있는데 파란공은 구멍에 없을때 답 출력
			if (map[rR][cR] == 'O' && (map[rR][cR] != map[rB][cB])) {
				System.out.println(cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextrR = rR;
				int nextcR = cR;
				int nextrB = rB;
				int nextcB = cB;
				// 기울인 방향으로 레드공을 굴린다.
				while (true) {
					// 다음이 벽이면 지금 그만
					if (map[nextrR + dir[i][0]][nextcR + dir[i][1]] == '#') {
						break;
					}
					// 다음이 구멍이면 다음 그만
					if (map[nextrR + dir[i][0]][nextcR + dir[i][1]] == 'O') {
						nextrR = nextrR + dir[i][0];
						nextcR = nextcR + dir[i][1];
						break;
					}
					nextrR = nextrR + dir[i][0];
					nextcR = nextcR + dir[i][1];
				}
				// 빨간공과 마찬가지
				while (true) {
					if (map[nextrB + dir[i][0]][nextcB + dir[i][1]] == '#') {
						break;
					}
					if (map[nextrB + dir[i][0]][nextcB + dir[i][1]] == 'O') {
						nextrB = nextrB + dir[i][0];
						nextcB = nextcB + dir[i][1];
						break;
					}
					nextrB = nextrB + dir[i][0];
					nextcB = nextcB + dir[i][1];
				}

				// 파란공은 구멍에 들어가면 안된다.
				if (map[nextrB][nextcB] == 'O') {
					continue;
				}
				
				// 굴리고나서 빨간공과 파란공이 같은 위치에 있을때
				if (nextrR == nextrB && nextcR == nextcB) {
					// 빨간공과 파란공의 움직인 거리를 비교했을때 거리가 더 짧다면 더 먼저 왓으니 짧은 공을 앞으로
					if (Math.abs(nextrR - rR) + Math.abs(nextcR - cR) < Math.abs(nextrB - rB) + Math.abs(nextcB - cB)) {
						nextrB = nextrB - dir[i][0];
						nextcB = nextcB - dir[i][1];
					} else {
						nextrR = nextrR - dir[i][0];
						nextcR = nextcR - dir[i][1];
					}
				}
				que.add(new Info(nextrR, nextcR, nextrB, nextcB, cnt + 1));
			}
		}
		// 큐가 비었다면 갈수 있는 방법이 없다는 것
		System.out.println(-1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new char[N][M];
		int rR = 0;
		int cR = 0;
		int rB = 0;
		int cB = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					rR = i;
					cR = j;
				}
				if (map[i][j] == 'B') {
					rB = i;
					cB = j;
				}
			}
		}
		bfs(rR, cR, rB, cB);
	}

}
