package d0923;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 수 이어가기
public class BOJ2635 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		int max = 1;

		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		list.add(N);
		for (int i = 1; i <= N; i++) {
			list.add(i);
			for (int j = 1; j < list.size(); j++) {

				if (list.get(j - 1) - list.get(j) >= 0) {
					list.add(list.get(j - 1) - list.get(j));
				} else {
					if (max < list.size()) {
						max = list.size();
						result = list;
					}

					list = new ArrayList<Integer>();
					list.add(N);
					break;
				}

			}

		}
		System.out.println(max);
		for (int e : result) {
			System.out.print(e + " ");
		}

	}

}
