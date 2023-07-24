//박소은
import java.util.*;

public class JavaStudy07 {
    //중복 없는 랜덤 로또번호 생성후 정렬해 줄 메소드
    public static LinkedList randomNum(int cnt){
        HashSet <Integer>set = new HashSet();//랜덤한 로또 번호를 중복없이 저장해 줄 자료구조

        for (int j = 0; set.size() < 6; j++) {
            while(true){
                int rand = (int)(Math.random()*45)+1 ;
                if(!set.contains(rand)){
                    set.add(rand);
                    break;
                }
            }
        }
        LinkedList list = new LinkedList(set); //정렬을 위해 list에 담아줌
        Collections.sort(list); //Collections.sort로 정렬

        return list;
    }

    //로또 값 출력해 줄 메소드
    public static void numPrint(LinkedList list){
        for (int j = 0; j < list.size(); j++) {
            System.out.printf("%02d",list.get(j));
            if(j!=5) System.out.print(",");
        }
    }
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[로또 당첨 프로그램]\n");

        //로또 개수 입력
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int lottoCount = scanner.nextInt();

        int LOTTO_COUNT = 6;
        int[][] userLotto = new int[lottoCount][LOTTO_COUNT];
        int[] userLottoCount = new int[lottoCount];
        int[] winLotto = {0,0,0,0,0,0};

        Integer[] arrNo = { 1,2,3,4,5,6,7,8,9,10,
                11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,
                34,3,5,36,37,38,39,40,41,42,43,44,45};

        Random random = new Random();

        for (int i = 0; i < lottoCount; i++) {
            ArrayList <Integer> noList = new ArrayList<>(Arrays.asList(arrNo));
            for (int j = 0; j < LOTTO_COUNT; j++) {
                int min = 0;
                int max = noList.size();
                int index = random.nextInt(max) + min;

                int no = noList.get(index);
                userLotto[i][j] = no;
                noList.remove(index);
            }
        }
        //정렬
        for (int i = 0; i < lottoCount; i++) {
            Arrays.sort(userLotto[i]);
        }

        //구매로또 출력
        for (int i = 0; i < lottoCount; i++) {
            System.out.print((char)(i + 65)+"\t");

            for (int j = 0; j < LOTTO_COUNT; j++) {
                if(j > 0){
                    System.out.print(", ");
                }
                System.out.print(String.format("%02d",userLotto[i][j]));
            } System.out.println();
        }
        System.out.println("[로또 발표]");
        System.out.print("\t");
        ArrayList <Integer> noList = new ArrayList<>(Arrays.asList(arrNo));
        for (int j = 0; j < LOTTO_COUNT; j++) {
            int min = 0;
            int max = noList.size();
            int index = random.nextInt(max) + min;

            int no = noList.get(index);
            winLotto[j] = no;

            noList.remove(index);
        }

        //로또 발표 정렬
        Arrays.sort(winLotto);

        for (int j = 0; j < LOTTO_COUNT; j++) {
            if(j > 0){
                System.out.print(", ");
            }
            System.out.print(String.format("%02d",winLotto[j]));
        } System.out.println("\n");

        //당첨확인
        System.out.println("[내 로또 결과]");
        for (int i = 0; i < lottoCount; i++) {
            int cnt = 0;
            System.out.print((char)(i + 65)+"\t");
            for (int j = 0; j < LOTTO_COUNT; j++) {
                for (int k = 0; k < LOTTO_COUNT; k++) {
                    if(userLotto[i][j] == winLotto[k]){
                        cnt ++;
                        break;
                    }
                }
            }
            for (int j = 0; j < LOTTO_COUNT; j++) {
                    if(j > 0){
                        System.out.print(", ");
                    }
                    System.out.print(String.format("%02d",userLotto[i][j]));
            } System.out.println(" => "+cnt+"개 일치");
        }
    }
}