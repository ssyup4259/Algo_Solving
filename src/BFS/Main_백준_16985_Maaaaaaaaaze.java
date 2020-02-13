package BFS;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_16985_Maaaaaaaaaze {
	static int map[][][];
	static int order[];
	static int rotation[];
	static final int[][] dir = { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 }, { -1, 0, 0 }, { 0, -1, 0 }, { 0, 0, -1 } };
	static int min;

	static class Info {
		int r, c, h, cnt;

		public Info(int r, int c, int h, int cnt) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.cnt = cnt;
		}
	}

	static boolean isRange(int r, int c, int h) {
		if (r < 0 || r >= 5 || c < 0 || c >= 5 || h < 0 || h >= 5) {
			return false;
		}
		return true;
	}

	static int[][] rotate(int[][] arr, int num, int idx) {
		if (idx == num) {
			return arr;
		} else {
			int[][] newArr = new int[5][5];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					newArr[i][j] = arr[4 - j][i];
				}
			}
			return rotate(newArr, num, idx + 1);
		}
	}

	static void bfs(int[][][] mapp) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(0, 0, 0, 0));
		boolean[][][] v = new boolean[5][5][5];
		int res = Integer.MAX_VALUE;
		while (!que.isEmpty()) {
			Info now = que.poll();
			// System.out.println("cnt : " + now.cnt + " r: " + now.r + " c: " + now.c + "
			// h: " + now.h);
			if (now.r == 4 && now.c == 4 && now.h == 4) {
				res = now.cnt;
			}
			for (int d = 0; d < 6; d++) {
				int nextR = now.r + dir[d][0];
				int nextC = now.c + dir[d][1];
				int nextH = now.h + dir[d][2];

				if (isRange(nextR, nextC, nextH) && !v[nextR][nextC][nextH] && mapp[nextR][nextC][nextH] == 1) {
					v[nextR][nextC][nextH] = true;
					que.add(new Info(nextR, nextC, nextH, now.cnt + 1));
				}
			}
		}
		if (min > res) {
			min = res;
		}
	}

	static void rotateOrder(int idx) {
		if (idx == 5) {
			// System.out.println("돌림 순서");
			// System.out.println(Arrays.toString(rotation));
			int[][][] newMap = new int[5][5][5];
			for (int i = 0; i < 5; i++) {
				int rotateCnt = rotation[i];
				int heigtNum = order[i];
				newMap[i] = rotate(map[heigtNum], rotateCnt, 0);
			}
			if (newMap[0][0][0] == 1 && newMap[4][4][4] == 1) {
				bfs(newMap);
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			rotation[idx] = i;
			rotateOrder(idx + 1);
		}
	}

	static void takeOrder(int idx, boolean[] visit) {
		if (idx == 5) {
			// System.out.println("층 순서");
			// System.out.println(Arrays.toString(order));
			rotation = new int[5];
			rotateOrder(0);
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (!visit[i]) {
				order[idx] = i;
				visit[i] = true;
				takeOrder(idx + 1, visit);
				visit[i] = false;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[5][5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					map[i][j][k] = sc.nextInt();
				}
			}
		}
		order = new int[5];
		min = Integer.MAX_VALUE;
		takeOrder(0, new boolean[5]);
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

}
