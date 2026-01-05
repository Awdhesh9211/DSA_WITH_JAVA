## 1️⃣ Single Number (Every element appears twice)

### ❓ Question

Array me sab elements **2 baar** aate hain, sirf **ek element 1 baar** aata hai. Use find karo.

### 🧠 Algorithm

* XOR all elements
* Duplicate cancel ho jaate hain

### 💻 Code

```java
int ans = 0;
for (int x : arr) {
    ans ^= x;
}
return ans;
```

### ⏱ Time Complexity

**O(n)**

### 🧠 Space Complexity

**O(1)**

---

## 2️⃣ Two Unique Numbers (Others appear twice)

### ❓ Question

Array me **do unique numbers** hain, baaki sab 2 baar.

### 🧠 Algorithm

1. XOR all → `a ^ b`
2. Rightmost set bit nikalo
3. 2 groups banao
4. XOR each group

### 💻 Code

```java
int xor = 0;
for (int x : arr) xor ^= x;

int setBit = xor & -xor;
int a = 0, b = 0;

for (int x : arr) {
    if ((x & setBit) != 0) a ^= x;
    else b ^= x;
}
```

### ⏱ Time Complexity

**O(n)**

### 🧠 Space Complexity

**O(1)**

---

## 3️⃣ Element Appearing Once (Others appear 3 times)

### ❓ Question

Har element **3 baar** aata hai, ek sirf **1 baar**.

### 🧠 Algorithm

* Har bit position pe count
* `% 3`
* Number reconstruct

### 💻 Code

```java
int result = 0;
for (int i = 0; i < 32; i++) {
    int sum = 0;
    for (int x : arr) {
        if ((x & (1 << i)) != 0) sum++;
    }
    if (sum % 3 != 0)
        result |= (1 << i);
}
```

### ⏱ Time Complexity

**O(32 × n) ≈ O(n)**

### 🧠 Space Complexity

**O(1)**

---

## 4️⃣ Check Subset Using Bitmask

### ❓ Question

Check karo ki array `B`, array `A` ka subset hai ya nahi.

### 🧠 Algorithm

* Bitmask banao for `A`
* `B` ke bits check karo

### 💻 Code

```java
int mask = 0;
for (int x : A) mask |= (1 << x);

for (int x : B) {
    if ((mask & (1 << x)) == 0)
        return false;
}
return true;
```

### ⏱ Time Complexity

**O(n + m)**

### 🧠 Space Complexity

**O(1)**

---

## 5️⃣ Count Subarrays with XOR = K

### ❓ Question

Kitne subarrays ka XOR = `K` hai?

### 🧠 Algorithm

* Prefix XOR
* HashMap use karo

### 💻 Code

```java
Map<Integer, Integer> map = new HashMap<>();
map.put(0, 1);

int xor = 0, count = 0;
for (int x : arr) {
    xor ^= x;
    count += map.getOrDefault(xor ^ k, 0);
    map.put(xor, map.getOrDefault(xor, 0) + 1);
}
```

### ⏱ Time Complexity

**O(n)**

### 🧠 Space Complexity

**O(n)**

---

## 6️⃣ Generate All Subsets (Bitmasking)

### ❓ Question

Array ke **saare subsets** generate karo.

### 🧠 Algorithm

* `0 → 2^n - 1`
* Bits se decide inclusion

### 💻 Code

```java
int n = arr.length;
for (int mask = 0; mask < (1 << n); mask++) {
    for (int i = 0; i < n; i++) {
        if ((mask & (1 << i)) != 0)
            System.out.print(arr[i] + " ");
    }
    System.out.println();
}
```

### ⏱ Time Complexity

**O(n × 2ⁿ)**

### 🧠 Space Complexity

**O(1)** (excluding output)

---

## 7️⃣ Missing Number Using XOR

### ❓ Question

Array me `1 → n` ke beech ka ek number missing hai.

### 🧠 Algorithm

* XOR array
* XOR `1 → n`
* Dono ka XOR

### 💻 Code

```java
int xor1 = 0, xor2 = 0;
for (int x : arr) xor1 ^= x;
for (int i = 1; i <= n; i++) xor2 ^= i;
return xor1 ^ xor2;
```

### ⏱ Time Complexity

**O(n)**

### 🧠 Space Complexity

**O(1)**

---

## 8️⃣ Pairwise Disjoint Array

### ❓ Question

Check karo koi bhi do elements ke beech **common set bit** na ho.

### 🧠 Algorithm

* Mask maintain karo
* Conflict check karo

### 💻 Code

```java
int mask = 0;
for (int x : arr) {
    if ((mask & x) != 0)
        return false;
    mask |= x;
}
return true;
```

### ⏱ Time Complexity

**O(n)**

### 🧠 Space Complexity

**O(1)**

---

## 9️⃣ Maximum AND Pair

### ❓ Question

Array me kisi bhi pair ka **maximum AND value** find karo.

### 🧠 Algorithm

* MSB → LSB greedy bit checking
* Count matches

### ⏱ Time Complexity

**O(32 × n) ≈ O(n)**

### 🧠 Space Complexity

**O(1)**

---

## 🔟 Sort Array by Set Bits

### ❓ Question

Array ko **set bits count** ke basis pe sort karo.

### 💻 Code

```java
Arrays.sort(arr, (a, b) ->
    Integer.bitCount(a) - Integer.bitCount(b)
);
```

### ⏱ Time Complexity

**O(n log n)**

### 🧠 Space Complexity

**O(1)** (TimSort internal stack ignored)

---

## ✅ Final Interview Summary

| Problem Type       | TC      | SC   |
| ------------------ | ------- | ---- |
| XOR single number  | O(n)    | O(1) |
| Two unique numbers | O(n)    | O(1) |
| Appear once (3x)   | O(n)    | O(1) |
| Subarray XOR       | O(n)    | O(n) |
| Subsets            | O(n·2ⁿ) | O(1) |
| Missing number     | O(n)    | O(1) |

---

If you want next:

* 📄 **Pure `.md` printable notes**
* 🧠 **LeetCode problem list**
* 🔥 **Only XOR pattern sheet**
* 📘 **Exam-oriented short notes**

Bas bol do, next level unlock kar dete hain 🚀
