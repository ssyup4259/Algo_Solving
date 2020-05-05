package BFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_1939_중량제한 {
	static int N, M;
	static boolean[] visit;
	static List<Info>[] adj;
	static int[] memo;

	static class Info {
		int start, end, w;

		public Info(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Info [start=" + start + ", end=" + end + ", w=" + w + "]";
		}

	}

	static int solve(int start, int end, int target) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(0, start, 0));
		visit[start] = true;
		int res = 0;
		while (!que.isEmpty()) {
			Info now = que.poll();
			if (now.end == end) {
				res = 1;
			}
			for (int i = 0; i < adj[now.end].size(); i++) {
				Info next = adj[now.end].get(i);
				if (!visit[next.end] && target <= next.w) {
					visit[next.end] = true;
					que.add(next);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		adj = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		int max = 0;
		int min = 1000000001;
		// A,B 도시 연결 다리가 여러개 일 수 있다. 중량제한 큰 것만 입력받으면 된다.
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			max = Math.max(max, C);
			min = Math.min(min, C);
			adj[A].add(new Info(A, B, C));
			adj[B].add(new Info(B, A, C));
		}

		int start = sc.nextInt();
		int end = sc.nextInt();
		while (min <= max) {
			visit = new boolean[N + 1];
			int mid = (min + max) / 2;
			if (solve(start, end, mid) != 0) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		System.out.println(max);
	}
}
