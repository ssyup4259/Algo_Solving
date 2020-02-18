package GRAPH;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_백준_1238_파티 {
	static int N, M, X;
	static List<Info>[] adj;
	static int[] backDist, goDist;
	static int max;

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

	static void backDi(int x) { // x번에서 집으로 갈때 큐
		PriorityQueue<Integer> que = new PriorityQueue<>();
		backDist[x] = 0;
		que.add(x);

		while (!que.isEmpty()) {
			int now = que.poll();

			for (int i = 0; i < adj[now].size(); i++) {
				int end = adj[now].get(i).end;
				int w = adj[now].get(i).w;

				if (backDist[end] > backDist[now] + w) {
					backDist[end] = backDist[now] + w;
					que.add(end);
				}
			}
		}

		//System.out.println(Arrays.toString(backDist));
		goDist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (i == X) {
				continue;
			}
			go(i);
		}

		//System.out.println(Arrays.toString(goDist));
		max = 0;
		for (int i = 1; i <= N; i++) {
			if (max < goDist[i] + backDist[i]) {
				max = goDist[i] + backDist[i];
			}
		}
	}

	static void go(int start) {
		PriorityQueue<Integer> que = new PriorityQueue<>();
		int[] newDist = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			newDist[i] = Integer.MAX_VALUE;
		}

		newDist[start] = 0;
		que.add(start);
		while (!que.isEmpty()) {
			int now = que.poll();

			for (int i = 0; i < adj[now].size(); i++) {
				int end = adj[now].get(i).end;
				int w = adj[now].get(i).w;

				if (newDist[end] > newDist[now] + w) {
					newDist[end] = newDist[now] + w;
					que.add(end);
				}
			}
		}

		goDist[start] = newDist[X];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();

		adj = new ArrayList[N + 1];
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int w = sc.nextInt();

			if (adj[start] == null) {
				adj[start] = new ArrayList<>();
			}

			adj[start].add(new Info(start, end, w));
		}

		backDist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			backDist[i] = Integer.MAX_VALUE;
		}

		backDi(X);
		System.out.println(max);
	}

}
