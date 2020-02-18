package SIMULATION;

import java.util.Scanner;

public class Main_백준_1022_소용돌이예쁘게출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		int[][] map = new int[50][50]; // r1�� r2, c1�� c2 �� ���� ���� �ִ� 49
		int max = 0;

		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				int r = i - r1;
				int c = j - c1;

				if (i > j) { // ���� �� �ΰ��� �밢���� �������� ���ʰ� �Ʒ���
					if (i + j > 0) { // ����
						map[r][c] = (i * 2 + 1) * (i * 2 + 1) - i + j;
					} else { // �Ʒ���
						map[r][c] = (j * 2) * (j * 2) - j + 1 + i;
					}
				} else if (i == j) {
					if (i >= 0) {
						map[r][c] = (i * 2 + 1) * (i * 2 + 1);
					} else {
						map[r][c] = (i * (-2)) * (i * (-2)) + 1;
					}
				} else { // ���� �� �ΰ��� �밢���� �������� �����ʰ� ����
					if (i + j < 0) { // ����
						map[r][c] = (i * 2) * (i * 2) + i - j + 1;
					} else { // ������
						map[r][c] = (j * 2 - 1) * (j * 2 - 1) + j - i;
					}
				}
				if (map[r][c] > max) { // map���� ���� ū ���� �ڸ����� �˱�����
					max = map[r][c];
				}
			}
		}

		int strLen = Integer.toString(max).length();
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				int r = i - r1;
				int c = j - c1;
				if (Integer.toString(map[r][c]).length() < strLen) { // ���� ū ���� �ڸ������� ���� ������ �ڸ����� �۴ٸ�
					for (int k = 0; k < strLen - Integer.toString(map[r][c]).length(); k++)
						System.out.print(" "); // ���ʿ� ���� �߰�
				}
				if (j == c2) {
					System.out.println(map[r][c]);
				} else {
					System.out.print(map[r][c] + " ");
				}
			}
		}
	}

}
