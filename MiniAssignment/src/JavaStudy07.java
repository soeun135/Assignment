//박소은
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class JavaStudy07 {
    //중복 없는 랜덤 로또번호 생성후 정렬해 줄 메소드
    public static LinkedList randomNum(int cnt){
        HashSet set = new HashSet();//랜덤한 로또 번호를 중복없이 저장해 줄 자료구조

        for (int j = 0; set.size() < 6; j++) {
            set.add((int)(Math.random()*45)+1); //로또 번호 랜덤 생성
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
        int cnt = scanner.nextInt();
        LinkedList arr[] = new LinkedList[cnt]; //set으로 받은 로또 한 개의 6개 번호가 정렬되어 들어갈 배열

        for(int i=0;i<cnt;i++){
            System.out.print((char)(i+65)+"\t");
            LinkedList list = randomNum(cnt);
            arr[i] = list; //추후에 또 쓰이므로 ArrayList형의 배열 arr에 번호 6개 세트 하나씩 저장

            numPrint(list);

            System.out.println();
        }
        System.out.println();

        //당첨 번호 생성
        System.out.println("[로또 발표]");
        LinkedList list1 = randomNum(cnt);

        System.out.print("\t");

        numPrint(list1);

        System.out.println("\n");

        //당첨확인
        System.out.println("[내 로또 결과]");
        for (int i = 0; i < cnt; i++) { //로또 갯수만큼 당첨 확인 반복
            int winCount = 0;
            System.out.print((char)(i+65)+"\t");

            numPrint(arr[i]);

            for (int j = 0; j < 6; j++) {
                if(arr[i].contains(list1.get(j))) winCount ++;
            }
            System.out.println(" => "+winCount+"개 일치");
        }
    }
}