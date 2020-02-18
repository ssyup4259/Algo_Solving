package GRAPH;

import java.util.Scanner;

public class Main_백준_1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = 9999999;
			}
		}

		int start, end;
		for (int i = 1; i <= m; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			arr[start][end] = 1; // start ģ���� end ģ�� ����
			arr[end][start] = 1;
		}

		for (int i = 1; i <= n; i++) { // (1,5)�� ģ�����谡 (1,3) +(3,5)�� ������ (1,5)�� ������ Ȯ��
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					arr[j][k] = (arr[j][k] < (arr[j][i] + arr[i][k]) ? arr[j][k] : (arr[j][i] + arr[i][k]));
				}
			}
		}

		for (int i = 1; i <= n; i++) { // ģ������� �� ���ϱ�
			for (int j = 1; j <= n; j++) {
				arr[i][j] = arr[i][j] + arr[i][j - 1];
			}
		}

		int min = 99999;
		int flag = 0;
		for (int i = 1; i <= n; i++) {
			if (arr[i][n] < min) {
				min = arr[i][n];
				flag = i;
			}
		}

		System.out.println(flag);
	}

}
