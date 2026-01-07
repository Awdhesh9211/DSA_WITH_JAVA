package _2math;

import java.util.Arrays;

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

    //4.prime number
    public  static  boolean[]  sieveOferatothenes(int n){
        boolean isPrime[]=new boolean[n+1];

        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2;i*i<=n;i++){

            for(int j=2*i;j<=n;j+=i){
                isPrime[j]=false;
            }
        }
        return isPrime;
    }
    // gcd
    static int gcd(int a,int b){
        if(a%b==0) return b;
        return gcd(b,a%b);
    }

    //modulo arithmetic
    //(a+b)%n=(a%n + b%n)%n   same for - *
    static long fastPower(long a,long b , int n){
        long res=1;
        while(b>0) {
            if ((b & 1) != 0) {
                res =(a * b % n)%n;
            }
            a = (a %n* a%n)%n;
            b = b >> 1;
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(Fact(20));
        System.out.println(trailingZeroFact(20));
        System.out.println(Palindrome(121));

        // Major topic
        //1. Sieve of eratosthenes Prime number
        boolean[] isPrime= sieveOferatothenes(12);
        for(int i=0;i<isPrime.length;i++){
            System.out.println(i+ " "+isPrime[i]);
        }
        //2. GCD (a,b)=(b,a%b) HCF
        System.out.println(gcd(15,27));

        //3. Modulo Arithmetics compute: a^b%n   // 6 vid // Q. a raise to b
        System.out.println(fastPower(3978432,5,1000000007));

        // HW -> learn about
        // 1. BigInteger
        // 2. Catalan Numbers
        // 3. Pigeon hole Principle
        // 4.Inclusion-Exclusion
    }
}
