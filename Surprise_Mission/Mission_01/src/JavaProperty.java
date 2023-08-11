import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JavaProperty {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Edu\\Projects\\intellij\\Assignment\\Surprise_Mission\\Mission_01\\index.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("<!DOCTYPE html> \n");
            writer.write("<html lang=\"en\"> \n");
            writer.write("<head> \n");
            writer.write("<meta charset=\"UTF-8\"> \n");
            writer.write("<title>Misson01 _01</title> \n");
            writer.write("<style> \n");
            writer.write("table { border-collapse: collapse; width 100%; } \n");
            writer.write("th, td { border:solid 1px #000; } \n");
            writer.write("</style> \n");
            writer.write("</head> \n");
            writer.write("<body> \n");
            writer.write("<h1>자바 환경정보</h1> \n");
            writer.write("<table> \n");
            writer.write("<thead> \n");
            writer.write("<tr> \n");
            writer.write("<th>키</th> \n");
            writer.write("<th>값</th> \n");
            writer.write("</tr> \n");
            writer.write("</thead> \n");

            writer.write("<tbody> \n");
            for (Object k : System.getProperties().keySet()) {
                String key = k.toString();
                String value = System.getProperty(key);

                writer.write("<tr> \n");
                writer.write("<td>"+key+"</td> \n");
                writer.write("<td>"+value+"</td> \n");
                writer.write("</tr> \n");

            }
            writer.write("</tbody> \n");
            writer.write("</table> \n");
            writer.write("</body> \n");
            writer.write("</html> \n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
