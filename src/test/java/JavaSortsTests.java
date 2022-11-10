import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

public class JavaSortsTests {
    @Test
    public void embeddedSortTest() throws Exception
    {
        System.out.println("Proceeding embedded sort...");
        testAbstraction(EmbeddedSort::sort, Exclusion.RANDOM);
    }

    @Test
    public void bubbleSortTest() throws Exception
    {
        System.out.println("Proceeding bubble sort...");
        testAbstraction(BubbleSort::sort, Exclusion.RANDOM);
    }

    @Test
    public void shakerSortTest() throws Exception
    {
        testAbstraction(ShakerSort::sort, Exclusion.RANDOM);
    }



    public void testAbstraction(Function<int[], int[]> func, Exclusion exclude) throws IOException {
        int[] v;

        if (exclude.exclusion == -1)
        {
            testAbstractionRandom(func, 30000);
            return;
        }

        v = getArrayFromFile(Resource.INP10.toString());
        v = func.apply(v);
        Assert.assertArrayEquals(getArrayFromFile(Resource.INP10_SORTED.toString()), v);
        System.out.println("10 element vector passed       [....        ]");

        if (exclude.exclusion == 3) return;

        v = getArrayFromFile(Resource.INP100.toString());
        v = func.apply(v);
        Assert.assertArrayEquals(getArrayFromFile(Resource.INP100_SORTED.toString()), v);
        System.out.println("100 element vector passed      [......      ]");

        if (exclude.exclusion == 2) return;

        v = getArrayFromFile(Resource.INP1000.toString());
        v = func.apply(v);
        Assert.assertArrayEquals(getArrayFromFile(Resource.INP1000_SORTED.toString()), v);
        System.out.println("1000 element vector passed     [........    ]");

        if (exclude.exclusion == 1) return;

        v = getArrayFromFile(Resource.INP1000000.toString());
        v = func.apply(v);
        Assert.assertArrayEquals(getArrayFromFile(Resource.INP1000000_SORTED.toString()), v);
        System.out.println("1000000 element vector passed! [............]");
    }

    private void testAbstractionRandom(Function<int[], int[]> func, int dimension)
    {
        Random random;
        int length;
        int[] v;

        for (int i = 0; i < 10; i++) {
            System.out.println("Test " + (i+1) + " passing...");
            random = new Random();
            length = random.nextInt(dimension);
            v = new int[length];

            for (int j = 0; j < length; j++) {
                v[j] = random.nextInt();
            }

            int[] original = v.clone();
            v = func.apply(v);
            Arrays.sort(original);

            Assert.assertArrayEquals(original, v);
            System.out.println("Test " + (i+1) + " passed.");
        }
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

        private final String resDir = "src" + File.separator + "test" + File.separator + "res" + File.separator;
        private final String path;
        Resource (String res)
        {
            path = resDir + res;
        }

        public String toString()
        {
            return path;
        }
    }

    enum Exclusion
    {
        FORM_FILE_EXCLUDE_LAST (1),
        FROM_FILE_ALL (0),
        RANDOM (-1);

        final int exclusion;
        Exclusion (int exclusion)
        {
            this.exclusion = exclusion;
        }
    }
}
