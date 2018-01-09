import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static final int MAGIC_NUMBER = 6;
    private static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        while(q-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] graph =  new int[n][n];
            int[] parent = new int[n];
            boolean[] visited = new boolean[n];

            for(int i = 0; i < m; i++){
                int u = sc.nextInt();
                int v = sc.nextInt();

                graph[u][v] = MAGIC_NUMBER;
            }

            int s = sc.nextInt();
            queue.add(s-1);

            BFS(graph, n, visited, parent);
        }
    }

    private static void BFS(int[][] graph, int n, boolean[] visited, int[] parent) {
        if(queue.isEmpty()) return;

        int currentIndex = queue.remove();
        visited[currentIndex] = true;

        System.out.println(currentIndex);

        for (int i = 0; i < n; i++) {
            if (graph[currentIndex][i] == MAGIC_NUMBER && !visited[i]){
                queue.add(i);
                parent[i] = currentIndex;
            }
        }

        if(!queue.isEmpty()) return BFS(graph, n, visited, parent);
        return;
    }
}
