package SIMULATION;
import java.util.Scanner;

public class Ex1195 {

	static int solve(int[] arr1, int[] arr2) {
		int result = 0;
		int cnt = 0;
		boolean flag = true;
		for (int i = 0; i < arr1.length; i++) {
			// 두개의 합이 3이상이 되는 것이 하나라도 있다면 맞물리지 않는다.
			if (arr1[i] + arr2[i] > 3) {
				flag = false;
			}
			if (arr1[i] + arr2[i] == 0) {
				cnt++;
			}
		}

		if (flag) {
			result = arr1.length - cnt;
		} else { // 맞물리지 않으면 0
			result = 0;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		int len = str1.length() + str2.length();
		// 위 배열 그대로 아래 배열 움직이는용
		int[] arr1 = new int[len];
		int[] arr2 = new int[len];

		// 아래배열 그대로 위 배열 움직이는 용
		int[] arr3 = new int[len];
		int[] arr4 = new int[len];

		// 4개의 배열의 크기는 최대가능길이인 위아래 기어 가로길이 합
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

		int result1 = 0;// 1,2배열의 결과
		int result2 = 0;// 3,4배열의 결과
		int result = Integer.MAX_VALUE;

		for (int k = 0; k <= Math.max(str1.length(), str2.length()); k++) {
			result1 = solve(arr1, arr2);
			result2 = solve(arr4, arr3);
			int temp1 = arr2[0];
			int temp2 = arr3[0];

			arr2[0] = arr2[arr2.length - 1];
			arr3[0] = arr3[arr3.length - 1];
			// 1,2 배열중 아래 기어를 움직인다. 오른쪽으로
			// 3, 4 배열중 위 기어를 움직인다. 오른쪽으로
			for (int i = arr2.length - 1; i >= 2; i--) {
				arr2[i] = arr2[i - 1];
				arr3[i] = arr3[i - 1];
			}
			arr2[1] = temp1;
			arr3[1] = temp2;

			// result1 이 0 이라면 1,2기어는 맞물리지 않는 다는것
			// result1이 0 이더라도 result2의 다음 인덱스가 더짧이 질수 있으니
			// 두개의 기어중 더 긴 것의 길이 만큼 움직여야한다.
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
