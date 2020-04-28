package OTHER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_18870_좌표압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			pq.add(num);
		}
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		int cnt = 0;
		int flag = Integer.MIN_VALUE;
		while (!pq.isEmpty()) {
			int num = pq.poll();
			if (num != flag) {
				flag = num;
				hm.put(num, cnt);
				cnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		for(int i = 0 ; i<N;i++) {
			int res = hm.get(arr[i]);
			sb.append(res).append(" ");
		}
		System.out.println(sb);
	}

}
