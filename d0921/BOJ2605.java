package d0921;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 줄 세우기
public class BOJ2605 {

	public static void main(String[] args) throws IOException {
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		List<Integer> list = new ArrayList<Integer>(N);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken()), i + 1);

		for (int i = N - 1; i >= 0; i--)
			System.out.print(list.get(i) + " ");

	}

}
