package section0_recurion;

import java.io.File;
import java.util.Scanner;

public class Recursion2 {

	public static void main(String[] args) {

		int result1 = length("가나 초콜릿");
		System.out.print("문자열의 길이 : ");
		System.out.println(result1);

		System.out.print("문자열의 프린트 : ");
		printChars("크런키 초콜릿");
		System.out.println();

		System.out.print("문자열의 프린트 : ");
		printCharsReverse("크런키 초콜릿");
		System.out.println();

		System.out.print("음이 아닌 정수 n을 이진수로 변환 : ");
		printInBinary(19);
		System.out.println();

		try {
			Scanner fs = new Scanner(new File("data.txt"));

			int length = fs.nextInt();

			int[] arr = new int[length];
			readFrom(length, arr, fs);

			System.out.println("입력된 배열 내용: ");
			for (int value : arr) {
				System.out.print(value + " ");
			}
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 문자열의 길이 계산
	private static int length(String str) {
		if (str.equals(""))
			return 0;
		else
			return 1 + length(str.substring(1));
	}

	// 문자열의 프린트
	private static void printChars(String str) {
		if (str.length() == 0)
			return;
		else {
			System.out.print(str.charAt(0));
			printChars(str.substring(1));
		}
	}

	// 문자열을 뒤집어 프린트
	private static void printCharsReverse(String str) {
		if (str.length() == 0)
			return;
		else {
			printCharsReverse(str.substring(1)); // 문자열의 프린트 함수에서 두 줄의 코드 위치만 바꿈
			System.out.print(str.charAt(0));
		}
	}

	// 음이 아닌 정수 n을 2진수로 변환하여 출력
	private static void printInBinary(int n) {
		if (n < 2) {
			System.out.print(n);
		} else {
			printInBinary(n / 2);
			System.out.print(n % 2);

		}
	}

	// 배열의 합 구하기
	private static int sum(int n, int[] data) { // n은 배열에 저장된 데이터의 개수
		if (n <= 0)
			return 0;
		else
			return data[n - 1] + sum(n - 1, data);
	}

	// 데이터 파일로 부터 n개의 정수 읽어오기
	private static void readFrom(int n, int[] data, Scanner in) {
		if (n == 0)
			return;
		else {
			readFrom(n - 1, data, in);
			data[n - 1] = in.nextInt();
		}
	}
	
	
}
