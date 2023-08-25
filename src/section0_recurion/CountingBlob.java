package section0_recurion;

// 주어진 그리드에서 특정 위치에서 시작하여 얼마나 많은 이미지 영역이 연결되어 있는지를 세는 프로그램
public class CountingBlob {
	private static int N = 8;
	private static int[][] grid = { 
			{ 1, 0, 1, 0, 1, 1, 0, 1 },
			{ 1, 1, 0, 0, 0, 1, 0, 0 },
			{ 0, 1, 0, 1, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 1, 1, 0, 1, 0 },
			{ 0, 0, 0, 0, 0, 1, 0, 0 },
			{ 0, 1, 1, 0, 1, 1, 1, 0 },
			{ 1, 0, 0, 1, 0, 0, 1, 1 }
	};

	private static final int BACKGROUND = 0;
	private static final int IMAGE = 1;
	private static final int ALREADY = 2;

	// 2차원 그리드에서 특정 이미지(1로 표시된 부분)를 탐색하며 그와 연결된 이미지의 개수를 세는 재귀 함수
	public static int countCells(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return 0;
		else if (grid[x][y] != IMAGE)
			return 0;
		else {
			grid[x][y] = ALREADY;

			return 1 + countCells(x - 1, y) + countCells(x - 1, y + 1) +
					countCells(x, y + 1) + countCells(x + 1, y + 1) +
					countCells(x + 1, y) + countCells(x + 1, y - 1) +
					countCells(x, y - 1) + countCells(x - 1, y - 1);
		}
	}

	private static void printBlob() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		printBlob();
		System.out.println();
		System.out.print("CountingBlob : " + countCells(0, 4));
		System.out.println("\n");
		printBlob();
	}

}
