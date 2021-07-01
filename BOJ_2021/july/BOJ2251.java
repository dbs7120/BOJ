package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2021-07-02
// 물통
/**
 * BFS 6종류(A->B, A->C, B->C, B->A, C->A, C->B)에 대해 큐 삽입
 */
public class BOJ2251 {
	static int A, B, C;

	static class Box {
		int waterA, waterB, waterC;

		public Box(int waterA, int waterB, int waterC) {
			this.waterA = waterA;
			this.waterB = waterB;
			this.waterC = waterC;
		}

	}

	static boolean[] result;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		result = new boolean[C + 1];
		visited = new boolean[A + 1][B + 1][C + 1];

		BFS();

		for (int i = 0; i < result.length; i++)
			if (result[i])
				bw.append(i + " ");

		bw.append("\n");
		bw.flush();
		bw.close();
		br.close();

	}

	private static void BFS() {
		Queue<Box> q = new LinkedList<Box>();
		q.offer(new Box(0, 0, C));
		result[C] = true;
		visited[0][0][C] = true;

		while (!q.isEmpty()) {
			Box cur = q.poll();
			int AA = cur.waterA;
			int BB = cur.waterB;
			int CC = cur.waterC;

			int na, nb, nc;
			na = nb = nc = 0;

			if (AA == 0)
				result[CC] = true;

			// A->B
			na = 0;
			nb = BB + AA;
			nc = CC;
			if (nb > B) {
				na = nb - B;
				nb = B;
			}
			if (!visited[na][nb][nc]) {
				visited[na][nb][nc] = true;
				q.offer(new Box(na, nb, nc));
			}

			// A->C
			na = 0;
			nb = BB;
			nc = CC + AA;
			if (nc > C) {
				na = nc - C;
				nc = C;
			}
			if (!visited[na][nb][nc]) {
				visited[na][nb][nc] = true;
				q.offer(new Box(na, nb, nc));
			}

			// B->A
			na = AA + BB;
			nb = 0;
			nc = CC;
			if (na > A) {
				nb = na - A;
				na = A;
			}
			if (!visited[na][nb][nc]) {
				visited[na][nb][nc] = true;
				q.offer(new Box(na, nb, nc));
			}

			// B->C
			na = AA;
			nb = 0;
			nc = CC + BB;
			if (nc > C) {
				nb = nb - C;
				nc = C;
			}
			if (!visited[na][nb][nc]) {
				visited[na][nb][nc] = true;
				q.offer(new Box(na, nb, nc));
			}

			// C->A
			na = AA + CC;
			nb = BB;
			nc = 0;
			if (na > A) {
				nc = na - A;
				na = A;
			}
			if (!visited[na][nb][nc]) {
				visited[na][nb][nc] = true;
				q.offer(new Box(na, nb, nc));
			}

			// C->B
			na = AA;
			nb = BB + CC;
			nc = 0;
			if (nb > B) {
				nc = nb - B;
				nb = B;
			}
			if (!visited[na][nb][nc]) {
				visited[na][nb][nc] = true;
				q.offer(new Box(na, nb, nc));
			}

		}

	}

}
