package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_1260_DFS와BFS {
	static int N, V;
	static List<Integer>[] adj;
	static boolean[] v;
	static List<Integer> list = new ArrayList<>();

	static void dfs(int now, int cnt) {
		if (cnt == N) {
			return;
		}
		System.out.print(now + " ");
		for (int i = 0; i < adj[now].size(); i++) {
			int next = adj[now].get(i);
			if (!v[next]) {
				v[next] = true;
				dfs(next, cnt++);
			}
		}
	}

	static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		que.add(V);
		boolean[] visit = new boolean[N + 1];
		visit[V] = true;
		while (!que.isEmpty()) {
			int now = que.poll();
			System.out.print(now + " ");
			for (int i = 0; i < adj[now].size(); i++) {
				int next = adj[now].get(i);
				if (!visit[next]) {
					visit[next] = true;
					que.add(next);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		V = sc.nextInt();
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}
		v = new boolean[N + 1];
		v[V] = true;
		dfs(V, 0);
		System.out.println();
		bfs();

	}

}
