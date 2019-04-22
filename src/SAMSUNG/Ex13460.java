package SAMSUNG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex13460 {
	static int N, M;
	static char[][] map;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static class Info {
		int rR, cR, rB, cB; // ������ �Ķ��� ��ǥ
		int cnt; // ����� ��

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

			if (cnt > 10) { // 10�� ���Ϸ� ���� �ȳ��´ٸ� -1 ���
				System.out.println(-1);
				return;
			}

			// �������� ���ۿ� �ִµ� �Ķ����� ���ۿ� ������ �� ���
			if (map[rR][cR] == 'O' && (map[rR][cR] != map[rB][cB])) {
				System.out.println(cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextrR = rR;
				int nextcR = cR;
				int nextrB = rB;
				int nextcB = cB;
				// ����� �������� ������� ������.
				while (true) {
					// ������ ���̸� ���� �׸�
					if (map[nextrR + dir[i][0]][nextcR + dir[i][1]] == '#') {
						break;
					}
					// ������ �����̸� ���� �׸�
					if (map[nextrR + dir[i][0]][nextcR + dir[i][1]] == 'O') {
						nextrR = nextrR + dir[i][0];
						nextcR = nextcR + dir[i][1];
						break;
					}
					nextrR = nextrR + dir[i][0];
					nextcR = nextcR + dir[i][1];
				}
				// �������� ��������
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

				// �Ķ����� ���ۿ� ���� �ȵȴ�.
				if (map[nextrB][nextcB] == 'O') {
					continue;
				}
				
				// �������� �������� �Ķ����� ���� ��ġ�� ������
				if (nextrR == nextrB && nextcR == nextcB) {
					// �������� �Ķ����� ������ �Ÿ��� �������� �Ÿ��� �� ª�ٸ� �� ���� ������ ª�� ���� ������
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
		// ť�� ����ٸ� ���� �ִ� ����� ���ٴ� ��
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
