package d0922;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열
public class BOJ2491 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cur = Integer.parseInt(st.nextToken());
		int plusCnt = 1;
		int minusCnt = 1;
		int plusRst = 1;
		int minusRst = 1;
		for (int i = 1; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (cur <= temp) {
				plusCnt++;
				plusRst = Math.max(plusRst, plusCnt);
			} else {
				plusCnt = 1;
			}
			if (cur >= temp) {
				minusCnt++;
				minusRst = Math.max(minusRst, minusCnt);
			} else {
				minusCnt = 1;
			}

			cur = temp;
		}
		System.out.println(Math.max(minusRst, plusRst));
	}

}
