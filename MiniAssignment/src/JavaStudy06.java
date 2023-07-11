import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class JavaStudy06 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("총 진행할 투표수를 입력해 주세요.");
        int voteCount = scanner.nextInt();
        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요.");
        int applicant = scanner.nextInt();

        String name[] = new String[applicant];
        HashMap<Integer,String[]> map = new HashMap<>();

        for(int i = 0;i < applicant ; i++){
            System.out.print((i+1)+"번째 후보자이름을 입력해 주세요.");
            String namee = scanner.next();
            String arr[] = new String[2];
            name[i] = namee;
            arr[0] = namee;
            arr[1] = "0";
            map.put((i+1),arr);
            //map에 key값으로 기호번호 부여, value로는 이름과 투표수(0으로 기본 초기화)
        }
        for (int i = 1; i <= voteCount ; i++) {
            int random = (int)(Math.random() * applicant) + 1;
            String array[] = map.get(random); // map의 value값 이름, 투표수를 가져옴.
            array[1] = Integer.toString(Integer.parseInt(array[1])+1);
            map.put(random,array);
            System.out.println();

            System.out.printf("[투표진행률]: %.2f%%, %d명 투표 => %s\n",(float)i/voteCount*100,i,name[random-1]);
            float rate = 0.0f;
            int cntVote = 0;
            for (int j = 0; j < applicant; j++) {
                if(map.get(j+1)[1].equals("0")){
                    rate = 0.0f;
                    cntVote = 0;
                }
                else{
                    rate = (float)i/voteCount*100*Integer.parseInt(map.get(j+1)[1])/i;
                    cntVote = Integer.parseInt(map.get(j+1)[1]);
                }
                String nameStr = map.get(j+1)[0] + ":";
                System.out.printf("[기호:%d] %-10s\t%.2f%%\t(투표수: %d)\n",j+1,nameStr,rate,cntVote);
            }
            System.out.println();
        }

        //투표수 제일 많은 사람 찾기
        String winPerson = "";
        int max = 0;
        for (int i = 0; i < map.size(); i++) {
            int temp = Integer.parseInt(map.get(i+1)[1]);
            if( temp > max){
                max = temp;
                winPerson = map.get(i+1)[0];
            }
        }
        System.out.println("[투표결과] 당선인 : "+winPerson);
        scanner.close();
    }
}