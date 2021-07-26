package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-07-26
// 달팽이는 올라가고 싶다
public class BOJ2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int result;

		if ((V - A) % (A - B) == 0)
			result = (V - A) / (A - B);
		else
			result = (V - A) / (A - B) + 1;

		bw.append((result + 1) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}
