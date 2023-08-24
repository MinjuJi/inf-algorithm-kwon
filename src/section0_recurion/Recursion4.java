package section0_recurion;

public class Recursion4 {

	public static void main(String[] args) {

		String arr1[] = { "가", "라", "E", "운", "T", "Y" };

		int val1 = search1(arr1, arr1.length, "Y");
		System.out.print("해당 문자의 배열 위치: ");
		System.out.println(val1);

		int val2 = search2(arr1, 0, arr1.length - 1, "Y");
		System.out.print("해당 문자의 배열 위치: ");
		System.out.println(val2);

		int val3 = search3(arr1, arr1.length - 1, "Y");
		System.out.print("해당 문자의 배열 위치: ");
		System.out.println(val3);

		int val4 = search4(arr1, 0, arr1.length - 1, "Y");
		System.out.print("해당 문자의 배열 위치: ");
		System.out.println(val4);

	}

	// (순환함수X) 배열에서 해당 문자의 위치 찾는 함수. 검색구간의 종료 위치만 설정함 
	private static int search1(String[] data, int n, String target) {
		for (int i = 0; i < n; i++) {
			if (data[i] == target)
				return i;
		}
		return -1;
	}

	// (순환함수O) 배열에서 해당 문자의 위치 찾는 함수. 검색구간의 시작 위치와 종료 위치 모두 설정
	private static int search2(String[] data, int begin, int end, String target) {
		if (begin > end)
			return -1;
		else if (target == data[begin])
			return begin;
		else
			return search2(data, begin + 1, end, target);
	}

	// (순환함수O) 배열에서 해당 문자의 위치 찾는 함수. 검색구간의 종료 위치만 설정
	private static int search3(String[] data, int end, String target) {
		if (data[end].equals(target))
			return end;
		else if (end <= -1)
			return -1;
		else
			return search3(data, end - 1, target);
	}

	// (순환함수 O) 배열에서 해당 문자의 위치를 찾는 함수. 검색구간에 middle을 추가함.
	private static int search4(String[] data, int begin, int end, String target) {
		if (begin > end)
			return -1;
		else {
			int middle = (begin + end) / 2;
			if (data[middle].equals(target))
				return middle;

			int index = search4(data, begin, middle - 1, target);
			if (index != -1) // index가 -1이 아니라는 것은 target과 같은 값의 위치를 찾았다는 의미
				return index;
			else
				return search4(data, middle + 1, end, target);

		}

	}
}
