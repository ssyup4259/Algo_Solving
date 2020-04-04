package GRAPH;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_11724_연결요소의개수 {
	static int[] p;

	static int find(int x) {
		if (p[x] != x) {
			p[x] = find(p[x]);
			return p[x];
		}
		return x;
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			if (a < b) {
				p[b] = a;
			} else {
				p[a] = b;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			union(start, end);
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (p[i] == i) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
