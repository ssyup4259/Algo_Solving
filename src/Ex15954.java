import java.util.Scanner;

public class Ex15954 {
	static int N,M;
	static int[] arr;
	static int sum, ave;
	static int[] arrM;
	
	static void solve(int depth) {
		for(int i = depth; i< N ;i++) {
			arrM[i] = 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		ave = sum / N;
		
	}

}
