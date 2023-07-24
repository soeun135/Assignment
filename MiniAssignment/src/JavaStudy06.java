import java.util.*;

public class JavaStudy06 {
    public static void main(String[] args){

        List<후보자> 후보자들 = new ArrayList<>();
        후보자들.add(new 후보자(1, "이재명"));
        후보자들.add(new 후보자(2, "윤석렬"));
        후보자들.add(new 후보자(3, "안철수"));
        후보자들.add(new 후보자(4, "심상정"));

        int voteCount = 100;

        int min = 0;
        int max = 3;
        Random random = new Random();
        int i = 0;
        for (i = 1; i <= voteCount ; i++) {
            int vote = random.nextInt(max - min + 1) + min;

            후보자들.get(vote).addVote();

            System.out.printf("[투표진행률]: %.2f%%, %d명 투표 => %s\n",(float)i/voteCount*100,i,후보자들.get(vote).getName());
            for (후보자 x : 후보자들) {
                x.setTotalVoteCount(i);
                String msg = x.getDisplayInfo();
                System.out.println(msg);
            }
            System.out.println();
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("총 진행할 투표수를 입력해 주세요.");
       // int voteCount = scanner.nextInt();
        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요.");
        int applicant = scanner.nextInt();


        //System.out.println("[투표결과] 당선인 : "+winPerson);
        scanner.close();
    }
}