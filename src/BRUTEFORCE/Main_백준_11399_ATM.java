package BRUTEFORCE;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_11399_ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		for (int i = 1; i < N; i++) {
			arr[i] = arr[i] + arr[i - 1];
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}

}
