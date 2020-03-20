import java.util.Arrays;

public class day10 {
	static int[] order, num;
	static int tar, result;

	static void checkTarget() {
		int sum = 0;
		for (int i = 0; i < order.length; i++) {
			int oper = order[i];
			int number = num[i];
			if (oper == 0) {
				sum += number;
			} else {
				sum -= number;
			}
		}
		if (sum == tar) {
			result++;
		}
	}

	static void makeOrder(int idx) {
		if (idx == order.length) {
			checkTarget();
			return;
		}
		for (int i = 0; i < 2; i++) {
			order[idx] = i;
			makeOrder(idx + 1);
		}
	}

	static int solution(int[] numbers, int target) {
		int len = numbers.length;
		order = new int[len];
		num = numbers;
		tar = target;
		result = 0;

		makeOrder(0);
		return result;
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(solution(numbers, target));
	}
}
