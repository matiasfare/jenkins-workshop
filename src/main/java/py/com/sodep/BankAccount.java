package py.com.sodep;

public class BankAccount {

  private double balance;

  public BankAccount(double balance) {
    this.balance = balance;
  }

  public double debit(double amount) {
    if (balance < amount) {
      return 0.0;
    }

    balance -= amount;
    return amount;
  }

  public double getBalance() {
    return this.balance;
  }

}


