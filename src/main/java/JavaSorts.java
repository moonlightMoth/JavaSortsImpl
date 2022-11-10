import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JavaSorts {
    public static void main(String[] args) throws Exception {

        int dim = 5;

        int[] v = new int[5];
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int a;

        for (int i = 0; i < dim; i++) {
            a = r.nextInt(15);
            System.out.println(a);
            v[i] = a;
        }

        ShakerSort.sort(v);

        for (int i : v) {
            System.out.println(i);
        }


    }


}
