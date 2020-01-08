/**
 * main
 */
public class sum_n {
    public static int sum(int n) {
        int temp = 0;
        for (int i = 0; i <= n; i++) {
            temp = temp + i;
        }
        n = temp;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sum(100));
    }
}
