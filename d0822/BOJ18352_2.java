package d0822;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 특정 거리의 도시 찾기
public class BOJ18352_2 {

	static int N, M, K, X;

	static ArrayList<Integer>[] map;
	static int[] distance; // 거리를 통한 방문체크

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 도시
		M = sc.nextInt(); // 도로
		K = sc.nextInt(); // 거리정보
		X = sc.nextInt(); // 출발
		map = new ArrayList[N + 1];
		distance = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			map[i] = new ArrayList<Integer>();
			distance[i] = -1;
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			map[from].add(to);
		}

		BFS(X);

		boolean check = false;
		for (int i = 1; i < N + 1; i++) {
			if (distance[i] == K) {
				System.out.println(i);
				check = true;
			}
		}
		if (!check)
			System.out.println(-1);

		sc.close();
	}

	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		distance[start] = 0;
		q.offer(start);

		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int idx : map[temp]) {
				if (distance[idx] == -1) {
					distance[idx] = distance[temp] + 1;
					q.offer(idx);
				}
			}
		}
	}
}