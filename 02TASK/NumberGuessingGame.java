import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;
    
    public static void main(String[] args)
    {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int totalscore = 0;

        System.out.println("NUMBER GUESSING GAME");
        System.out.println("Total Number of Rounds: 3");
        System.out.println("Attempts To Guess Number In Each Round: 10\n");
        for(int i = 1; i <= MAX_ROUNDS ; i++)
        {
            int number = random.nextInt(MAX_RANGE) + MIN_RANGE;
            int attempts = 0;
            System.out.println("Round:"+i+" "+"Guess the number between"+" "+ MIN_RANGE+" "+"and"+" "+MAX_RANGE+" "+"in"+" "+MAX_ATTEMPTS+" "+"attempts.\n");
            while (attempts < MAX_ATTEMPTS)
            {
                System.out.print("Enter your guess:");
                int GuessNumber = scan.nextInt();
                attempts++;
                if (GuessNumber == number)
                {
                    int score = MAX_ATTEMPTS - attempts;
                    totalscore += score;
                    System.out.printf("Hurrey! Number Guessed Successfully . Attempts"+" "+attempts+" "+"Round Score"+" "+score);
                    break;
                }
                else if(GuessNumber < number)
                {
                    System.out.println("The number is grater than"+" "+GuessNumber+" "+"Attempts left"+" " + (MAX_ATTEMPTS-attempts));
                }
                else
                {
                  System.out.println("The number is less than"+" "+GuessNumber+" "+"Attempts left"+" "+(MAX_ATTEMPTS-attempts)); 
                }
            }
            if(attempts == MAX_ATTEMPTS)
            {
                System.out.println("\n Round = "+i);
                System.out.println("Attempts = 0");
                System.out.println("The Random Number Was :"+number);
            }
        }
        System.out.println("Game Over. Total Score = "+ totalscore);
        scan.close();

    }
}