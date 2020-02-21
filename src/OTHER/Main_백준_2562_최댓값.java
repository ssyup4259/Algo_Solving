package OTHER;

import java.util.Scanner;

public class Main_백준_2562_최댓값 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int max = Integer.MIN_VALUE;
		int flag = 0;
		for (int i = 1; i <= 9; i++) {
			arr[i] = sc.nextInt();
			if(max<arr[i]) {
				flag = i;
				max = arr[i];
			}
		}
		System.out.println(max);
		System.out.println(flag);

	}

}
