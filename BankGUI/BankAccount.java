public class BankAccount{
    String firstName;
    String lastName;
    int accountID;
    double balance;

    public BankAccount(String firstName, String lastName, int accountID, double balance){ //parameterized BankAccount object
        firstName = this.firstName;
        lastName = this.lastName;
        accountID = this.accountID;
        balance = this.balance;
    }

    public BankAccount(){ //overloading BankAccount to allow for a no args version of this object

    }

    public double deposit(double deposit){ //method to deposit money
        balance = balance + deposit;
        return balance;
    }

    public double withdraw(double withdraw){ //method to withdraw money
        balance = balance - withdraw;
        return balance;
    }

    //getter and setter for firstName
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //getter and setter for lastName
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //getter and setter for accountID
    public int getAccountID() {
        return this.accountID;
    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    //getter and setter for balance
    public double getBalance() {
        return this.balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void MenuGUI() {
    }



}
 