package d0816;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 등수구하기
// 디맥랭킹
// 새로운 점수가 주어질때의 랭킹
// 만약, 랭킹 리스트가 꽉 차있을 때, 새 점수가 이전 점수보다 더 좋을 때만 점수가 바뀐다
public class BOJ1205 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 점수 갯수
		int newScore = sc.nextInt(); // 새로운 점수
		int P = sc.nextInt(); // 출력 리스트 수
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			arr.add(num);
		}
		if (N == P && arr.get(N - 1) >= newScore) { // get(index) : 배열리스트의 index위치의 값 반환
			System.out.println(-1);
		} else {
			// 점수 넣고 정렬후 다시 내림차순정렬(reverse)
			arr.add(newScore);
			Collections.sort(arr);
			Collections.reverse(arr);

			int last = arr.indexOf(newScore);
			if (last < P) { // 점수페이지 내부에 있는경우(정상출력)
				System.out.println(last + 1); // index 1부터 계산값
			} else { // 점수값 페이지 넘어선경우 (미출력)
				System.out.println(-1);
			}
		}

		sc.close();
	}

}
