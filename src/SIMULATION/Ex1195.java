package SIMULATION;
import java.util.Scanner;

public class Ex1195 {

	static int solve(int[] arr1, int[] arr2) {
		int result = 0;
		int cnt = 0;
		boolean flag = true;
		for (int i = 0; i < arr1.length; i++) {
			// �ΰ��� ���� 3�̻��� �Ǵ� ���� �ϳ��� �ִٸ� �¹����� �ʴ´�.
			if (arr1[i] + arr2[i] > 3) {
				flag = false;
			}
			if (arr1[i] + arr2[i] == 0) {
				cnt++;
			}
		}

		if (flag) {
			result = arr1.length - cnt;
		} else { // �¹����� ������ 0
			result = 0;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		int len = str1.length() + str2.length();
		// �� �迭 �״�� �Ʒ� �迭 �����̴¿�
		int[] arr1 = new int[len];
		int[] arr2 = new int[len];

		// �Ʒ��迭 �״�� �� �迭 �����̴� ��
		int[] arr3 = new int[len];
		int[] arr4 = new int[len];

		// 4���� �迭�� ũ��� �ִ밡�ɱ����� ���Ʒ� ��� ���α��� ��
		for (int i = 0; i < len; i++) {
			if (i < str1.length()) {
				arr1[i] = Integer.parseInt(str1.substring(i, i + 1));
				arr3[i] = Integer.parseInt(str1.substring(i, i + 1));
			} else {
				arr1[i] = 0;
				arr3[i] = 0;
			}
		}

		for (int i = 0; i < len; i++) {
			if (i < str2.length()) {
				arr2[i] = Integer.parseInt(str2.substring(i, i + 1));
				arr4[i] = Integer.parseInt(str2.substring(i, i + 1));
			} else {
				arr2[i] = 0;
				arr4[i] = 0;
			}
		}

		int result1 = 0;// 1,2�迭�� ���
		int result2 = 0;// 3,4�迭�� ���
		int result = Integer.MAX_VALUE;

		for (int k = 0; k <= Math.max(str1.length(), str2.length()); k++) {
			result1 = solve(arr1, arr2);
			result2 = solve(arr4, arr3);
			int temp1 = arr2[0];
			int temp2 = arr3[0];

			arr2[0] = arr2[arr2.length - 1];
			arr3[0] = arr3[arr3.length - 1];
			// 1,2 �迭�� �Ʒ� �� �����δ�. ����������
			// 3, 4 �迭�� �� �� �����δ�. ����������
			for (int i = arr2.length - 1; i >= 2; i--) {
				arr2[i] = arr2[i - 1];
				arr3[i] = arr3[i - 1];
			}
			arr2[1] = temp1;
			arr3[1] = temp2;

			// result1 �� 0 �̶�� 1,2���� �¹����� �ʴ� �ٴ°�
			// result1�� 0 �̴��� result2�� ���� �ε����� ��ª�� ���� ������
			// �ΰ��� ����� �� �� ���� ���� ��ŭ ���������Ѵ�.
			if (result1 == 0 && result2 == 0) {
				continue;
			} else if (result1 == 0) {
				if (result > result2) {
					result = result2;
				}
			} else if (result2 == 0) {
				if (result > result1) {
					result = result1;
				}
			} else if (result1 != 0 && result2 != 0) {
				if (result > Math.min(result1, result2)) {
					result = Math.min(result1, result2);
				}
			}
		}

		System.out.println(result);
	}

}
