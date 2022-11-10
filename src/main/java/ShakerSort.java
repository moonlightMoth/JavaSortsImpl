public class ShakerSort implements Sort {

    public static int[] sort(int[] v)
    {
        int l = 0;
        int r = v.length-1;

        while (l <= r)
        {
            for (int i = l; i < r; i++) {
                if (v[i] > v[i+1])
                {
                    Util.swap(v, i, i+1);
                }
            }
            r--;
            for (int i = r; i > l; i--) {
                if (v[i-1] > v[i])
                {
                    Util.swap(v, i-1, i);
                }
            }
            l++;
        }
        return v;
    }
}
