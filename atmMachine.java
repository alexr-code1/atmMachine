import javax.swing.JOptionPane; 

public class atmMachine {
   public static void main (String[] args) { 
   
    //Initial variables with different different data types (double, string)
    double numDeposits = 0;
    double numWithdrawals = 0;
    double initialBalance = GET_ACCOUNT_BALANCE();
    double accountBalance =  initialBalance;
    String transactionAction = GET_TRANSACTION_ACTION();
    
    //While loop to start and start the program based on user input. 
    //Count is tracked for numDeposits and numWithdrawals
    while (!transactionAction.equalsIgnoreCase("Q")) {
          if (transactionAction.equalsIgnoreCase("D")) {
                numDeposits = numDeposits + 1; }
                else if (transactionAction.equalsIgnoreCase("W")) {
                     numWithdrawals = numWithdrawals + 1;
                }
           
         double transactionAmount = GET_TRANSACTION_AMOUNT(); 

        accountBalance = CALCULATE_NEW_ACCOUNT_BALANCE(transactionAction,transactionAmount,accountBalance);
        PRINT_ACCOUNT_BALANCE(accountBalance); {
         transactionAction = GET_TRANSACTION_ACTION(); 
         }
         }
     
 PRINT_TRANSACTION_SUMMARY( initialBalance,  accountBalance, numDeposits, numWithdrawals);
 
 }

//Method to get account balance, prompts user for balance, and while loop to validate accountBalance entered is greater than zero. 
public static double GET_ACCOUNT_BALANCE() {

double accountBalance; 
     do{
       accountBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter account balance: ")); 
      if (accountBalance < 0) {
                JOptionPane.showMessageDialog(null, "Error! Account balance must be a number greater than or equal to 0.");
          }
     }while (accountBalance < 0); 
     
     return accountBalance; 
}

 
//Method to get User input for transaction action based on deposit or withdraw.
public static String GET_TRANSACTION_ACTION() {
String transactionAction; 
     do { 
         transactionAction = JOptionPane.showInputDialog(null, "Enter transaction action, D, W, or Q to Quit: "); 
        if ((!transactionAction.equalsIgnoreCase("D")) && (!transactionAction.equalsIgnoreCase("W")) && (!transactionAction.equalsIgnoreCase("Q"))) {
                JOptionPane.showMessageDialog (null,  ("Error! Please enter (D) for Deposit, (W) for Withdrawal, or (Q) for Quit")); 
          }
     } while ((!transactionAction.equalsIgnoreCase("D")) && (!transactionAction.equalsIgnoreCase("W")) && (!transactionAction.equalsIgnoreCase("Q")));
     return transactionAction; 
}

 
//Error handler method for transaction amount. 
public static double GET_TRANSACTION_AMOUNT () {
   double transactionAmount; 
     do { 
          transactionAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter transaction amount: "));
         if (transactionAmount <= 0) {
                JOptionPane.showMessageDialog (null, "Error! Transaction amounts must be a number greater than 0.");
          }
     } while (transactionAmount < 0);
     
     return transactionAmount; 
}

 
//Method to calculate account balance based on deposit or withdraw.
public static double CALCULATE_NEW_ACCOUNT_BALANCE(String transactionAction, double transactionAmount, double accountBalance){
    if (transactionAction.equalsIgnoreCase("D")) {
            accountBalance = accountBalance + transactionAmount;
            }
           else if (transactionAction.equalsIgnoreCase("W")) {
                 accountBalance = accountBalance - transactionAmount;
           }
     
     return accountBalance; 
} 

 
//Message dialog method to print account balance. 
public static void PRINT_ACCOUNT_BALANCE(double accountBalance) { 
   JOptionPane.showMessageDialog (null, "The balance in your account is: " + accountBalance); 
}

 
//Well formatted message dialog method to print transaction summary
public static void PRINT_TRANSACTION_SUMMARY(double initialBalance, double accountBalance, double numDeposits, double numWithdrawals) { 
  JOptionPane.showMessageDialog ( null, "The initial balance in your account was: " + initialBalance + 
     "\nThe final balance in your account is: " + accountBalance + 
     "\nNumber of Deposits: " + numDeposits + 
     "\nNumber of Withdrawals: " + numWithdrawals); 
}

}