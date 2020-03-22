package OTHER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2751_수정렬하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[2000001];

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num + 1000000] = 1;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				System.out.println(i - 1000000);
			}
		}
	}

}
