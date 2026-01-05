package _1bit;

public class Bit {

    // Get bit at position i
    public static boolean getBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    // Set bit at position i
    public static int setBit(int n, int i) {
        return n | (1 << i);
    }

    // Clear bit at position i
    public static int clearBit(int n, int i) {
        return n & ~(1 << i);
    }

    // Toggle bit at position i
    public static int toggleBit(int n, int i) {
        return n ^ (1 << i);
    }

    // Count number of set bits (1s)
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    // Check if number is even
    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    // Check if number is odd
    public static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    // Swap two numbers without temporary variable
    public static int[] swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new int[]{a, b};
    }

    // Count bits needed to convert A to B
    public static int bitsToConvert(int A, int B) {
        int diff = A ^ B;
        return countSetBits(diff);
    }

    public static void main(String[] args) {
        int n = 5; // 101 in binary
        int i = 1;

        System.out.println("Original n = " + n);
        System.out.println("Get bit at " + i + " : " + getBit(n, i));
        System.out.println("Set bit at " + i + " : " + setBit(n, i));
        System.out.println("Clear bit at " + i + " : " + clearBit(n, i));
        System.out.println("Toggle bit at " + i + " : " + toggleBit(n, i));
        System.out.println("Set bits count : " + countSetBits(n));
        System.out.println("Is even : " + isEven(n));
        System.out.println("Is odd : " + isOdd(n));

        int a = 7, b = 3;
        int[] swapped = swap(a, b);
        System.out.println("Swap " + a + " and " + b + " : " + swapped[0] + ", " + swapped[1]);

        int A = 10, B = 7;
        System.out.println("Bits to convert " + A + " to " + B + " : " + bitsToConvert(A, B));
    }
}
