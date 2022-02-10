import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4_이선민_302ms {
	// 4방탐색 (우, 하, 좌, 상 순서)
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] arr;
	static int temp_cnt, temp_index, cnt, index;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

//		개선방안
//		★1. 각 숫자의 1차원 배열에 그 숫자의 좌표 넣어서 계산하기
//		2. 2차원 배열일때 이미 확인한 좌표라면 스킵하기 -> 이미 확인한 좌표인지를 또 계산해야함


		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 방의 한변길이
			arr = new int[N + 2][N + 2]; // 겉을 0으로 감싸 배열밖을 탐색하는 것을 예방함
			for (int j = 1; j <= N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= N; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 1; // 이동할 수 있는 방의 개수
			index = N + 1; // 처음 출발해야 하는 방의 번호
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					temp_cnt = 1;
					temp_index = arr[i][j];
					search(i, j);

					if (temp_cnt > cnt) {
						cnt = temp_cnt;
						index = temp_index;
					} else if(temp_cnt==cnt && temp_index<index) {
						index = temp_index;
					}
				}
			}

			sb.append("#").append(test_case).append(" ").append(index).append(" ").append(cnt).append("\n");

		} // end of testcase

		System.out.print(sb);
	} // end of main

	/**
	 * 4방탐색
	 */
	public static void search(int i, int j) {
		int r, c;
		for (int k = 0; k < 4; k++) {
			r = i + dr[k];
			c = j + dc[k];

			if (arr[r][c] != (arr[i][j] + 1)) { // 탐색한 칸이 조건을 만족하지 않는다면
				continue;
			}

			// 조건을 만족한다면
			temp_cnt++;
			search(r, c);
		}

	} // end of search

} // end of class
