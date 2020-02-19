package SIMULATION;

import java.util.Scanner;

public class Main_백준_2455_지능형기차 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] in = new int[5]; // ź��� �����
		int[] out = new int[5]; // ������� �����
		for (int i = 1; i <= 4; i++) {
			out[i] = sc.nextInt();
			in[i] = sc.nextInt();
		}

		int[] result = new int[5];// ������ �°����� ������ �ȿ� �����ִ� ��� ����
		result[0] = 0;
		for (int i = 1; i <= 4; i++) { // 1~4�� �°���
			result[i] = result[i - 1] + in[i] - out[i];
		}

		int max = 0;
		for (int i = 0; i < 5; i++) { // ���� ���� �����ִ� ��� ��
			if (max < result[i])
				max = result[i];
		}
		System.out.println(max);
	}

}
