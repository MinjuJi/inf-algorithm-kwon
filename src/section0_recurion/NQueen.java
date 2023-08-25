package section0_recurion;

public class NQueen {

	static int N = 8; // 체스판의 크기(N*N 체스판)
	static int[] cols = new int[N + 1]; // cols[i]=j는 i행, j열을 뜻함. 즉, i행에서는 j열에 퀸이 위치함. (0,0)~(N,N)까지 범위이기에 [N+1]로 배열의 크기를 설정함 
	static int level = 0; // 현재까지 놓인 퀸의 개수

	private static boolean promising(int level) { // 현재 위치에서 8방향에 다른 퀸이 있으면 false
		for (int i = 1; i < level; i++) {
			if (cols[i] == cols[level]) { // 같은 열에 있으면 false
				return false;
			} else if (level - i == Math.abs(cols[level] - cols[i])) { // 대각선에서 만나면 false
				return false;
			}
		}
		return true;
	}

	private static boolean queens(int level) { // 데이터 타입을 boolean이 아니라 void로 해도 됨(void로 하는 것이 간편할 듯)
		if (!promising(level)) // 퀸이 같은 열이거나 대각선에서 만나게 되면 false
			return false;
		else if (level == N) { // level == N이면 모든 행에 하나의 퀸이 놓였다는 의미. 따라서 체스판 위에 N개의 퀸이 놓여짐. 끝! 

			// 체스판 위의 퀸들의 위치를 2차원 배열로 출력
			int[][] chessBoard = new int[N + 1][N + 1]; // 배열의 초기값 0 
			for (int i = 1; i <= N; i++) {
				chessBoard[i][cols[i]] = 1; // 퀸이 있는 위치를 1로 표현
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(chessBoard[i][j] + " ");
				}
				System.out.println();
			}
			return true;
		}
		
		for (int i = 1; i <= N; i++) {
			cols[level + 1] = i; // 같은 행에서 열만 바꾸면서 promising을 검사함
			if (queens(level + 1)) // 조건이 false가 되면 반복문으로 되돌아감
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		queens(level);
	}

}
