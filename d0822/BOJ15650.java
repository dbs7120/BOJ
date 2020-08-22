package d0822;

import java.util.Scanner;

//N과 M (2)
public class BOJ15650 {
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
		DFS(1, 0);
		sc.close();
	}

	public static void DFS(int idx, int cnt) { // 조합 DFS
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = idx; i <= n; i++) {
			if (!visit[i]) {
				visit[i] = true; // 방문체크
				arr[cnt] = i; // 선택
				DFS(i + 1, cnt + 1); // 다음 재귀
				visit[i] = false; // 선택뒤 미방문(백트래킹)
			}
		}
	}

}
