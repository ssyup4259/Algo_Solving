package OTHER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex11657 {
	static int N, M;
	static List<Info> list = new ArrayList<>();
	static int[] dist;
	static int result;

	static class Info {
		int start, end, w;

		Info(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}
	}

	static void bellman() {
		// ������ �ִ� ����� �� N -1 ��ŭ �����Ѵ�.
		// ����� ������ 3�϶� 1���� 3�� ���� ���� ���ƺ��� 2���� �鸰�ٴ� �ǹ�
		// �̺��� ����Ƚ���� ���ٴ� ���� ��򰡿� ���� ��ΰ� ���� �Ͽ� ������ �ݺ��ȴٴ� ��
		for (int v = 0; v <= N; v++) {
			// ���� ���� Ƚ���� N�� �ȴٸ� ������ΰ� ����
			if (v == N) {
				System.out.println(-1);
				return;
			}

			int flag = 0; // ���� �۾��� �մ��� üũ��
			for (int i = 0; i < list.size(); i++) {
				int start = list.get(i).start;
				int end = list.get(i).end;
				int w = list.get(i).w;

				// ���� ��尡 ���Ѵ밡 �ƴϰ� ���� ��尡 ���� ��� + ����ġ ���� ũ�ٸ� ����
				if (dist[start] != Integer.MAX_VALUE) {
					if (dist[start] + w < dist[end]) {
						dist[end] = dist[start] + w;
						flag++; // ���� �۾� Ƚ�� ����
					}
				}
			}

			// �����۾��� �����ٸ� ���� ����
			if (flag == 0) {
				for (int i = 2; i <= N; i++) {
					if (dist[i] == Integer.MAX_VALUE) {
						System.out.println(-1);
					} else {
						System.out.println(dist[i]);
					}
				}
				return;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		int max = 0;
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			list.add(new Info(A, B, C));
		}

		dist = new int[N + 1];
		dist[1] = 0;
		for (int i = 2; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		bellman();
	}

}
