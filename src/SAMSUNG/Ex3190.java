package SAMSUNG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex3190 {
	static int N, K, L;
	static int[][] map;// map�� ��� �ִ���
	static char[] arr; // �ð��� ���� ȸ��
	static int time; // ���� �ð�
	static Info warm;// ������
	// �� �� �� ��
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Queue<Rc> que;

	static class Info { // ������ ����
		int hr, hc, tr, tc, dir;

		Info(int hr, int hc, int tr, int tc, int dir) {
			this.hr = hr; // �Ӹ���ǥ
			this.hc = hc;
			this.tr = tr; // ������ǥ
			this.tc = tc;
			this.dir = dir; // �Ӹ� ����
		}

	}

	static class Rc { // ��ǥ �����
		int r;
		int c;

		Rc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static boolean isRange(int r, int c) {
		if (r <= 0 || r > N || c <= 0 || c > N) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		K = sc.nextInt();
		for (int i = 0; i < K; i++) { // ��� �ڸ��� 1���Է�
			int r = sc.nextInt();
			int c = sc.nextInt();
			map[r][c] = 1;
		}

		L = sc.nextInt();
		arr = new char[10001]; // �������� X�� �ִ� 10000
		for (int i = 0; i < L; i++) {
			int x = sc.nextInt();
			arr[x] = sc.next().charAt(0);
		}
		warm = new Info(1, 1, 1, 1, 1);
		map[1][1] = 2; // ���� ������ �ڸ��� 2���� �����ؼ� 2,3,4... �̷������� ����� 1�� ����ҰŴϤ���
		time = 0;
		que = new LinkedList<>(); // que�� ���� �Ӹ��� ���°� ������ ť�� �ִ´�.
		que.add(new Rc(1, 1));

		while (true) {
			int nowD = warm.dir;
			int nextR = warm.hr + dir[nowD][0];
			int nextC = warm.hc + dir[nowD][1];
			time++;
			// ���� ������ �ʾҵ���
			if (isRange(nextR, nextC)) {
				// ���� ĭ �� ��� ���� �ڱ� �� �ƴ϶��
				if (map[nextR][nextC] == 0) {
					map[nextR][nextC] = time + 2;
					warm.tr = que.peek().r;
					warm.tc = que.poll().c;
					map[warm.tr][warm.tc] = 0; // ����ĭ�� 0�� �������� �ϴµ� �� ������ ���� ���� ���� ť
				} else if (map[nextR][nextC] == 1) {// ���� ĭ�� ����� �ִٸ�
					map[nextR][nextC] = time + 2;
				} else { // ���� ĭ�� �ڱ���̶��
					break;
				}
			} else { // ���� �����ٸ�
				break;
			}

			// ���� ����
			int nextD = nowD;
			if (arr[time] == 'D') {
				nextD = (nowD + 1) % 4;
			} else if (arr[time] == 'L') {
				nextD = (nowD + 4 - 1) % 4;
			}

			// �Ӹ� �κ� �ٲٱ�
			warm.hr = nextR;
			warm.hc = nextC;
			warm.dir = nextD;
			que.add(new Rc(nextR, nextC));
		}

		System.out.println(time);
	}
}
