package section0_recurion;

public class Maze {

	private static int N = 8; // N*N 크기의 배열([N][N]이 미로의 출구)
	private static int[][] maze = {
			{ 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 0, 1, 1, 0, 1, 1, 0, 1 },
			{ 0, 0, 0, 1, 0, 0, 0, 1 },
			{ 0, 1, 0, 1, 1, 0, 0, 0 },
			{ 0, 1, 1, 1, 0, 0, 1, 1 },
			{ 0, 1, 0, 0, 0, 1, 0, 1 },
			{ 0, 0, 0, 1, 0, 0, 0, 1 },
			{ 0, 1, 1, 1, 0, 1, 0, 0 },
	};

	private static final int PATHWAY = 0; // 지나갈 수 있는 길(안 가본 곳)
	private static final int WALL = 1; // 벽(안 가본 곳)
	private static final int BLOCKED = 2; // 끝까지 가보니 출구가 없는 경로(가본 곳)
	private static final int PATH = 3; // 출구로 가는 경로가 될 가능성이 있는 경로(가본 곳)

	// 깊이 우선 탐색(DFS): 모든 가능한 경로를 탐색하면서 목표 지점에 도달하는 경로를 찾을 때까지 진행하는 방식
	// 미로 내에 여러 경로가 있을 경우, 발견된 경로 중 가장 먼저 찾은 경로가 선택되기 때문에 최단 경로를 보장하지 않을 수 있다
	private static boolean findMazePath(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return false;
		else if (maze[x][y] != PATHWAY)
			return false;
		else if (x == N - 1 && y == N - 1) { // 출구
			maze[x][y] = PATH;
			return true;
		} else {
			maze[x][y] = PATH;

			//  북, 동, 남, 서 순으로 탐색한다.
			if (findMazePath(x - 1, y) || findMazePath(x, y + 1) || findMazePath(x + 1, y) || findMazePath(x, y - 1)) {
				return true;
			}
			maze[x][y] = BLOCKED;
			return false;
		}
	}

	private static void printMaze() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		printMaze();
		findMazePath(0, 0);
		System.out.println("\n길찾기 완료[3]\n");
		printMaze();
	}

}
