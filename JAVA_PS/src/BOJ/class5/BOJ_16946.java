package BOJ.class5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_16946 {
	static int[][] arr,group;
	static int n;
	static int m;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Map<Integer, Integer> groupSize;

	// 벽에 맞닿은 그룹의 합을 구함
	static int count(int x, int y) {
		int cnt = 1;
		if (arr[x][y] == 0)
			return 0;
		Set<Integer> set = new HashSet<>();

		// 벽에 맞닿은 4방향만 구하면됨
		// 그 방향의 그룹의 0의 갯수 정보는 이미 구했기 때문
		for (int i = 0; i < 4; i++) {
			int sx = x + dx[i];
			int sy = y + dy[i];

			if (sx < 0 || sy < 0 || sx >= n || sy >= m || group[sx][sy] == 0)
				continue;
			set.add(group[sx][sy]);

		}
		for (int size : set) {
			cnt += groupSize.get(size);
		}

		return cnt % 10;
	}

	// 그룹마다 몇개의 0이 포함되었는지를 리턴해줌
	static int bfs(int x, int y, int groupCnt) {
		int cnt = 1;
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(x, y));
		group[x][y] = groupCnt;
		while (!q.isEmpty()) {
			pair point = q.poll();
			for (int i = 0; i < 4; i++) {
				int sx = point.x + dx[i];
				int sy = point.y + dy[i];

				if (sx < 0 || sy < 0 || sx >= n || sy >= m)
					continue;
				// 아직 그룹에 속하지 않았고 && 벽이 아니라면 카운트해준다.
				if (group[sx][sy] == 0 && arr[sx][sy] == 0) {
					group[sx][sy] = groupCnt;
					cnt++;
					q.add(new pair(sx, sy));
				}
			}
		}
		return cnt;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());

		arr = new int[n][m];
		group = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				arr[i][j] = stoi(str[j]);
			}
		}

		int groupCnt = 1;
		groupSize = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 && group[i][j] == 0) {
					groupSize.put(groupCnt, bfs(i, j, groupCnt));
					groupCnt++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (group[i][j] == 0) {
					sb.append(count(i, j) + "");
					continue;
				}
				sb.append(0 + "");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}

}

class pair {
	int x;
	int y;

	pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}