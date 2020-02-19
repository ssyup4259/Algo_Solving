package OTHER;
import java.util.Scanner;

public class Main_백준_1546_평균 {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			int[] arr = new int[num];
			float[] arr2 = new float[num];
			float max = 0;
			float sum = 0f;
			for (int i = 0; i < num; i++) {
				arr[i] = scan.nextInt();
			}
			max = arr[0];
			for (int i = 1; i < num; i++) {
				if (max < arr[i]) {
					max = arr[i];
				}
			}
			for (int i = 0; i < num; i++) {
				arr2[i] = (arr[i] / max) * 100;
			}
			for (int i = 0; i < num; i++) {
				sum = sum + arr2[i];
			}

			System.out.format("%.2f", sum / num);

		}

	}