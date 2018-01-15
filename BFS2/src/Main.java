import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static final int MAGIC_NUMBER = 6;
    private static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        while(q-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] graph = new int[n][n];
            int[] parent = new int[n];
            boolean[] visited = new boolean[n];

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                graph[u - 1][v - 1] = MAGIC_NUMBER;
            }

            int s = sc.nextInt();

            int[] goals = new int[n - 1];

            int i = 0;
            int j = 0;

            while (i < n - 1) {
                if (j == s - 1) {
                    j++;
                    continue;
                } else {
                    goals[i] = j;
                    i++;
                    j++;
                }
            }

            for(int k = 0; k < goals.length; k++) {
                queue.add(s - 1);
                System.out.print(shortestReach(graph, n, visited, goals[k]));
                if(k!=goals.length-1)
                    System.out.print(" ");
                resetState(visited);
            }
            System.out.println();
        }
    }

    private static void resetState(boolean[] visited) {
        for(int i = 0; i < visited.length; i++)
            visited[i] = false;

        queue.clear();
    }

    private static int shortestReach(int[][] graph, int n, boolean[] visited, int goal) {
        int counter = 0;

        while(!queue.isEmpty()){
            int currentIndex = queue.remove();
            visited[currentIndex] = true;
            counter++;
            for (int i = 0; i < n; i++) {
                if (graph[currentIndex][i] == MAGIC_NUMBER && !visited[i]){
                    queue.add(i);
                    if(i == goal)
                        return MAGIC_NUMBER * counter;
                }
            }
        }

        return -1;
    }
}
