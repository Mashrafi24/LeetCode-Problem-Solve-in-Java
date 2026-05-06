import java.util.*;

public class  Devlali {

    static final int MAX = 1000000;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean[] generated = new boolean[MAX + 1];
        boolean[] isPrime = new boolean[MAX + 1];
        int[] prefix = new int[MAX + 1];

        // Devlali (generated)
        for (int i = 1; i <= MAX; i++)` {
            int sum = i, t = i;
            while (t > 0) {
                sum += t % 10;
                t /= 10;
            }
            if (sum <= MAX) generated[sum] = true;
        }

        // Prime check (simple sieve)
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Prefix count
        for (int i = 1; i <= MAX; i++) {
            prefix[i] = prefix[i - 1];
            if (!generated[i] && isPrime[i]) prefix[i]++;
        }

        int Q = sc.nextInt();

        while (Q-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            if (A < 1) A = 1;

            System.out.println(prefix[B] - prefix[A - 1]);
        }
    }
}