package SAMSUNG;

import java.util.Scanner;

public class Ex14888 {
	static int n;
	static int[] arr;
	static int[] oper;
	static int min, max;

	//���� ���鶧 �ʿ��� ��ȯ
	static int[] swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return arr;
	}

	// ������ ���ǿ� �´� ���
	static int sub(int a, int b, int o) {
		int answer = 0;
		if (o == 0) {
			answer = a + b;
		} else if (o == 1) {
			answer = a - b;
		} else if (o == 2) {
			answer = a * b;
		} else if (o == 3) {
			if (a < 0) {
				a = -a;
				answer = a / b;
				answer = -answer;
			} else {
				answer = a / b;
			}
		}
		return answer;
	}

	// ����,�������� ������ ������ �ٲٸ� ��� ��� ���
	static void solve(int[] order, int cnt) {
		if (cnt == n - 1) {
			return;
		}
		int result = 0;
		// ù ���� ������ ���ϱ�
		result = result + arr[0];
		for (int i = 1; i < n; i++) {
			result = sub(result, arr[i], order[i - 1]);
		}
		if (min > result) {
			min = result;
		}
		if (max < result) {
			max = result;
		}
		for (int i = cnt; i <= n - 2; i++) {
			order = swap(order, cnt, i);
			solve(order, cnt + 1);
			order = swap(order, i, cnt);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		oper = new int[4]; // +,-,*,% �� ����
		int[] order = new int[n - 1]; // ������ ���Ŀ�
		int flag = 0;

		// �������� ���� �Է� �ް� �迭�� ���� �Է�
		for (int i = 0; i < 4; i++) {
			oper[i] = sc.nextInt();
			if (oper[i] != 0) {
				for (int j = flag; j < flag + oper[i]; j++) {
					order[j] = i;
				}
				flag = flag + oper[i];
			}
		}
		min = 1000000000;
		max = -1000000000;
		solve(order, 0);
		System.out.println(max);
		System.out.println(min);

	}

}
