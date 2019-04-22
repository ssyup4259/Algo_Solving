
import java.util.Scanner;

public class Ex9933 {
	// String�� �յ� �ٲ㼭 ����
	static String solve(String str) {
		char[] arr = str.toCharArray();
		for (int i = 0; i < str.length() / 2; i++) {
			char temp = arr[i];
			arr[i] = arr[str.length() - 1 - i];
			arr[str.length() - 1 - i] = temp;
		}
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLine();
		}

		// �ڱ��ڽ��� �縰����̶�� ��й�ȣ�� �� �� �����ϱ�
		for (int i = 0; i < N - 1; i++) {
			// �ڱ� �ڽŵ� ����(j=i)
			for (int j = i; j < N; j++) {
				// arr[i] �� arr[j]�� �յ� �ٲ۰��� ���ٸ�
				if (arr[i].equals(solve(arr[j]))) {
					System.out.println(arr[i].length() + " " + arr[i].charAt(arr[i].length() / 2));
					return;
				}
			}
		}

	}

}
