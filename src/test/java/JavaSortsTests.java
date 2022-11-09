import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class JavaSortsTests {
    @Test
    public void embeddedSortTest() throws Exception
    {

        EmbeddedSort embeddedSort = new EmbeddedSort();
        int[] v;

        v = getArrayFromFile(Resource.INP10.toString());
        embeddedSort.sort(v);
        Assert.assertArrayEquals(getArrayFromFile(Resource.INP10_SORTED.toString()), v);

        v = getArrayFromFile(Resource.INP100.toString());
        embeddedSort.sort(v);
        Assert.assertArrayEquals(getArrayFromFile(Resource.INP100_SORTED.toString()), v);

        v = getArrayFromFile(Resource.INP1000.toString());
        embeddedSort.sort(v);
        Assert.assertArrayEquals(getArrayFromFile(Resource.INP1000_SORTED.toString()), v);

        v = getArrayFromFile(Resource.INP1000000.toString());
        embeddedSort.sort(v);
        Assert.assertArrayEquals(getArrayFromFile(Resource.INP1000000_SORTED.toString()), v);
    }


    public static int[] getArrayFromFile(String file) throws IOException {

        Scanner s = new Scanner(new FileReader(file));

        Integer.parseInt(s.nextLine());

        String string = s.nextLine();

        Integer[] v = Arrays.stream(string.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        return  Arrays.stream(v).mapToInt(Integer::intValue).toArray();

    }

    enum Resource
    {

        INP10 ("input10.txt"),
        INP100 ("input100.txt"),
        INP1000 ("input1000.txt"),
        INP1000000 ("input1000000.txt"),
        INP10_SORTED ("input10_sorted.txt"),
        INP100_SORTED ("input100_sorted.txt"),
        INP1000_SORTED ("input1000_sorted.txt"),
        INP1000000_SORTED ("input1000000_sorted.txt");

        private String resDir = "src" + File.separator + "test" + File.separator + "res" + File.separator;
        String path;
        Resource (String res)
        {
            path = resDir + res;
        }

        public String toString()
        {
            return path;
        }
    }
}
