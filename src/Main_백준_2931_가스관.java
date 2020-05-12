import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_2931_가스관 {
	// 막힌 방향 위 오른쪽 아래 왼쪽
	static final int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int R, C;
	static int[][] map;
	static Info start, end;
	static boolean[][] visit;

	static class Info {
		int r, c, useK, type;

		public Info(int r, int c, int useK, int type) {
			this.r = r;
			this.c = c;
			this.useK = useK;
			this.type = type;
		}

		@Override
		public String toString() {
			return "Info [r=" + r + ", c=" + c + ", useK=" + useK + ", type=" + type + "]";
		}

	}

	// 위 막히면 1, 오른쪽 2, 아래쪽 4, 왼쪽 8
	static int changePipe(char c) {
		int res = -1;
		switch (c) {
		case '|':
			res = 10;
			break;
		case '-':
			res = 5;
			break;
		case '+':
			res = 0;
			break;
		case '1':
			res = 9;
			break;
		case '2':
			res = 12;
			break;
		case '3':
			res = 6;
			break;
		case '4':
			res = 3;
			break;
		default:
			res = 15;
			break;
		}
		return res;
	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C) {
			return false;
		}
		return true;
	}

	static int changeD(int d) {
		if (d == 0) {
			return 2;
		} else if (d == 1) {
			return 3;
		} else if (d == 2) {
			return 0;
		} else {
			return 1;
		}
	}

	// 현재 위치 기준 안막힌 곳을 찾는다.
	static void sol(int r, int c, int preD, int dd) {
		if (r == end.r && c == end.c) {
			return;
		}
		if (map[r][c] == 0) {
			sol(r + dir[dd][0], c + dir[dd][1], preD, dd);
		} else {

			for (int d = 0; d < 4; d++) {
				int nextR = r + dir[d][0];
				int nextC = c + dir[d][1];
				// 지금 기준 갈수있는곳 중에 다음이 범위 안에 잇꼬 왔던데가 아니면
				if (isRange(nextR, nextC) && (map[r][c] & 1 << d) == 0 && d != preD) {
					preD = changeD(d);
					sol(nextR, nextC, preD, d);
				}
			}
		}

		// 여기 왔따는 것은 막혔을때
		int sum = 0;
		for (int d = 0; d < 4; d++) {
			int nextR = r + dir[d][0];
			int nextC = c + dir[d][1];
			if (isRange(nextR, nextC)) {
				int nextD = -1;
				int ddd = -1;
				if (d == 0) { // 위에
					nextD = 2;
					ddd = 4;
				} else if (d == 1) { // 오른쪽
					nextD = 3;
					ddd = 8;
				} else if (d == 2) { // 아래쪽
					nextD = 0;
					ddd = 1;
				} else { // 왼쪽
					nextD = 1;
					ddd = 2;
				}
				if ((map[nextR][nextC] & 1 << nextD) == 0) {
					System.out.println("뚫림 : "+nextR+ " " + nextC );
					sum += ddd;
				}
			}
		}
		char res = '0';
		if (sum == 0) {
			res = '+';
		} else if (sum == 3) {
			res = '4';
		} else if (sum == 5) {
			res = '|';
		} else if (sum == 6) {
			res = '3';
		} else if (sum == 9) {
			res = '1';
		} else if (sum == 10) {
			res = '-';
		} else if (sum == 12) {
			res = '2';
		}
		System.out.println(sum);
		System.out.println((r + 1) + " " + (c + 1) + " " + res);
		System.exit(0);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				char c = str.charAt(j);
				if (c == 'Z') {
					map[i][j] = 0;
					start = new Info(i, j, 0, -1);
				} else if (c == 'M') {
					map[i][j] = 0;
					end = new Info(i, j, 0, -1);
				} else {
					map[i][j] = changePipe(c);
				}
			}
		}
		visit = new boolean[R][C];
		for (int d = 0; d < 4; d++) {
			int nextR = start.r + dir[d][0];
			int nextC = start.c + dir[d][1];
			if (isRange(nextR, nextC)) {
				int nextD = -1;
				if (d == 0) {
					nextD = 2;
				} else if (d == 1) {
					nextD = 3;
				} else if (d == 2) {
					nextD = 0;
				} else {
					nextD = 1;
				}
				if ((map[nextR][nextC] & 1 << nextD) == 0) {
					System.out.println("시작");
					sol(nextR, nextC, nextD, d);
					break;
				}
			}
		}
	}

}
