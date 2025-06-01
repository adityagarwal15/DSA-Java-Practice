## 🔁 Java Input Buffer Reminder (Cheat Sheet)

---

### ⚠️ The Problem: `nextInt()` + `nextLine()` Trap

When using `Scanner` in Java, combining `nextInt()`, `nextDouble()` (and similar methods) **with** `nextLine()` often causes unexpected behavior.

---

### 🧠 Why It Happens

* Methods like `nextInt()`, `nextDouble()` only read the **number**, **not the newline** (`\n`) after the user presses `ENTER`.
* Then, when you call `nextLine()`, it **immediately reads the leftover `\n`** — and returns an empty string.

---

### ❌ Problematic Code

```java
Scanner sc = new Scanner(System.in);

int age = sc.nextInt();         // Reads number
String name = sc.nextLine();    // ❌ Reads leftover '\n', not the actual name
```

---

### ✅ Fixed Code (Clear the Buffer)

```java
Scanner sc = new Scanner(System.in);

int age = sc.nextInt();         
sc.nextLine();                  // ✅ Consume leftover newline

String name = sc.nextLine();    // ✅ Now reads full line input correctly
```

---

### 📦 Why This Happens

| Method         | What It Reads                      |
| -------------- | ---------------------------------- |
| `nextInt()`    | Just the number                    |
| `nextDouble()` | Just the number                    |
| `nextLine()`   | The **whole line**, including `\n` |

So after using `nextInt()`, always clear the buffer using `sc.nextLine()` before using `nextLine()` again.

---

### 🔍 Think of It As:

* `nextInt()` reads: **only the value**
* `nextLine()` reads: **the whole line** (up to `\n`)

---

### 💡 Interview Tip

If you ever face weird input issues in Java, especially when switching between numbers and strings — **it's almost always the buffer!**

---

