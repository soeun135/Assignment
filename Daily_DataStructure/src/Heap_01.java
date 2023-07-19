import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Heap_01 {
    static int count = 0;
    static int K = 0;
    public static void swap(int A[], int a, int b){
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
        count ++;

        if(K == count){
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < A.length; i++) {
                sb.append(A[i]).append(" ");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }
    }
    public static void heapSort(int A[]){
        int n = A.length - 1;
        buildMinHeap(A, n);
        for (int i = n; i >= 2 ; i--) {
            swap(A, 1, i);
            heapify(A, 1, i-1);
        }
    }
    public static void buildMinHeap(int A[],int n){
        for (int i = n / 2; i >= 1 ; i--) {
            heapify(A, i, n);
        }
    }
    public static void heapify(int []A,int k,int n) {
        int left = 2 * k;
        int right = 2 * k + 1;
        int smaller = -1;

        if (right <= n) {
            smaller = A[left] < A[right] ? left : right;
        } else if (left <= n) {
            smaller = left;
        } else return;


        if (A[smaller] < A[k]) {
            swap(A, smaller, k);
            heapify(A, smaller, n);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int A[] = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
           A[i] = Integer.parseInt(st.nextToken());
        }
        heapSort(A);
        System.out.println(-1);
    }
}
