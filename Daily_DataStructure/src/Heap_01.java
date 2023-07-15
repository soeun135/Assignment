import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Heap_01 {
    public static void heapify(int A[],int k,int n) {
        int left = 2 * k;
        int right = 2 * k + 1;
        int smaller = 0;
        if (right < n) {
            if (A[left] < A[right]) {
                smaller = left;
            }
            else{
                smaller = right;
            }
        }
        else if (left <= n) {
            smaller = left;
        }
        else return;

    //최소 힙 성질을 만족하지 못하는 경우 재귀적으로 수정한다.
        if (A[smaller] < A[k]) {
            int temp = A[smaller];
            A[smaller] = A[k];
            A[k] = temp;
            heapify(A, smaller, n);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        heapify(A,K,N);
        for(int i : A){
            System.out.print(i+" ");
        }
    }
}
