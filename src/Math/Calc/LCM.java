package Math.Calc;

public class LCM {

    long lcm(long c, long d) {
        return c * d / gcd(c, d);
    }

    long gcd(long c, long d) {
        if (c < d) return gcd(d, c);
        if (d == 0) return c;
        return gcd(d, c % d);
    }

}