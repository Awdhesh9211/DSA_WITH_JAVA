package _1bit;

import java.util.*;

public class ArrayByBit {

    // 1️⃣ Find single number (others appear twice)
    static int singleNumber(int[] arr) {
        int ans = 0;

        // XOR cancels same numbers
        for (int x : arr) {
            ans ^= x;
        }

        return ans;
    }

    // 2️⃣ Find two unique numbers (others appear twice)
    static int[] twoUniqueNumbers(int[] arr) {
        int xor = 0;

        // XOR of all = a ^ b
        for (int x : arr) xor ^= x;

        int a = 0, b = 0;

        // Divide into two groups
        for (int x : arr) {
            if ((x & 1) != 0)
                a ^= x;
            else
                b ^= x;
        }

        return new int[]{a, b};
    }

    // 3️⃣ Element appearing once (others appear 3 times)
    static int singleNumberThrice(int[] arr) {
        int result = 0;

        // Check each bit position
        for (int i = 0; i < 32; i++) {
            int count = 0;

            for (int x : arr) {
                if ((x & (1 << i)) != 0)
                    count++;
            }

            // If count % 3 != 0 → bit belongs to unique number
            if (count % 3 != 0)
                result |= (1 << i);
        }

        return result;
    }

    // 4️⃣ Check if array B is subset of A (small numbers)
    static boolean isSubset(int[] A, int[] B) {
        int mask = 0;

        // Create bitmask of A
        for (int x : A)
            mask |= (1 << x);

        // Check all elements of B
        for (int x : B) {
            if ((mask & (1 << x)) == 0)
                return false;
        }

        return true;
    }

    // 5️⃣ Count subarrays with XOR = K
    static int countSubarraysXorK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int xor = 0, count = 0;

        for (int x : arr) {
            xor ^= x;

            // Check prefix
            count += map.getOrDefault(xor ^ k, 0);

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }

    // 6️⃣ Generate all subsets using bitmask
    static void generateSubsets(int[] arr) {
        int n = arr.length;

        for (int mask = 0; mask < (1 << n); mask++) {
            System.out.print("{ ");

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0)
                    System.out.print(arr[i] + " ");
            }

            System.out.println("}");
        }
    }

    // 7️⃣ Find missing number using XOR
    static int missingNumber(int[] arr, int n) {
        int xor1 = 0, xor2 = 0;

        for (int x : arr) xor1 ^= x;
        for (int i = 1; i <= n; i++) xor2 ^= i;

        return xor1 ^ xor2;
    }

    // 8️⃣ Check pairwise disjoint array
    static boolean pairwiseDisjoint(int[] arr) {
        int mask = 0;

        for (int x : arr) {
            if ((mask & x) != 0)
                return false;

            mask |= x;
        }

        return true;
    }

    // 🔟 MAIN METHOD (RUN & SEE)
    public static void main(String[] args) {

        System.out.println("🔹 Single Number");
        int[] a1 = {2, 3, 5, 3, 2};
        System.out.println(singleNumber(a1)); // 5

        System.out.println("\n🔹 Two Unique Numbers");
        int[] a2 = {1, 2, 3, 2, 1, 4};
        System.out.println(Arrays.toString(twoUniqueNumbers(a2)));

        System.out.println("\n🔹 Appears Once (Others 3 Times)");
        int[] a3 = {2, 2, 3, 2};
        System.out.println(singleNumberThrice(a3)); // 3

        System.out.println("\n🔹 Subset Check");
        int[] A = {1, 2, 3, 4};
        int[] B = {2, 4};
        System.out.println(isSubset(A, B)); // true

        System.out.println("\n🔹 Subarrays with XOR = K");
        int[] a4 = {4, 2, 2, 6, 4};
        System.out.println(countSubarraysXorK(a4, 6));

        System.out.println("\n🔹 Generate Subsets");
        int[] a5 = {1, 2, 3};
        generateSubsets(a5);

        System.out.println("\n🔹 Missing Number");
        int[] a6 = {1, 2, 4, 5};
        System.out.println(missingNumber(a6, 5)); // 3

        System.out.println("\n🔹 Pairwise Disjoint");
        int[] a7 = {1, 2, 4, 8};
        System.out.println(pairwiseDisjoint(a7)); // true
    }
}
