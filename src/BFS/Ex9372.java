package BFS;

import java.util.Scanner;

public class Ex9372 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // ������
			int m = sc.nextInt(); // ����� ����
			int[][] arr = new int[m][2];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < 2; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(n - 1);   //���� ������ n-1�� �ּ�
		}
	}

}
