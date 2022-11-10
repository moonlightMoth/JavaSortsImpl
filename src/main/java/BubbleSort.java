public class BubbleSort implements Sort {

    public static int[] sort(int[] v)
    {
        for (int i = 0; i < v.length-1; i++) {
            for (int j = 0; j < v.length-1; j++) {
                if (v[j] > v[j + 1])
                    Util.swap(v, j, j + 1);
            }
        }


        return v;
    }

    @Override
    public String toString() {
        return "Bubble sort";
    }
}
