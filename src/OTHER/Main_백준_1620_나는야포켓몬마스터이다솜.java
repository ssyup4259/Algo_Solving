package OTHER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_백준_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<String> list = new ArrayList<>();
		HashMap<String, String> hm = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			hm.put(Integer.toString(i + 1), str);
			hm.put(str, Integer.toString(i + 1));
		}
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			System.out.println(hm.get(str));
		}
	}

}
