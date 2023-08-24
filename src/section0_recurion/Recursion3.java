package section0_recurion;

public class Recursion3 {

	public static void main(String[] args) {

		String arr1[] = { "E", "T", "Y", "가", "라", "운" }; // 이진검색을 위해 데이터 정렬함
		int arr2[] = { 4, 3, 6, 6, 2, 9, 5 };

		int value1 = findMax1(arr2, 1, arr2.length - 1);
		System.out.print("최대값 : ");
		System.out.println(value1);

		int value2 = findMax2(arr2, 1, arr2.length - 1);
		System.out.print("최대값 : ");
		System.out.println(value2);

		int value3 = binarySearch(arr1, "운", 0, arr1.length - 1);
		System.out.print("해당 문자의 배열 위치 : ");
		System.out.println(value3);

	}

	// data[begin] ~ data[end] 사이에서 최대값을 찾아 반환 하는 순환함수(가정: begin <= end)
	private static int findMax1(int[] data, int begin, int end) {

		if (begin == end)
			return data[begin];
		else
			return Math.max(data[begin], findMax1(data, begin + 1, end));

	}

	//data[begin] ~ data[middle] 과 data[middle] ~ data[end] 사이에서 최대값을 찾아 반환 하는 순환함수(가정: begin <= end)
	private static int findMax2(int[] data, int begin, int end) {
		if (begin == end)
			return data[begin];
		else {
			int middle = (begin + end) / 2;
			int max1 = findMax2(data, begin, middle);
			int max2 = findMax2(data, middle + 1, end);
			return Math.max(max1, max2);
		}
	}

	// Binary Search(이진검색 알고리즘) // 이진검색 활용 시 데이터가 크기순으로 정렬되어 있어야 함 
	private static int binarySearch(String[] arr, String target, int begin, int end) {
		if (begin > end)
			return -1;
		else {
			int middle = (begin + end) / 2;
			int result = arr[middle].compareTo(target);
			if (result == 0)
				return middle;
			else if (result > 0)
				return binarySearch(arr, target, begin, middle - 1);
			else
				return binarySearch(arr, target, middle + 1, end);

		}
	}

}
