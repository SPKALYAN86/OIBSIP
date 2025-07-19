import java.util.*;
class BankAccount
{
    String name;
    String username;
    String password;
    String accountno;
    float balance = 10000f;
    int transaction = 0;
    String transactionHistory = " ";
    
    public void register()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your Name:");
        this.name = sc.nextLine();
        System.out.println("\nEnter your Username:");
        this.username = sc.nextLine();
        System.out.println("\nEnter your Password:");
        this.password = sc.nextLine();
        System.out.println("\nEnter your Accountno:");
        this.accountno = sc.nextLine();
        System.out.println("\nRegistration successful.Please Log in to your bank Account");
    }
    public boolean login()
    {
       boolean isLogin = false;
       Scanner sc = new Scanner(System.in);
            while(!isLogin) {
                System.out.println("\nEnter your username:");
                String Username = sc.nextLine();
                if(Username.equals(username))
                {
                    while(!isLogin)
                    {
                        System.out.println("\nEnter your password:");
                        String Password = sc.nextLine();
                        if(Password.equals(password))
                        {
                            System.out.println("\nLogin Successful");
                            isLogin = true;
                        }
                        else{
                            System.out.println("\nIncorrect Password");
                        }
                    }
                }
                else {
                    System.out.println("\nUsername not found");
                }
            }
            return isLogin;
            }

        public void withdraw()
        {
          System.out.println("\nEnter Amount to Withdraw:");
          Scanner sc = new Scanner(System.in);
          float amount = sc.nextFloat();
          try {
               if(balance >= amount)
               {
                  transaction++;
                  balance -= amount;
                  System.out.println("\nWithdrawl Successful");
                  String str = amount + "Rs Withdrawn\n";
                  transactionHistory = transactionHistory.concat(str);
               }
               else {
                  System.out.println("\nInsufficient Balance.");
               }
          }
          catch(Exception e)
          {

          }
        }


public void deposit()
        {
          System.out.println("\nEnter Amount to Diposit:");
          Scanner sc = new Scanner(System.in);
          float amount = sc.nextFloat();
          try {
               if(amount <= 10000f)
               {
                  transaction++;
                  balance += amount;
                  System.out.println("\nDeposit Successful");
                  String str = amount + "Rs deposited\n";
                  transactionHistory = transactionHistory.concat(str);
               }
               else {
                  System.out.println("\nSorry.The limit is 10000.");
               }
          }
          catch(Exception e)
          {
            
          }
        }
public void transfer()
        {
          Scanner sc = new Scanner(System.in);
          System.out.println("\nEnter Receipent's Name:");
         String receipent = sc.nextLine();
         System.out.println("\nEnter Amount to transfer:");
         float amount = sc.nextFloat();
          try {
               if(balance >= amount)
               {
                if(amount<=50000f)
               {
                  transaction++;
                  balance -= amount;
                  System.out.println("\nSuccessfully Transferred to"+receipent);
                  String str = amount + "Rs transferred to"+receipent+"\n";
                  transactionHistory = transactionHistory.concat(str);
               }
               else {
                  System.out.println("\nSorry.The limit is 50000.");
               }
          }
          else
          {
            System.out.println("\nInsufficient Balance.");
          }
          }
          catch(Exception e)
          {
            
          }
        }
        public void checkbalance() {
          System.out.println("\n"+balance+"Rs");
        }


           public void transHistory() 
           {
              if(transaction == 0)
              {
                System.out.println("No Transactions happened");
              }
              else{
                System.out.print("\n"+transactionHistory);
              }
                  
           } 
        
    }


public class ATMinterface{
         
         public static int takeIntegerInput(int limit)
         {
            int input = 0;
            boolean flag = false;
            while(!flag)
            {
              try{
                 Scanner sc = new Scanner(System.in);
                 input = sc.nextInt();
                 flag = true;
                 if(flag && input > limit || input<1)
                 {
                   System.out.println("Choose the number between 1 to"+limit);
                   flag = false;
                 }
              }
              catch(Exception e)
              {
                System.out.println("Enter only integer value: ");
                flag = false;
              }
            }
        return input;
         }
         public static void main(String[] args)
         {
              System.out.println("\n*********************WELCOME TO KALYAN ATM INTERFACE***************************");
              System.out.println("\n1.Register \n2 .Exit");
              System.out.println("Choose one option:");
              int choose = takeIntegerInput(2);
              if(choose == 1)
              {
                BankAccount b = new BankAccount();
                b.register();
                while(true)
                {
                   System.out.println("\n1.Login \n2.Exit");
                   System.out.println("Enter your choice:");
                   int ch = takeIntegerInput(2);
                   if(ch==1)
                   {
                     if(b.login())
                     {
                       System.out.println("\n*********************WELCOME BACK" + b.name +"***************************");
                       boolean isFinished = false;
                       while(!isFinished)
                       {
                          System.out.println("\n1.withdraw \n2.Deposit \n3.Transfer \n4.check balance \n5.Transaction History \n6.Exit");
                          System.out.println("Enter your choice:");
                          int c = takeIntegerInput(6);
                          switch(c)
                          {
                            case 1:
                              b.withdraw();
                              break;
                            case 2:
                              b.deposit();
                              break;
                            case 3:
                              b.transfer();
                              break;
                            case 4:
                              b.checkbalance();
                              break;
                            case 5:
                              b.transHistory();
                              break;
                            case 6:
                              isFinished = true;
                              break;
                          }
                       }
                     }
                   }
                   else{
                      System.exit(0);
                   }
                }
              }
              else{
                System.exit(0);
              }
         }
}