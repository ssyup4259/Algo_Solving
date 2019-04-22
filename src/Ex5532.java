import java.util.Scanner;

public class Ex5532 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();

		int max = 0;
		int result = 0;
		if (A % C == 0) {
			result = A / C;
		} else {
			result = A / C + 1;
		}
		if (result > max) {
			max = result;
		}
		if (B % D == 0) {
			result = B / D;
		} else {
			result = B / D + 1;
		}
		if (result > max) {
			max = result;
		}

		System.out.println(L - max);
	}

}
