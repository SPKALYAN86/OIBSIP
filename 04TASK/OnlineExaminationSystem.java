import java.util.*;
class Question
{
    String questionText;
    List<String> options;
    int correctOption;

    public Question(String questionText,List<String>options,int correctOption)
    {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

}
class User 
{
    String username;
    String password;

    public User(String username , String password)
    {
        this.username = username;
        this.password = password;
    }
}

public class OnlineExaminationSystem
{
    static List<Question> questions = new ArrayList<>();
    static List<User> users = new ArrayList<>();
    static User loggedInUser;
    static boolean sessionOpen = false;
    static boolean timeUp = false;

    public static void main(String[] args)
    {
        initializeQuestions();

        Scanner scan = new Scanner(System.in);
        while (true)
        {
            System.out.println("1.LOGIN");
             System.out.println("2.Register");
             System.out.println("3.Exit");
            System.out.println("\nEnter your choice:");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice)
            {
                 case 1:
                    login(scan);
                    break;
                 case 2:
                    register(scan);
                    break;
                 case 3:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.Please select a valid option!");       
            }

        }

    }
    public static void initializeQuestions()
    {
        List<String> options1 = new ArrayList<>();
        options1.add("Guido van Rossum");
        options1.add("James Gosling");
        options1.add("Dennis Ritchie");
        options1.add("Bjarne Stroustrup");

        List<String> options2 = new ArrayList<>();
        options2.add("JRE");
        options2.add("JIT");
        options2.add("JDK");
        options2.add("JVM");

        List<String> options3 = new ArrayList<>();
        options3.add("Object-Oriented");
        options3.add("Use of pointers");
        options3.add("Portable");
        options3.add("Dynamic and Extensible");

        List<String> options4 = new ArrayList<>();
        options4.add(".js");
        options4.add(".text");
        options4.add(".class");
        options4.add(".java");

        List<String> options5 = new ArrayList<>();
        options5.add("Polymorphism");
        options5.add("Inheritance");
        options5.add("Compilation");
        options5.add("Encapsulation");
      
      Question question1 = new Question("Who invited Java Programming?",options1,1);
      Question question2 = new Question("Which component is used to compile, debug and execute the java programs?",options2,2);
      Question question3 = new Question("Which one of the following is not a Java feature?",options3,1);
      Question question4 = new Question("What is the extension of Java code files?",options4,3);
      Question question5 = new Question("Which of the following is not an OOPS concept in Java?",options5,2);
      
      questions.add(question1);
      questions.add(question2);
      questions.add(question3);
      questions.add(question4);
      questions.add(question5);
    }

public static void register (Scanner scan)
{
    System.out.print("Enter a Username:");
    String username = scan.nextLine();
    System.out.print("Enter a Password:");
    String password = scan.nextLine();

    for (User user : users)
    {
        if (user.username.equals(username))
        {
           System.out.println("Username already taken. Please choose another one.");
           return;
        }
    
    }

User newUser = new User(username, password);
users.add(newUser);
System.out.println("Registration successful! You can now log in now.");
}
public static void login(Scanner scan)
{
    System.out.print("Enter username:");
    String username = scan.nextLine();
    System.out.print("Enter Password:");
    String password = scan.nextLine();

    for (User user : users)
    {
        if(user.username.equals(username) && user.password.equals(password))
        {
            loggedInUser = user;
            sessionOpen = true;
            startExam(scan);
            return;
        }
    }
    System.out.println("Invalid credentials.Please try again!");
}
public static void startExam(Scanner scan)
{
    System.out.println("\nWelcome,"+loggedInUser.username+"!");
    System.out.println("You have 60 seconds to complete the exam!");
    Thread timerThread = new Thread(() -> {
        try {
            Thread.sleep(60000); // 60 seconds
            timeUp = true;
            System.out.println("\n⏰ Time's up! Exam auto-submitted.\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    timerThread.start();

   int score = 0;
    for(int i = 0;i<questions.size();i++)
    {
        if(timeUp) break;
        Question question = questions.get(i);
        System.out.println("Question"+(i+1)+":"+question.questionText);
        for(int j=0;j<question.options.size();j++)
        {
            System.out.println((j+1)+". "+question.options.get(j));
        } 
        System.out.print("Select your answer(1-"+question.options.size()+"):");
        int userChoice;
        try {
                userChoice= scan.nextInt();
            } catch (InputMismatchException e) {
                scan.nextLine(); // clear buffer
                System.out.println("Invalid input! Moving to next question.");
                continue;
            }
        if (userChoice == question.correctOption + 1)
        {
            System.out.println("Correct!");
            score++;
        }
        else
        {
            System.out.println("Incorrect!");
        }
    }
    System.out.println("Exam completed!");
    System.out.println("🎯 Your score: " + score + " out of " + questions.size());
    sessionOpen = false;
    timeUp = false;
}
}