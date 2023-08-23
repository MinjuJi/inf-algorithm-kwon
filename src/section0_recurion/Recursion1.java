package section0_recurion;

public class Recursion1 {

	public static void main(String[] args) {
		int result = func(4);
		System.out.println(result);
	}

	private static int func(int n) {
		if (n == 0)
			return 0;
		else
			return n + func(n - 1);

	}
}
