package SIMULATION;

import java.util.Scanner;

public class Ex1063 {
	static final char[] COL = { '0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
	static final String[] MOVE = { "R", "L", "B", "T", "RT", "LT", "RB", "LB" };
	// MOVE 에 해당하는 좌표
	static final int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, 1 }, { -1, -1 }, { 1, 1 }, { 1, -1 } };
	static int N;
	static String[] arr; // 움직임 배열
	static int[][] map; // 좌표
	static Info KING;
	static Info ROCK;

	static class Info {
		int r, c;

		Info(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static boolean isRange(int r, int c) {
		if (r <= 0 || r > 8 || c <= 0 || c > 8) {
			return false;
		}
		return true;
	}

	static void solve(int depth) {
		if (depth == N) {
			return;
		}

		int r = KING.r;
		int c = KING.c;

		for (int j = 0; j < 8; j++) {
			int d = -1;
			if (arr[depth].equals(MOVE[j])) {
				d = j;
			} else {
				continue;
			}
			int nextR = r + dir[d][0];
			int nextC = c + dir[d][1];
			// 킹의 다음위치가 범위에 있고
			if (isRange(nextR, nextC)) {
				// 다음위치에 돌이 없다면
				if (map[nextR][nextC] == 0) {
					map[nextR][nextC] = 1;
					map[r][c] = 0;
					KING = new Info(nextR, nextC);
				} else if (map[nextR][nextC] == 2) { // 다음위치에 돌이 있다면
					int nextRR = nextR + dir[d][0];
					int nextCC = nextC + dir[d][1];
					// 돌도 같은 방향으로 다음위치가 범위 안이라면
					if (isRange(nextRR, nextCC)) {
						map[nextRR][nextCC] = 2;
						map[nextR][nextC] = 1;
						map[r][c] = 0;
						KING = new Info(nextR, nextC);
						ROCK = new Info(nextRR, nextCC);
					}
				}
			}
		}

		solve(depth + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String king = sc.next();
		String rock = sc.next();
		N = sc.nextInt();
		sc.nextLine();
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLine();
		}

		map = new int[9][9];
		for (int i = 0; i < 9; i++) { // king 은 1
			if (king.charAt(0) == COL[i]) {
				int j = king.charAt(1) - 48;
				// 여기서는 좌표가 아래부터 1
				map[9 - j][i] = 1;
				KING = new Info(9 - j, i);
			}
		}

		for (int i = 0; i < 9; i++) { // rock은 2
			if (rock.charAt(0) == COL[i]) {
				int j = rock.charAt(1) - 48;
				map[9 - j][i] = 2;
				ROCK = new Info(9 - j, i);
			}
		}

		solve(0);
		int r = KING.r;
		int c = KING.c;
		System.out.print(COL[c] + "" + (9 - r));
		System.out.println();
		r = ROCK.r;
		c = ROCK.c;
		System.out.println(COL[c] + "" + (9 - r));
	}

}
