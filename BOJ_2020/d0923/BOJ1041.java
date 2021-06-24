package d0923;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주사위
// 오버플로우, 언더플로우 발생가능하므로 모든변수 long
public class BOJ1041 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long A, B, C, D, E, F;
		long N = Long.parseLong(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());


		long result = 0;

		if (N == 1) { // N이 1인경우 정육면체경우 한개로 고려, 전체값더해서 최대값 빼기
			result = A + B + C + D + E + F;
			result -= max(A, B, C, D, E, F);
			System.out.println(result);
			return;
		}

		long sum1, sum2, sum3; // 면1,면2,면3개의 값
		sum1 = min(A, B, C, D, E, F);
		sum2 = min(A + B, A + C, A + D, A + E, B + C, B + D, B + F, C + E, C + F, D + E, D + F, E + F); // 2개인접면중 최소값
		sum3 = min(A + B + C, A + B + D, A + D + E, A + C + E, B + C + F, B + D + F, C + E + F, D + E + F); // 3개인접면중
																											// 최소값

		long cnt1, cnt2, cnt3; // 각 블럭줄의 갯수

		cnt1 = (N - 2) * (N - 2); // 면수가1인 최상단 블럭줄
		cnt1 += (N - 2) * (N - 1) * 4; // 이후라인

		cnt2 = (N - 2) * 4; // 면수가2인 최상단 블럭줄
		cnt2 += (N - 1) * 4; // 이후라인

		cnt3 = 4; // 항상4개 고정

//		System.out.println(sum1 + " " + sum2 + " " + sum3);
//		System.out.println(cnt1 + " " + cnt2 + " " + cnt3);
		result = sum1 * cnt1 + sum2 * cnt2 + sum3 * cnt3;
		System.out.println(result);

	}

	public static long max(long... rest) { // 가변인자배열로 max 정의
		long max = rest[0];
		for (long val : rest) {
			max = Math.max(max, val);
		}
		return max;
	}

	public static long min(long... rest) { // 가변인자배열로 min 정의
		long min = rest[0];
		for (long val : rest) {
			min = Math.min(min, val);
		}
		return min;
	}

}
