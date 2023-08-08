import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BinaryTree{
    static int N;
    static ArrayList <Integer>[] list;
    static int []parentsArr;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parentsArr = new int[N + 1];

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N ; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        bfs(1);
        for (int i = 0; i <= N ; i++) {
            System.out.println(parentsArr[i]);
        }
    }
    public static void bfs(int n) {
        Queue <Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[N + 1];
        visited[n] = true;
        q.offer(n);

        while (!q.isEmpty()) {
            int parent = q.poll();
            for (int i : list[parent]) {
                if (visited[i]) {
                    continue;
                }
                parentsArr[i] = parent;
                visited[i] = true;
                q.add(i);
            }
        }
    }
}
