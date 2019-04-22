import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex16985 {
	// 5개의 층을 어떻게 구성할지
	static int[] orderFloor = { 0, 1, 2, 3, 4 };
	// 각층을 어떤 방향으로 구성할지
	static int[] orderRotate = new int[5];
	static int[][][] arr = new int[5][5][5];
	static boolean[][][] visit;
	// 일반적인 4방향 + 위 아래 : 6방향
	static int[][] dir = { { 1, 0, 0 }, { 0, 0, 1 }, { 0, 1, 0 }, { -1, 0, 0 }, { 0, -1, 0 }, { 0, 0, -1 } };
	static int result;

	static boolean isRange(int a, int b, int c) {
		if (a < 0 || a >= 5 || b < 0 || b >= 5 || c < 0 || c >= 5) {
			return false;
		}
		return true;
	}

	static class Info {
		int a, b, c, cnt;

		Info(int a, int b, int c, int cnt) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.cnt = cnt;
		}
	}

	// 현재 층을 정해진 방향으로 회전
	static int[][] rotate(int[][] temp, int num) {
		int[][] copy = new int[5][5];
		if (num == 0) {
			copy = temp;
		} else if (num == 1) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					copy[i][j] = temp[j][4 - i];
				}
			}
		} else if (num == 2) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					copy[i][j] = temp[4 - i][4 - j];
				}
			}
		} else if (num == 3) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					copy[i][j] = temp[4 - j][i];
				}
			}
		}
		return copy;
	}

	static void swapFloor(int a, int b) {
		int temp = orderFloor[a];
		orderFloor[a] = orderFloor[b];
		orderFloor[b] = temp;
	}

	// 각층을 어떠한 방향으로 회전할지
	static void pickRotate(int idx) {
		if (idx == 5) {
			bfs();
			return;
		}
		for (int i = 0; i < 4; i++) {
			orderRotate[idx] = i;
			pickRotate(idx + 1);
		}
	}

	// 미로의 층 구성을 어떻게 할지
	static void pickFloor(int depth) {
		if (depth == 5) {
			pickRotate(0);
			return;
		}

		for (int i = depth; i < 5; i++) {
			swapFloor(i, depth);
			pickFloor(depth + 1);
			swapFloor(depth, i);
		}
	}

	// 미로가 구성된다면 bfs로 탐색하여 빠져나갈수 있다면 최저값 갱신하고
	// 빠져나갈 수 없다면 -1
	// 입구는 000 출구는 444 무조건 모든 방향으로 층이 구성되어 있기에
	static void bfs() {
		int[][][] copy = new int[5][5][5];
		for (int i = 0; i < 5; i++) {
			copy[i] = rotate(arr[orderFloor[i]], orderRotate[i]);
			System.out.println(orderFloor[i] + " " + orderRotate[i]);
		}
		// 입구나 출구가 막혀있다면 탐색할 필요 없다.
		if (copy[0][0][0] == 1 || copy[4][4][4] == 1) {
			return;
		}

		Queue<Info> que = new LinkedList<>();
		que.add(new Info(0, 0, 0, 0));
		visit = new boolean[5][5][5];
		visit[0][0][0] = true;

		while (!que.isEmpty()) {
			int na = que.peek().a;
			int nb = que.peek().b;
			int nc = que.peek().c;
			int cnt = que.poll().cnt;

			if (na == 4 && nb == 4 && nc == 4) {
				System.out.println(cnt);
				if (result > cnt) {
					result = cnt;
				}
			}

			for (int i = 0; i < 6; i++) {
				int nexta = na + dir[i][0];
				int nextb = nb + dir[i][1];
				int nextc = nc + dir[i][2];

				if (isRange(nexta, nextb, nextc)) {
					if (!visit[nexta][nextb][nextc] && copy[nexta][nextb][nextc] == 0) {
						que.add(new Info(nexta, nextb, nextc, cnt + 1));
						visit[nexta][nextb][nextc] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					arr[i][j][k] = sc.nextInt();
				}
			}
		}
		result = Integer.MAX_VALUE;
		pickFloor(0);
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}

}
