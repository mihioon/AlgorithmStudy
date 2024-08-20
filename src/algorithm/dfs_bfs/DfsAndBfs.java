package algorithm.dfs_bfs;

import java.util.*;

public class DfsAndBfs {
    public static class Node{
        int data;
        List<Node> adjacents;

        public Node(int data) {
            this.data = data;
            this.adjacents = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //정점의 개수
        int m = sc.nextInt(); //간선의 개수
        int v = sc.nextInt(); //탐색을 시작할 정점의 번호

        // 정점 개수만큼 리스트 생성
        List<Node> graphs = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graphs.add(new Node(i));
        }

        // 인접노드 연결
        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graphs.get(node1).adjacents.add(graphs.get(node2));
            graphs.get(node2).adjacents.add(graphs.get(node1));
        }

        // DFS 수행
        boolean[] visitedDFS = new boolean[n + 1];
        dfs(graphs.get(v), visitedDFS);

        System.out.println("");

        // BFS 수행
        boolean[] visitedBFS = new boolean[n + 1];
        bfs(graphs, v, visitedBFS);
    }

    // DFS 구현
    public static void dfs(Node node, boolean[] visited) {
        visited[node.data] = true;
        System.out.print(node.data + " ");

        for (Node adj : node.adjacents) {
            if (!visited[adj.data]) {
                dfs(adj, visited);
            }
        }
    }

    // BFS 구현
    public static void bfs(List<Node> graphs, int start, boolean[] visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(graphs.get(start));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");

            for (Node adj : node.adjacents) {
                if (!visited[adj.data]) {
                    visited[adj.data] = true;
                    queue.offer(adj);
                }
            }
        }
    }

}
