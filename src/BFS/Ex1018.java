package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex1018 {
	static int N, M;
	static char[][] newMap = new char[8][8];
	// (0,0)부터 (8,8)까지 탐색 할거 여서 오른쪽 아래쪽으로만 가도 된다.
	static int[][] dir = { { 0, 1 }, { 1, 0 } };
	static int result;
	static int cnt;

	static class Info {
		int r, c;

		Info(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= 8 || c < 0 || c >= 8) {
			return false;
		}
		return true;
	}

	static void bfs(int r, int c) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(r, c));
		boolean[][] visit = new boolean[N][M];
		visit[0][0] = true;

		while (!que.isEmpty()) {
			int nowR = que.peek().r;
			int nowC = que.poll().c;
			// 종료조건
			if (nowR == 7 && nowC == 7) {
				if (cnt < result) {
					result = cnt;
				}
				// 지금색깔 바꾼것의 정반대 방법이 하나더 존재 한다.
				// 시작점이 'B'일 수도 'W' 일수도 있음
				if (64 - cnt < result) {
					result = 64 - cnt;
				}
			}
			for (int i = 0; i < 2; i++) {
				int nextR = nowR + dir[i][0];
				int nextC = nowC + dir[i][1];
				if (isRange(nextR, nextC) && !visit[nextR][nextC]) {
					if (newMap[nextR][nextC] != newMap[nowR][nowC]) {
						que.add(new Info(nextR, nextC));
						visit[nextR][nextC] = true;
					} else { // 이전과 지금의 색깔이 같다면 바꿔줘야한다.
						que.add(new Info(nextR, nextC));
						cnt++;
						if (newMap[nextR][nextC] == 'W') {
							newMap[nextR][nextC] = 'B';
						} else {
							newMap[nextR][nextC] = 'W';
						}
						visit[nextR][nextC] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		result = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				// 시작점 (i,j)로 부터 8*8칸의 체스판을 만들어 newMap에 저장
				for (int r = 0; r < 8; r++) {
					for (int c = 0; c < 8; c++) {
						newMap[r][c] = map[i + r][j + c];
					}
				}
				// newMap을 가지고 bfs탐색
				cnt = 0;
				bfs(0, 0);
			}
		}
		System.out.println(result);
	}

}
