import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex16985 {
	// 5���� ���� ��� ��������
	static int[] orderFloor = { 0, 1, 2, 3, 4 };
	// ������ � �������� ��������
	static int[] orderRotate = new int[5];
	static int[][][] arr = new int[5][5][5];
	static boolean[][][] visit;
	// �Ϲ����� 4���� + �� �Ʒ� : 6����
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

	// ���� ���� ������ �������� ȸ��
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

	// ������ ��� �������� ȸ������
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

	// �̷��� �� ������ ��� ����
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

	// �̷ΰ� �����ȴٸ� bfs�� Ž���Ͽ� ���������� �ִٸ� ������ �����ϰ�
	// �������� �� ���ٸ� -1
	// �Ա��� 000 �ⱸ�� 444 ������ ��� �������� ���� �����Ǿ� �ֱ⿡
	static void bfs() {
		int[][][] copy = new int[5][5][5];
		for (int i = 0; i < 5; i++) {
			copy[i] = rotate(arr[orderFloor[i]], orderRotate[i]);
			System.out.println(orderFloor[i] + " " + orderRotate[i]);
		}
		// �Ա��� �ⱸ�� �����ִٸ� Ž���� �ʿ� ����.
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
