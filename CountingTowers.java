import java.util.Scanner;

public class CountingTowers {
    static final int MOD = (int) 1e9 + 7;
    static final int N = (int) 1e6 + 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] OneBlock = new long[N];
        long[] TwoBlocks = new long[N];

        OneBlock[1] = TwoBlocks[1] = 1;

        for (int i = 2; i < N; i++) {
            OneBlock[i] = (2 * OneBlock[i - 1] + TwoBlocks[i - 1]) % MOD;
            TwoBlocks[i] = (4 * TwoBlocks[i - 1] + OneBlock[i - 1]) % MOD;
        }

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println((OneBlock[n] + TwoBlocks[n]) % MOD);
        }

        sc.close();
    }
}
