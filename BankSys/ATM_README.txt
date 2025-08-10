Java ATM Banking System

A simple Java console-based ATM Banking System using two classes: Balance and ATM.
This program allows users to deposit, withdraw, and check account balance.

Features
- Deposit: Add money to your account.
- Withdraw: Withdraw money if you have sufficient balance.
- Check Balance: View the current account balance.
- Exit: Close the application.

Tech Stack
- Language: Java
- Concepts Used:
  - Classes & Objects
  - Encapsulation (private balance variable)
  - Static Methods
  - Scanner for user input

Class Overview
1. Balance.java
   - Stores the account balance.
   - Provides getter and setter methods for balance.
   - Initializes default balance to 10000.

2. ATM.java
   - Main user interface.
   - Static methods for deposit, withdraw, and check balance.
   - Uses a loop to continuously prompt the user until exit.

How to Run
1. Create a folder named 'BankSys'.
2. Save Balance.java and ATM.java in the folder.
3. Open terminal/command prompt in the parent directory of BankSys.
4. Compile the files:
   javac BankSys/Balance.java BankSys/ATM.java
5. Run the program:
   java BankSys.ATM

Example Output
Welcome to the ATM

Choose the option below:
1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Enter your choice: 1
Enter the amount to deposit:
500
Deposited Successfully

Future Enhancements
- Add PIN authentication.
- Maintain transaction history.
- Allow balance persistence using file/database.
