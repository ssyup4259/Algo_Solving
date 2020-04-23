import java.util.Stack;

public class kakaoWinter01 {
	static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < moves.length; i++) {
			int line = moves[i] - 1;
			for (int j = 0; j < board.length; j++) {
				if (board[j][line] != 0) {
					if (!st.isEmpty() && st.peek() == board[j][line]) {
						st.pop();
						answer += 2;
					} else {
						st.add(board[j][line]);
					}
					board[j][line] = 0;
					break;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, 
				{ 0, 0, 1, 0, 3 }, 
				{ 0, 2, 5, 0, 1 }, 
				{ 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(board, moves));
	}

}
