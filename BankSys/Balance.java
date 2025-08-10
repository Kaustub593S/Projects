package BankSys;

public class Balance 
{
    private double amount;

    public Balance() {
        this.amount = 10000;
    } 

    public double getBalance() 
    {
        return amount;
    }

    public void setBalance(double amount) {
        this.amount = amount;
    }
    
}
