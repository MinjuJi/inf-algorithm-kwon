package section0_recurion;

public class PowerSet {

	private static char data[] = { 'a', 'b', 'c' }; 
	private static int n = data.length;
	private static boolean[] include = new boolean[n]; // data 집합의 각 원소를 포함할 것인지 t/f로 나타냄

	private static void powerSet(int k) { // k는 부분집합을 생성할 때 각 원소에 대해 선택 여부를 결정하는 과정에서 k를 활용하여 현재 어떤 원소를 처리하고 있는지를 표현

		if (k == n) { // include배열의 크기까지 도달했으면 부분집합 출력
			boolean isEmpty = true; // 공집합의 여부를 나타내는 변수
			for (int i = 0; i < n; i++) {
				if (include[i]) {
					System.out.print(data[i] + " ");
					isEmpty = false; // 원소가 선택되었음을 표시
				}
			}
			if (isEmpty)
				System.out.println("∅");
			System.out.println();
			return;
		}

		include[k] = false;
		powerSet(k + 1);
		include[k] = true;
		powerSet(k + 1);

	}

	public static void main(String[] args) {
		powerSet(0); // k = 0
	}

}
