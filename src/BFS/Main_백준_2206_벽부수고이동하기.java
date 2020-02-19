package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class InfoEx2206 { // ��ǥ, �μ̴��� �Ⱥμ̴��� ����
	int r, c, z;

	InfoEx2206(int r, int c, int z) {
		this.r = r;
		this.c = c;
		this.z = z;
	}
}

public class Main_백준_2206_벽부수고이동하기 {
	static int n, m;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static String[][] map;
	static int[][][] dp; // �μ����� dp[][][1] �Ⱥμ����� dp[][][0]

	static boolean isRange(int r, int c) { // map���� �ȿ� �ִ��� Ȯ��
		boolean flag = false;
		if (r > 0 && r <= n && c > 0 && c <= m) {
			flag = true;
		}
		return flag;
	}

	static void bfs(int a, int b, int z) {
		Queue<InfoEx2206> que = new LinkedList<>();
		que.add(new InfoEx2206(a, b, z));

		while (!que.isEmpty()) {
			int r = que.peek().r;
			int c = que.peek().c;
			int broken = que.poll().z; // peek�� ù���� ���⸸, poll�� ù���� ���� ����, broken�� �μ̴���Ȯ�ο�

			for (int i = 0; i < 4; i++) {
				int nextR = r + dir[i][0];
				int nextC = c + dir[i][1];
				if (isRange(nextR, nextC)) {
					// ���ν��� �ִµ� ������ ���̶�� �ٸ� ���� Ȯ��
					if (map[nextR][nextC].equals("1") && broken == 1) {
						continue;

					// ���ν��� ���� ������ ���� ���� �ƴ϶��
					} else if (map[nextR][nextC].equals("0") && dp[nextR][nextC][broken] == 0) {
						dp[nextR][nextC][broken] = dp[r][c][broken] + 1;
						que.add(new InfoEx2206(nextR, nextC, broken));

					// ���ν��� ���� ������ ���� ���̶��
					} else if (map[nextR][nextC].equals("1") && dp[nextR][nextC][broken + 1] == 0 && broken == 0) {
						dp[nextR][nextC][broken + 1] = dp[r][c][broken] + 1;
						que.add(new InfoEx2206(nextR, nextC, broken + 1));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		map = new String[n + 1][m + 1];
		dp = new int[n + 1][m + 1][2];
		dp[1][1][0] = 1;
		for (int i = 1; i <= n; i++) {
			String str = sc.nextLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = str.substring(j - 1, j);
			}
		}
		bfs(1, 1, 0);

		int a = dp[n][m][0];
		int b = dp[n][m][1];
		if (a == 0) {
			if (b == 0) {
				System.out.println(-1);
			} else {
				System.out.println(b);
			}
		} else if (b == 0) {
			if (a == 0) {
				System.out.println(-1);
			} else {
				System.out.println(a);
			}
		} else {
			System.out.println(Math.min(a, b));
		}

	}

}
