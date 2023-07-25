import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int data;
    Node parent;
    Node left;
    Node right;

    public Node(int data, Node left, Node right, Node parent) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}
class BinaryTree{
    Node head;

    public BinaryTree(){}
    public BinaryTree(int[] arr) {
        Node[] nodes = new Node[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i], null, null, null);
        }
        this.head = nodes[0];
    }

    public Node searchNode(int data) { //data로 들어온 값을 가진 노드를 찾아줌
        Queue<Node> q = new LinkedList();
        q.add(this.head);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.data == data) {
                return cur;
            }
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        return null;
    }
    public void addNode(int data, int parent) {//부모노드의 왼쪽 or 오른쪽에 자식노드 추가
       Node cur = this.searchNode(parent);

       if(cur.left == null){
           cur.left = new Node(data, null, null, cur);
       } else{
           cur.right = new Node(data, null, null, cur);
       }
    }

    public int parentNode(int data){ //입력값의 부모노드를 찾아주는 메소드
        Node cur = this.searchNode(data);
        return cur.parent.data;
    }
}
public class Tree_05 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList <ArrayList> list = new ArrayList<>();
        int arr[] = new int[N];
        StringTokenizer st;
        for (int i = 1; i <= N ; i++) {
            arr[i-1] = i;
        }
        for(int i = 0; i < N - 1 ; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList <Integer> peek = new ArrayList<>();
            peek.add(Integer.parseInt(st.nextToken()));
            peek.add(Integer.parseInt(st.nextToken()));
            list.add(peek);
        }//peek에 입력한 각각 한 줄씩의 값이 저장되고
        //list에 최종 저장

        BinaryTree bt = new BinaryTree(arr);
        Queue <Node> q = new LinkedList<>();
        boolean []visited = new boolean[N-1]; //방문한 리스트 요소를 체크해줄 배열
        q.add(bt.head);

        while(!q.isEmpty()){
            Node cur = q.poll();
            for (int j = 0; j < list.size(); j++) {
                if(list.get(j).contains(cur.data) && !visited[j]){
                    //리스트 한 줄에 현재 노드의 값이 포함되어있고 그 리스트를 방문하지 않았다면
                    for (int i = 0; i < 2; i++) {
                        int num = (int)list.get(j).get(i);
                        if(num != cur.data){ //현재 노드 값이 아닌 다른 값 찾기
                            bt.addNode(num,cur.data); //찾아서 현재노드(부모노드)의 자식노드로 추가
                            q.add(bt.searchNode(num)); // 방금 만들어진 노드를 q에 추가
                            visited[j] = true; //해당 리스트를 방문했다는 flag
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 2; i <= N ; i++) {
            System.out.println(bt.parentNode(i));
        }
    }
}
