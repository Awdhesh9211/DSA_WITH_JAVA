package _2math;

public class Main {

    // 1.Factorial
    public static long Fact(long n){
        long res=1;
        for(long i=n;i>0;i--){
            res*=i;
        }
        return res;
    }

    //2.Trailing Zero in the Factorial
    public static  int trailingZeroFact(int n){
        int res=0;
        if(n<5){
            return 0;
        }
        for(int i=5;i<=n;i=i*5){
            res+=n/i;
        }
        return res;
    }

    //3.palindrom
    public static boolean Palindrome(int n) {
        int original = n;
        int rev = 0;

        while (n > 0) {
            int digit = n % 10;      // last digit
            rev = rev * 10 + digit; // reverse build
            n = n / 10;             // remove last digit
        }

        return original == rev;
    }



    public static void main(String[] args) {
        System.out.println(Fact(20));

        System.out.println(trailingZeroFact(20));
        System.out.println(Palindrome(121));
    }
}
