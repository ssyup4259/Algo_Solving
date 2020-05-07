package GRAPH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_백준_1613_역사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] adj = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			int a = sc.nextInt(); // 먼저 일어난일
			int b = sc.nextInt(); // 뒤에 일어난일
			adj[a][b] = -1;
			adj[b][a] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (adj[i][j] == 0) {
						if (adj[i][k] == 1 && adj[k][j] == 1) {
							adj[i][j] = 1;
						} else if (adj[i][k] == -1 && adj[k][j] == -1) {
							adj[i][j] = -1;
						}
					}
				}
			}
		}

		int s = sc.nextInt();
		for (int i = 0; i < s; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(adj[a][b]);
		}
	}
}
