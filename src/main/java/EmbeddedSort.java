import java.util.Arrays;

public class EmbeddedSort implements Sort {
    public static int[] sort(int[] v)
    {
        Arrays.sort(v);
        return v;
    }

    @Override
    public String toString() {
        return "Embedded sort";
    }
}
