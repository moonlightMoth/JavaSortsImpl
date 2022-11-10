public class Util {

    public static void swap (int[] v, int i, int j)
    {
        int t = v[j];
        v[j] = v[i];
        v[i] = t;
    }
}
