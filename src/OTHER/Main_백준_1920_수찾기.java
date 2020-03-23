package OTHER;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_1920_수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int M = sc.nextInt();
		int[] arr2 = new int[M];
		for (int i = 0; i < M; i++) {
			arr2[i] = sc.nextInt();
		}
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		int flag = 0;
		for (int i = 0; i < M; i++) {
			int num = arr2[i];
			boolean check = false;
			while (flag < N && arr[flag] <= num) {
				if (arr[flag] == num) {
					check = true;
					break;
				}
				flag++;
			}
			if (check) {
				flag++;
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

}
