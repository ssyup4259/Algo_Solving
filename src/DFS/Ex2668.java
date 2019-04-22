package DFS;

import java.util.Scanner;

public class Ex2668 {
	static int N;
	static int[] arr;
	static int[] visit;

	public static void dfs(int x) {
		if (visit[x] >= 2)
			return;
		visit[x]++;

		dfs(arr[x]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1];
		visit = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			dfs(i);
			for (int j = 1; j <= N; j++) { // 2�� �ƴ϶�� ���� ������ �ʱ�ȭ
				if (visit[j] < 2)
					visit[j] = 0;
			}
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) { // 2�ΰŴ� ����Ŭ �ϼ� �̹Ƿ� �ߵȰ�
			if (visit[i] == 2)
				cnt++;
		}

		System.out.println(cnt);
		for (int i = 1; i <= N; i++) {
			if (visit[i] == 2)
				System.out.println(i);
		}

	}

}
