package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_1697_숨바꼭질 {
	static int N, K;

	static boolean isRange(int r) {
		if (r < 0 || r > 100000) {
			return false;
		}
		return true;
	}

	static int solve() {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { N, 0 });
		boolean[] visit = new boolean[100001];
		visit[N] = true;
		while (!que.isEmpty()) {
			int now = que.peek()[0];
			int cnt = que.poll()[1];

			if (now == K) {
				return cnt;
			}

			// +1 칸 이동
			int next = now + 1;
			if (isRange(next) && !visit[next]) {
				visit[next] = true;
				que.add(new int[] { next, cnt + 1 });
			}

			next = now - 1;
			if (isRange(next) && !visit[next]) {
				visit[next] = true;
				que.add(new int[] { next, cnt + 1 });
			}

			next = now * 2;
			if (isRange(next) && !visit[next]) {
				visit[next] = true;
				que.add(new int[] { next, cnt + 1 });
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		System.out.println(solve());
	}

}
