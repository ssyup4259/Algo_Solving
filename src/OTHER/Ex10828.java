package OTHER;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex10828 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		List<Integer> stack = new ArrayList<>();

		int flag = 0; // stack 리스트에 몇개가 들어있는지
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			String[] arr = str.split(" ");
			if (arr[0].equals("push")) {
				flag++;
				stack.add(Integer.parseInt(arr[1]));
			} else if (arr[0].equals("top")) {
				if (flag == 0) {
					System.out.println(-1);
				} else {
					System.out.println(stack.get(flag - 1));
				}
			} else if (arr[0].equals("size")) {
				System.out.println(flag);
			} else if (arr[0].equals("empty")) {
				if (flag == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (arr[0].equals("pop")) {
				if (flag == 0) {
					System.out.println(-1);
				} else {  
					System.out.println(stack.get(flag - 1));
					stack.remove(flag - 1);
					flag--;
				}
			}
		}

	}

}
