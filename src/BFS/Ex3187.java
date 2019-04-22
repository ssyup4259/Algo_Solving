package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class InfoEx3187 { //좌표 저장용
	int x, y;
	InfoEx3187(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Ex3187 {
	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int kResult, vResult;

	static boolean isRange(int a, int b) {  //map범위 안에 있는지 확인
		boolean flag = false;
		if (a >= 0 && a < R && b >= 0 && b < C) {
			flag = true;
		}
		return flag;
	}

	static void bfs(int a, int b) {  //bfs 탐색
		Queue<InfoEx3187> que = new LinkedList<>();
		que.add(new InfoEx3187(a, b));
		visit[a][b] = true;

		int vCnt = 0;
		int kCnt = 0;

		while (!que.isEmpty()) {
			int x = que.peek().x;
			int y = que.poll().y;

			if (map[x][y] == 'v') {
				vCnt++;
			} else if (map[x][y] == 'k') {
				kCnt++;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = x + dir[i][0];
				int nextY = y + dir[i][1];
				if (isRange(nextX, nextY)) {
					if (map[nextX][nextY] != '#' && visit[nextX][nextY] == false) {
						visit[nextX][nextY] = true;
						que.add(new InfoEx3187(nextX, nextY));
					}
				}
			}
		}

		if (kCnt > vCnt) {
			kResult += kCnt;
		} else {
			vResult += vCnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();

		map = new char[R][C];
		visit = new boolean[R][C];
		sc.nextLine();
		for (int i = 0; i < R; i++) { // 늑대 v,양 k,울타리 #
			String str = sc.nextLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		kResult = 0;
		vResult = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visit[i][j] == false && map[i][j] != '#') {
					bfs(i, j);
				}
			}
		}

		System.out.println(kResult + " " + vResult);

	}

}
