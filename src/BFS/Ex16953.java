package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex16953 {
	static long A, B;
	static int result;

	static class Info {
		long num;
		int cnt; // ���� ����, ����µ� �ɸ� Ƚ��

		Info(long num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	static void bfs(long a) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(a, 0));

		while (!que.isEmpty()) {
			long nowN = que.peek().num;
			int nowC = que.poll().cnt;

			// ���� ���ڰ� B���Ǹ� Ƚ�� �ּҰ� ����
			if (nowN == B) {
				if (result > nowC) {
					result = nowC;
				}
			}
			// ���� ���ڰ� B���� ũ�� �Ѿ��.
			if (nowN > B) {
				continue;
			}

			// �� ��츦 ������ bfs �������.
			long nextN1 = nowN * 2;
			que.add(new Info(nextN1, nowC + 1));
			long nextN2 = nowN * 10 + 1;
			que.add(new Info(nextN2, nowC + 1));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// A�� �Է����� 999999998 �� �������� ������ �ϸ� int�� ���� �����
		// A,B �Ѵ� long����
		A = sc.nextLong();
		B = sc.nextLong();
		result = Integer.MAX_VALUE;
		bfs(A);
		// result �� �ٲ��ٸ� ����� ���°�
		if (result == Integer.MAX_VALUE) {
			result = -1;
		} else {
			result++;
		}
		System.out.println(result);
	}

}
