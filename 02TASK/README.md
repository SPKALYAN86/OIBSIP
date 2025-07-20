# 🎯 Task-2: Number Guessing Game (Java)

This Java program implements a simple **number guessing game** where the player tries to guess a randomly generated number within a limited number of attempts across multiple rounds.



## 🕹️ How to Play

### ✅ Setup
- A random number is generated between **1 to 100** (modifiable).
- You get **10 attempts** to guess the number in each round.
- The game runs for **3 rounds**.

### ▶️ Playing a Round
- You'll be prompted to enter your guess.
- Feedback will be given:
  - "Greater than" if your guess is too low.
  - "Less than" if your guess is too high.
- Try to guess correctly within the attempts.



## 🧮 Scoring

- **Round Score** = `MAX_ATTEMPTS - attempts_taken`
- **Total Score** = Sum of scores from all 3 rounds.



## ⚙️ Customization

Modify the constants in the source code to customize gameplay:
```java
private static final int MIN_RANGE = 1;
private static final int MAX_RANGE = 100;
private static final int MAX_ATTEMPTS = 10;
private static final int MAX_ROUNDS = 3;

