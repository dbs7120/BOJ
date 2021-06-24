package d0822;

import java.util.Scanner;

// N과 M (1) => 순열 ( n P m )
public class BOJ15649 {
	static int n;
	static int m;
	static boolean visit[];
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visit = new boolean[n + 1];
		arr = new int[n + 1];
		DFS(0);
		sc.close();
	}

	public static void DFS(int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				visit[i] = true; // 방문체크
				arr[cnt] = i; // 선택
				DFS(cnt + 1); // 다음 재귀
				visit[i] = false; // 선택뒤 미방문(백트래킹)

			}
		}
	}

}
