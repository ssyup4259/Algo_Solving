package OTHER;

import java.util.Scanner;

public class Main_백준_2751_수정렬하기2 {

	static int[] data;
	static int num;
	static int[] tmp = new int[1000001]; // 이부분이 시간초과를 만들어냄

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		data = new int[num + 1];

		for (int i = 1; i <= num; i++) {
			data[i] = sc.nextInt();
		}
		sc.close();
		mergeSort(data, 1, num);

		for (int i = 1; i <= num; i++) {
			System.out.println(data[i]);
		}
	}

	public static void merge(int[] data, int p, int q, int r) {
		int i = p, j = q + 1, k = p;

		while (i <= q && j <= r) {
			if (data[i] <= data[j])
				tmp[k++] = data[i++];
			else
				tmp[k++] = data[j++];
		}
		while (i <= q)
			tmp[k++] = data[i++];
		while (j <= r)
			tmp[k++] = data[j++];

		for (int w = p; w <= r; w++)
			data[w] = tmp[w];
	}

	public static void mergeSort(int[] data, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2; // 중간값
			mergeSort(data, p, q);
			mergeSort(data, q + 1, r);
			merge(data, p, q, r);
		}
	}
}
