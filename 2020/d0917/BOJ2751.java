package d0917;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 수정렬하기2 (합병정렬)
public class BOJ2751 {

	static int N;
	static int[] arr;
	static int tmp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		tmp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		divide(0, N - 1);

		for (int e : arr) {
			bw.write(e + "\n");
		}
		bw.flush();
		bw.close();

	}

	public static void divide(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			divide(left, mid);
			divide(mid + 1, right);
			merge(left, mid, right);

		}
	}

	public static void merge(int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = left;

		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
				tmp[k++] = arr[i++];
			} else {
				tmp[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			tmp[k++] = arr[i++];
		}
		while (j <= right) {
			tmp[k++] = arr[j++];
		}

		for (int idx = left; idx < k; idx++) {
			arr[idx] = tmp[idx];
		}
	}

}
