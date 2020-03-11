
import java.util.Arrays;
import java.util.Comparator;

public class day3 {

	public static void main(String[] args) {
		int[] numbers = { 320, 32, 2 };
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		String[] arr = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			arr[i] = Integer.toString(numbers[i]);
		}

		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}

		});

		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}

		return sb.toString();
	}

}