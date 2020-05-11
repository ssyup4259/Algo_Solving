package SIMULATION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_백준_5549_행성탐사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		char[][] map = new char[M + 1][N + 1];

		int[][] J = new int[M + 1][N + 1];
		int[][] O = new int[M + 1][N + 1];
		int[][] I = new int[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			String str = br.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = str.charAt(j - 1);
				J[i][j] = J[i - 1][j] + J[i][j - 1] - J[i - 1][j - 1];
				O[i][j] = O[i - 1][j] + O[i][j - 1] - O[i - 1][j - 1];
				I[i][j] = I[i - 1][j] + I[i][j - 1] - I[i - 1][j - 1];
				if (map[i][j] == 'J') {
					J[i][j]++;
				} else if (map[i][j] == 'O') {
					O[i][j]++;
				} else {
					I[i][j]++;
				}
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int resJ = J[c][d] - J[c][b - 1] - J[a - 1][d] + J[a - 1][b - 1];
			int resO = O[c][d] - O[c][b - 1] - O[a - 1][d] + O[a - 1][b - 1];
			int resI = I[c][d] - I[c][b - 1] - I[a - 1][d] + I[a - 1][b - 1];
			System.out.println(resJ + " " + resO + " " + resI);
		}
	}

}
