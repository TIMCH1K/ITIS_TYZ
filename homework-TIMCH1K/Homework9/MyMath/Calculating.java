
public class Calculating {

    public static double abs(double a) {
        double x = a;
        if (x < 0) {
            x = x * -1;
        }
        return x;

    }

    public static float abs(float a) {
        float x = a;
        if (x < 0) {
            x = x * -1;
        }
        return x;

    }

    public static int abs(int a) {
        int x = a;
        if (x < 0) {
            x = x * -1;
        }
        return x;

    }

    public static long abs(long a) {
        long x = a;
        if (x < 0) {
            x = x * -1;
        }
        return x;
    }

    public static MinMax max(double[] nums) {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];

            }
        }
        return new MinMax(min, max);

    }
}
