package section0_recurion;

public class Recursion1 {

	public static void main(String[] args) {
		int result1 = func(4);
		System.out.print("0 ~ n까지의 합 : ");
		System.out.println(result1);

		int result2 = factorial(5);
		System.out.print("n팩토리얼 : ");
		System.out.println(result2);

		int result3 = power(2, 3);
		System.out.print("x의 n제곱 : ");
		System.out.println(result3);

		int result4 = fibonacci(5);
		System.out.print("피보나치 : ");
		System.out.println(result4);

		int result5 = gcd(260, 140);
		System.out.print("m, n의 최대공약수 : ");
		System.out.println(result5);
	}

	// 음이 아닌 정수 n에 대해서 0에서 n까지의 합을 계산하는 함수
	private static int func(int n) {
		if (n == 0)
			return 0;
		else
			return n + func(n - 1);

	}

	// 팩토리얼 계산하는 함수
	private static int factorial(int n) {

		if (n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}

	// 0이 아닌 x의 n제곱을 계산 하는 함수
	private static int power(int x, int n) {
		if (n == 0)
			return 1;
		else
			return x * power(x, n - 1);
	}

	// 피보나치 // f0 = 0, f1 = 1, fn = f(n-1) + f(n-2) - n > 1
	private static int fibonacci(int n) {
		if (n < 2)
			return n;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

	// 최대공약수(greatest common denominator, GCD)
	private static int gcd(int m, int n) {
		if (m < n) { // swap m and n
			int tmp = m;
			m = n;
			n = tmp;
		}
		if (m % n == 0)
			return n;
		else
			return gcd(n, m % n);
	}
}
