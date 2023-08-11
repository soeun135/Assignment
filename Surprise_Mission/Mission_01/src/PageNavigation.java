import java.io.*;

public class PageNavigation {
    static class Pager {
        long totalCount; //전체 게시글 수
        long showCount = 10; //한 페이지당 보여지는 글의 수
        long pageSize = 10; //페이지 네비게이션에서 보여주는 블럭 수
        long pageNo = 0; //현재 페이지 번호

        long totalPageCnt = 0; //전체 만들어지는 페이지 수
        long start = 0;
        long end = 0;

        public Pager(long totalCount) {
            this.totalCount = totalCount;
        }
        public void calc() {
            //받은 전체게시글 값을 한 페이지당 보여지는 글의 수로 나눠서 몇 개의 페이지를 만들 것인지
            totalPageCnt = (long)Math.ceil((double)totalCount / (double)showCount);

            //현재 페이지 번호에 따라서 보여줄 페이지 블럭 범위 설정
            start = (pageNo / pageSize) * pageSize + 1;
            if (totalPageCnt <= start + pageSize - 1) {
                end = totalPageCnt;
            } else {
                end = start + pageSize - 1;
            }
        }

        public String html(long pageIndex) {
            this.pageNo = pageIndex;
            calc();
            try {
                File file = new File("C:\\Edu\\Projects\\intellij\\Assignment\\Surprise_Mission\\Mission_01\\src\\page.html");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("<!DOCTYPE html> \n");
                writer.write("<html lang=\"en\"> \n");
                writer.write("<head> \n");
                writer.write("<meta charset=\"UTF-8\"> \n");
                writer.write("<title>Misson01 _02</title> \n");
                writer.write("</head> \n");
                writer.write("<body> \n");
                writer.write("<a href=\"#\">[처음]</a> \n");
                writer.write("<a href=\"#\">[이전]</a> \n\n");
                for (long i = start; i <= end; i++) {
                    if (i == pageIndex) {
                        writer.write("<a href=\"#\" class='on'>"+ i +"</a> \n");
                    } else {
                        writer.write("<a href=\"#\">"+ i +"</a> \n");
                    }
                }
                writer.write("\n");
                writer.write("<a href=\"#\">[다음]</a> \n");
                writer.write("<a href=\"#\">[마지막]</a> \n");
                writer.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Edu\\Projects\\intellij\\Assignment\\Surprise_Mission\\Mission_01\\src\\page.html"));
                while(true) {
                    String line = br.readLine();
                    if (line == null) break;
                    else sb.append(line).append("\n");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }


    }
    public static void main(String[] args) {

        long totalCount = 127;
        long pageIndex = 11;

        Pager pager = new Pager(totalCount);
        System.out.println(pager.html(pageIndex));

    }
}
