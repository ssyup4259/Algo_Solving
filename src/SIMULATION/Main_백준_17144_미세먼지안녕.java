package SIMULATION;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_백준_17144_미세먼지안녕 {
	static final int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int R, C, T;
	static int[][] map;
	static List<Info> list = new ArrayList<>();
	static Info cleanerTop;
	static Info cleanerBottom;
	static int sum;

	static class Info {
		int r, c, amount;

		public Info(int r, int c, int amount) {
			this.r = r;
			this.c = c;
			this.amount = amount;
		}

	}

	static boolean isRange(int r, int c) {
		if (r <= 0 || r > R || c <= 0 || c > C) {
			return false;
		}
		return true;
	}

	// 공기 청정기 작동 전 먼지의 확산
	static void move() {
		sum = 0;
		int[][] newMap = new int[R + 1][C + 1];
		newMap[cleanerTop.r][cleanerTop.c] = -1;
		newMap[cleanerBottom.r][cleanerBottom.c] = -1;

		for (int i = 0; i < list.size(); i++) {
			Info munzi = list.get(i);
			int newAmount = munzi.amount / 5;
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nextR = munzi.r + dir[d][0];
				int nextC = munzi.c + dir[d][1];
				if (isRange(nextR, nextC) && map[nextR][nextC] != -1) {
					cnt++;
					newMap[nextR][nextC] += newAmount;
					sum += newAmount;
				}
			}
			int nnewAmount = munzi.amount - cnt * newAmount;
			newMap[munzi.r][munzi.c] += nnewAmount;
			sum += nnewAmount;
		}
		list.clear();
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = newMap[i][j];
			}
		}
	}

	// 공기청정기 상단부분
	static void cleanTop() {
		int r = cleanerTop.r;
		int flag = map[r][2];
		map[r][2] = 0;
		for (int i = 3; i <= C; i++) {
			int temp = flag;
			flag = map[r][i];
			map[r][i] = temp;
		}
		for (int i = r - 1; i > 0; i--) {
			int temp = flag;
			flag = map[i][C];
			map[i][C] = temp;
		}
		for (int i = C - 1; i > 0; i--) {
			int temp = flag;
			flag = map[1][i];
			map[1][i] = temp;
		}
		for (int i = 2; i < r; i++) {
			int temp = flag;
			flag = map[i][1];
			map[i][1] = temp;
		}
		sum -= flag;
	}

	static void cleanBottom() {
		int r = cleanerBottom.r;
		int flag = map[r][2];
		map[r][2] = 0;
		for (int i = 3; i <= C; i++) {
			int temp = flag;
			flag = map[r][i];
			map[r][i] = temp;
		}
		for (int i = r + 1; i <= R; i++) {
			int temp = flag;
			flag = map[i][C];
			map[i][C] = temp;
		}
		for (int i = C - 1; i > 0; i--) {
			int temp = flag;
			flag = map[R][i];
			map[R][i] = temp;
		}
		for (int i = R - 1; i > r; i--) {
			int temp = flag;
			flag = map[i][1];
			map[i][1] = temp;
		}
		sum -= flag;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		map = new int[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] > 0) {
					list.add(new Info(i, j, map[i][j]));
				}
				if (map[i][j] == -1) {
					if (cleanerTop == null) {
						cleanerTop = new Info(i, j, 0);
					} else {
						cleanerBottom = new Info(i, j, 0);
					}
				}
			}
		}
		for (int i = 0; i < T; i++) {
			move();
			cleanTop();
			cleanBottom();
			list.clear();
			for (int j = 1; j <= R; j++) {
				for (int k = 1; k <= C; k++) {
					if (map[j][k] > 0) {
						list.add(new Info(j, k, map[j][k]));
					}
				}
			}
		}
		System.out.println(sum);
	}

}
