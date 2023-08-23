package section0_recurion;

public class Recursion1 {

	public static void main(String[] args) {
		int result = func(4);
		System.out.println(result);
	}

	// 음이 아닌 정수 n에 대해서 0에서 n까지의 합을 계산하는 함수
	private static int func(int n) {
		if (n == 0)
			return 0;
		else
			return n + func(n - 1);

	}
}
