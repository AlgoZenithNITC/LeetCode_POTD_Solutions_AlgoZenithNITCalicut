public class MaxDiffCalculator {

    public static int maxDiff(int num) {
        int mult = 1;
        while (num % mult == 0)
            mult *= 10;
        mult /= 10;

        int rev = 0;
        int copy = num;
        while (copy > 0) {
            rev = rev * 10 + copy % 10;
            copy /= 10;
        }

        // max_num
        int max = 0;
        copy = rev;
        int prevRep = -1;
        while (copy % 10 == 9) {
            max = max * 10 + 9;
            copy /= 10;
        }
        int rep = copy % 10;
        prevRep = rep;
        while (copy > 0) {
            int x = copy % 10;
            if (x == rep)
                x = 9;
            max = max * 10 + x;
            copy /= 10;
        }

        // min_num
        int min = 0;
        copy = rev;
        while (copy > 0 && copy % 10 <= 1) {
            min = min * 10 + copy % 10;
            copy /= 10;
        }
        rep = copy % 10;
        int replaced = 0;
        if (min == 0)
            replaced = 1;

        while (copy > 0) {
            int x = copy % 10;
            if (x == rep)
                x = replaced;
            min = min * 10 + x;
            copy /= 10;
        }

        int ans = max - min;

        if (prevRep == 0) {
            while (mult > 1) {
                ans = ans * 10 + 9;
                mult /= 10;
            }
            return ans;
        }

        return ans * mult;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(100)); // example test
    }
}
