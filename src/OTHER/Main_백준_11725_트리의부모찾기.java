package OTHER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_11725_트리의부모찾기 {
	static List<Integer>[] adj;
	static int[] p;

	static void solve(int now) {
		for (int i = 0; i < adj[now].size(); i++) {
			int next = adj[now].get(i);
			if (p[next] == next && next != 1) {
				p[next] = now;
				solve(next);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adj[start].add(end);
			adj[end].add(start);
		}
		solve(1);

		for (int i = 2; i <= N; i++) {
			System.out.println(p[i]);
		}
	}

}
