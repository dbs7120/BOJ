package d0922;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경비원 ★
public class BOJ2564 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int cnt = Integer.parseInt(br.readLine().trim());
		Point[] dirlen = new Point[cnt + 1];
		for (int i = 0; i < cnt + 1; i++) { // 동근이까지
			st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			dirlen[i] = new Point(dir, len);
		}

		// 동근이 방향, 위치값
		int start = dirlen[cnt].x;
		int length = dirlen[cnt].y;

		int result = 0;
		for (int i = 0; i < cnt; i++) {
			int dir = dirlen[i].x;
			int len = dirlen[i].y;
			switch (start) {
			case 1: // 북동근
				switch (dir) {
				case 1: // 동일선상
					result += Math.abs(length - len);
					break;
				case 2: // 마주보는경우
					result += M + Math.min(length + len, N - length + N - len);
					break;
				case 3: // ┌ 형태
					result += length + len;
					break;
				case 4: // ┐ 형태
					result += N - length + len;
					break;
				}
				break;
			case 2: // 남동근
				switch (dir) {
				case 1: // 마주보는경우
					result += M + Math.min(length + len, N - length + N - len);
					break;
				case 2: // 동일선상
					result += Math.abs(length - len);
					break;
				case 3: // └ 형태
					result += length + M - len;
					break;
				case 4: // ┘ 형태
					result += N - length + M - len;
					break;
				}
				break;

			case 3: // 서동근
				switch (dir) {
				case 1: // ┌ 형태
					result += length + len;
					break;
				case 2: // └ 형태
					result += M - length + len;
					break;
				case 3: // 동일선상
					result += Math.abs(length - len);
					break;
				case 4: // 마주보는경우
					result += N + Math.min(length + len, M - length + M - len);
					break;
				}
				break;
			case 4: // 동동근
				switch (dir) {
				case 1: // ┐ 형태
					result += length + N - len;
					break;
				case 2: // ┘ 형태
					result += M - length + N - len;
					break;
				case 3: // 마주보는경우
					result += N + Math.min(length + len, M - length + M - len);
					break;
				case 4: // 동일선상
					result += Math.abs(length - len);
					break;
				}
				break;
			}
		}
		System.out.println(result);

	}

}
