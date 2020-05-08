import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class kakaoWInter02 {
	static class Info implements Comparable<Info> {
		List<String> list;
		int len;

		public Info(List<String> list, int len) {
			super();
			this.list = list;
			this.len = len;
		}

		@Override
		public int compareTo(Info O) {
			return Integer.compare(this.len, O.len);
		}

	}

	static int[] solution(String s) {
		int[] answer = {};
		int len = s.length();

		s = s.substring(1, len - 1);
		PriorityQueue<Info> pq = new PriorityQueue<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '{') {
				List<String> li = new ArrayList<>();
				String abc = "";
				for (int j = i + 1; j < s.length(); j++) {
					char c2 = s.charAt(j);
					if (c2 == ',') {
						li.add(abc);
						abc = "";
					} else if (c2 == '}') {
						i = j;
						li.add(abc);
						pq.add(new Info(li, li.size()));
						break;
					} else {
						abc += c2;
					}
				}
			}
		}

		List<String> result = new ArrayList<>();
		while (!pq.isEmpty()) {
			//System.out.println(pq.poll().list.toString());
			Info now = pq.poll();
			
			for (int i = 0; i < now.list.size(); i++) {
				//System.out.println(now.list.get(i));
				if (!result.contains(now.list.get(i))) {
					//System.out.println("추가 " + now.list.get(i));
					result.add(now.list.get(i));
				}
			}
		}
		
		answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = Integer.parseInt(result.get(i));
		}
		return answer;
	}

	public static void main(String[] args) {
		String s = "{{20,111},{111}}";
		System.out.println(Arrays.toString(solution(s)));

	}

}
