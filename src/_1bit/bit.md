```md
# 🔢 Binary, Operators & Bitmasking (Complete Notes – Sab Kuch Ek Jagah)

---

## 1️⃣ Binary Number System

Binary number system sirf **do digits** use karta hai:
- `0`
- `1`

Har digit ko **bit** kehte hain.

### Decimal → Binary
| Decimal | Binary |
|--------|--------|
| 1 | 1 |
| 2 | 10 |
| 3 | 11 |
| 5 | 101 |
| 8 | 1000 |
| 10 | 1010 |

---

## 2️⃣ Binary Addition

### Rules
| A | B | Sum | Carry |
|--|--|-----|-------|
| 0 | 0 | 0 | 0 |
| 0 | 1 | 1 | 0 |
| 1 | 0 | 1 | 0 |
| 1 | 1 | 0 | 1 |

### Example
```

101

* 011

---

1000

```

---

## 3️⃣ Binary Subtraction

### Rules
| A | B | Result |
|--|--|--------|
| 0 | 0 | 0 |
| 1 | 0 | 1 |
| 1 | 1 | 0 |
| 0 | 1 | Borrow |

### Example
```

101

* 011

---

010

````

---

## 4️⃣ Operators

### Arithmetic Operators
| Operator | Meaning |
|--------|--------|
| `+` | Addition |
| `-` | Subtraction |
| `*` | Multiplication |
| `/` | Division |
| `%` | Modulus |

### Bitwise Operators
| Operator | Kaam |
|--------|------|
| `&` | AND |
| `|` | OR |
| `^` | XOR |
| `~` | NOT |
| `<<` | Left Shift |
| `>>` | Right Shift |

---

## 5️⃣ Odd & Even Numbers

### Rule
- **Even** → 2 se divisible
- **Odd** → 2 se divisible nahi

### Binary Trick
- Last bit `0` → Even
- Last bit `1` → Odd

### Example
| Binary | Decimal | Type |
|------|--------|------|
| 1010 | 10 | Even |
| 1011 | 11 | Odd |

---

## 6️⃣ Swap Two Numbers

### Temporary Variable se
```c
int a = 5, b = 10;
int temp = a;
a = b;
b = temp;
````

### Without Temporary Variable

```c
a = a + b;
b = a - b;
a = a - b;
```

### XOR se (Best)

```c
a = a ^ b;
b = a ^ b;
a = a ^ b;
```

---

# 🧠 Bitmasking

**Bitmasking** ka matlab hota hai bits ko directly control karna using bitwise operators.

---

## 7️⃣ Get Bit (Bit check karna)

Bit position `i` pe `1` hai ya nahi:

```
(n & (1 << i)) != 0
```

```c
int n = 5;   // 101
int i = 2;
bool isSet = (n & (1 << i)) != 0;
```

---

## 8️⃣ Set Bit (Bit = 1 banana)

```
n | (1 << i)
```

```c
int n = 5;   // 101
int i = 1;
n = n | (1 << i);   // 111
```

---

## 9️⃣ Clear Bit (Bit = 0 banana)

```
n & ~(1 << i)
```

```c
int n = 7;   // 111
int i = 1;
n = n & ~(1 << i);   // 101
```

---

## 🔟 Toggle Bit (0 → 1, 1 → 0)

```
n ^ (1 << i)
```

```c
int n = 5;   // 101
int i = 0;
n = n ^ (1 << i);   // 100
```

---

## 1️⃣1️⃣ Count Set Bits (Kitne 1 hain)

```c
int count = 0;
while (n > 0) {
    count += n & 1;
    n >>= 1;
}
```

---

## 1️⃣2️⃣ Power of 2 Check

```
n & (n - 1) == 0
```

```c
bool isPowerOfTwo = (n > 0 && (n & (n - 1)) == 0);
```

---

## 1️⃣3️⃣ A to B Bit Conversion

A ko B banane ke liye **kitne bits change** karne padenge.

### Step 1: XOR

```c
int A = 10;  // 1010
int B = 7;   // 0111
int diff = A ^ B;   // 1101
```

### Step 2: Count set bits

```c
int count = 0;
while (diff > 0) {
    count += diff & 1;
    diff >>= 1;
}
```

---

## ✅ Final Summary

* Binary sirf `0` aur `1` use karta hai
* Last bit se odd/even pata chalta hai
* XOR se swap aur comparison easy hota hai
* Bitmasking **DSA, CP, interviews** ke liye must hai
* Low-level aur high-performance code me bohot use hota hai

---

```
```
