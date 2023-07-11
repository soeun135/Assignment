import java.util.ArrayList;
import java.util.Scanner;

public class JavaStudy08 {
    //세율계산 메소드
    public static int rateCal(double rate,int income){
        return (int)(rate * income);
    }
    public static int[] saveArr(int tempIncome,double rate,int taxPrice){
        int result[] = new int[3];
        result[0] = tempIncome;
        result[1] = (int)(rate*100);
        result[2] = taxPrice;

        return result;
    }
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");

        int income = scanner.nextInt();
        int income2 = income;
        int tempIncome = income;
        int taxStandard[] = {12000000,46000000,88000000,150000000,300000000,500000000,1000000000};
        double taxRate[] = {0.15,0.24,0.35,0.38,0.40,0.42,0.45};
        int totalStandard[] = {1080000,5220000,14900000,19400000,25400000,35400000,65400000};
        int taxResult1 = 0;
        int taxResult2 = 0;

        ArrayList <int[]> list = new ArrayList<>();

        //세금이용한 세율계산
        for(int i = taxStandard.length-1; i >= 0; i--){
            if(income > taxStandard[i]){
                tempIncome = income - taxStandard[i];
                income -= tempIncome;
                taxResult1 += rateCal(taxRate[i],tempIncome);
                list.add(0,saveArr(tempIncome,taxRate[i],rateCal(taxRate[i],tempIncome)));
            }
        }
        //1200만원 이하 세율계산
        taxResult1 += rateCal(0.06, taxStandard[0]);
        list.add(0,saveArr(taxStandard[0],0.06,rateCal(0.06, taxStandard[0])));

        //누진공제 이용한 세율계산
        for (int i = 0; i < taxStandard.length; i++) {
            if(income2 > taxStandard[i]){
                taxResult2 = Math.round(rateCal(taxRate[i],income2)*10)/10 - totalStandard[i];
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%10d * %2d%% = %10d",list.get(i)[0],list.get(i)[1],list.get(i)[2]);
            System.out.println();
        }
        System.out.println();
        System.out.printf("%-19s \t\t%10d\n","[세율에 의한 세금]:",taxResult1);
        System.out.printf("%-19s  \t%10d\n","[누진공제 계산에 의한 세금]:",taxResult2);

        scanner.close();
    }
}