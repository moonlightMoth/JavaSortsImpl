import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JavaSorts {
    public static void main(String[] args) throws Exception {

        int dim = 1000000;

        Scanner s = new Scanner(new FileReader("input"+ dim  +".txt"));

        Integer.parseInt(s.nextLine());

        String string = s.nextLine();

        Integer[] v = Arrays.stream(string.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        Arrays.sort(v, Integer::compare);

        FileWriter fw = new FileWriter("input" + dim + "_sorted.txt", Charset.defaultCharset());
        Random r = new Random();

        fw.append(String.valueOf(dim)).append("\n");

        for (int i = 0; i < dim; i++) {
            fw.append(v[i].toString());
            fw.append(" ");
        }

        fw.flush();
        fw.close();
    }


}
