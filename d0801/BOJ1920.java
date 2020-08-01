package d0801;
import java.util.Arrays;
import java.util.Scanner;

// 1 2 3 4 5
// 1 3 7 9 5
public class BOJ1920 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();

		}
		Arrays.sort(arr);

		int M = sc.nextInt();
		int[] find = new int[M];
		for (int i = 0; i < M; i++) {
			find[i] = sc.nextInt();
		}
//      // Arrays클래스 binarySearch메소드(찾으면 index반환(양수))
//		for(int i =0;i<M;i++) {
//			int num = Arrays.binarySearch(arr, find[i]);
//			if(num>=0)
//				System.out.println(1);
//			else
//				System.out.println(0);
//		}

		for (int i = 0; i < M; i++) {
			int num = bSearch(arr, find[i], 0, N - 1); // 타겟배열, 찾을값, 타겟배열첫인덱스, 타겟배열마지막인덱스
			if (num == 1)
				System.out.println(1);
			else
				System.out.println(0);

		}

		sc.close();

	}

	// 이진탐색 재귀
	static int bSearch(int[] arr, int target, int first, int last) {
		int mid = (first + last) / 2;

		if (first > last)
			return -1; // 찾는값 없음

		if (target == arr[mid])
			return 1;
		else if (target < arr[mid]) { // 찾는값이 중간보다 작으면
			return bSearch(arr, target, first, mid - 1);
		} else { // 찾는값이 중간보다 크면
			return bSearch(arr, target, mid + 1, last);
		}
	}
}