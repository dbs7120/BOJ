package d0830;
import java.util.Scanner;

// 점프는 즐거워
public class BOJ4383 {

	static int N;
	static int[] arr;
	static boolean[] visit;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		while (sc.hasNext()) { // EOF까지 무한입력
			N = sc.nextInt();

			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			if (N == 1) { // N이 1일때 무조건 Jolly
				System.out.println("Jolly");
				continue;
			}

			visit = new boolean[N];
			flag = true;

			for (int i = 0; i < N - 1; i++) {
				int temp = Math.abs(arr[i] - arr[i + 1]);
				if (temp > 0 && temp < N && !visit[temp]) { // 각경계검사 방문검사
					visit[temp] = true; // 방문 체크
				} else {
					// 방문한지점 또방문했다면,
					// 차이의 절대값이 N-1보다 크다면
					// => 무조건 Jolly jumper 가 될 수 없음
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.println("Jolly");
			} else {
				System.out.println("Not jolly");
			}
		}

		sc.close();

	}

}
