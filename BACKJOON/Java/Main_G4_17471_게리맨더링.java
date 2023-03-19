import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

//G4_17471_게리맨더링
public class Main_G4_17471_게리맨더링 {
	
	static int N; // 구역의 개수
	static List<Edge>[] list;
	static int[] parents;
	static int[] populations;
	static int min;
	
	static int[] select;
	static boolean[] isSelected;
	
	static class Edge {
		int from;
		int to;
		
		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine()); // 구역의 개수
		populations = new int[N + 1]; // 구역이 1번부터 시작됨
		min = Integer.MAX_VALUE;
		
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) { // 각 구역의 인구 수 입력 받기
			populations[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList[N + 1];
		list[0] = new ArrayList<>();
		list[0].add(new Edge(0, 0));
		
		for (int i = 1; i <= N; i++) { // 각 구역과 인접한 구역의 정보
			st = new StringTokenizer(in.readLine());
			int E = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
			for (int j = 0; j < E; j++) {
				int to = Integer.parseInt(st.nextToken());
				list[i].add(new Edge(i, to));
			}
		}
		
		select = new int[N + 1];
		isSelected = new boolean[N + 1];
		
		subset(0);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	private static void subset(int idx) {
		if (idx == N) {
			List<Integer> group1 = new ArrayList<>();
			List<Integer> group2 = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (isSelected[i]) {
					group1.add(i);
				} else {
					group2.add(i);
				}
			}
			
			if (group1.size() == 0 || group2.size() == 0) {
				return;
			}

			makeSet();

			for (int i = 0; i < group1.size(); i++) {
				int index = group1.get(i);
				for (int j = 0; j < list[index].size(); j++) {
					for (int k = 0; k < group1.size(); k++) {
						if (list[index].get(j).to == group1.get(k)) {
							union(group1.get(i), list[index].get(j).to);
						}
					}
				}
			}
			
			for (int i = 0; i < group2.size(); i++) {
				int index = group2.get(i);
				for (int j = 0; j < list[index].size(); j++) {
					for (int k = 0; k < group2.size(); k++) {
						if (list[index].get(j).to == group2.get(k)) {
							union(group2.get(i), list[index].get(j).to);
						}
					}
				}
			}
			
			Set<Integer> s = new HashSet<>();
			for (int i = 1; i < parents.length; i++) {
				s.add(findSet(parents[i]));
			}

			int sum1 = 0;
			int sum2 = 0;
			if (s.size() == 2) {
				for (int i = 0; i < group1.size(); i++) {
					sum1 += populations[group1.get(i)];
				}
				for (int i = 0; i < group2.size(); i++) {
					sum2 += populations[group2.get(i)];
				}
				min = Math.min(min, Math.abs(sum1 - sum2));
			}
			
			return;
		}
		
		isSelected[idx] = true;
		subset(idx + 1);
		
		isSelected[idx] = false;
		subset(idx + 1);
	}

	static void makeSet() {
		parents = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if (a == parents[a]) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	
}