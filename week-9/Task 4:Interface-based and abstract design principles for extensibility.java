	Session 4	
Interface-based and abstract design principles for extensibility
	Problem Statement
Design a Payment Processing System using a Java interface and an abstract class.
Create an interface:
interface Payment {
    void pay(double amount);
}
Implement this interface using three classes:
•	CreditCardPayment 
•	UPIPayment 
•	NetBankingPayment 
Each payment method should implement the pay() method.
Create an abstract class PaymentProcessor containing:
	abstract double processPayment(Payment payment, double amount);
Create a concrete class 
	OnlinePaymentProcessor that extends PaymentProcessor.

The processing rules are:
•	Credit Card: 2% processing fee 
•	UPI: 1% processing fee 
•	Net Banking: 1.5% processing fee 

The program should calculate the final amount paid, including the processing fee.
The design should allow a new payment method to be added without modifying the existing PaymentProcessor class.

Input Format
The first line contains an integer N, representing the number of transactions.
Each of the next N lines contains:
paymentType amount
where:
•	1 → Credit Card 
•	2 → UPI 
•	3 → Net Banking 

Output Format
For each transaction, print:
paymentType finalAmount
Print the final amount rounded to two decimal places.

Constraints
•	1 ≤ N ≤ 100 
•	100 ≤ amount ≤ 1000000 

Sample Input:
3
1 1000
2 2000
3 5000

Sample Output:
CreditCard 1020.00
UPI 2020.00
NetBanking 5075.00
	Eclipse IDE

  PROGRAM:
import java.util.Scanner;

// Payment interface
interface Payment {
    void pay(double amount);
    double getFeePercentage();
    String getName();
}

// Concrete implementation for Credit Card Payment
class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        // Payment execution logic if needed
    }

    @Override
    public double getFeePercentage() {
        return 0.02; // 2% fee
    }

    @Override
    public String getName() {
        return "CreditCard";
    }
}

// Concrete implementation for UPI Payment
class UPIPayment implements Payment {
    @Override
    public void pay(double amount) {
        // Payment execution logic if needed
    }

    @Override
    public double getFeePercentage() {
        return 0.01; // 1% fee
    }

    @Override
    public String getName() {
        return "UPI";
    }
}

// Concrete implementation for Net Banking Payment
class NetBankingPayment implements Payment {
    @Override
    public void pay(double amount) {
        // Payment execution logic if needed
    }

    @Override
    public double getFeePercentage() {
        return 0.015; // 1.5% fee
    }

    @Override
    public String getName() {
        return "NetBanking";
    }
}

// Abstract PaymentProcessor class
abstract class PaymentProcessor {
    abstract double processPayment(Payment payment, double amount);
}

// Concrete OnlinePaymentProcessor extending PaymentProcessor
class OnlinePaymentProcessor extends PaymentProcessor {
    @Override
    double processPayment(Payment payment, double amount) {
        double fee = amount * payment.getFeePercentage();
        double finalAmount = amount + fee;
        payment.pay(finalAmount);
        return finalAmount;
    }
}

// Main execution class
public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int N = scanner.nextInt();
        PaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < N; i++) {
            int paymentType = scanner.nextInt();
            double amount = scanner.nextDouble();

            Payment payment = null;

            switch (paymentType) {
                case 1:
                    payment = new CreditCardPayment();
                    break;
                case 2:
                    payment = new UPIPayment();
                    break;
                case 3:
                    payment = new NetBankingPayment();
                    break;
                default:
                    continue;
            }

            double finalAmount = processor.processPayment(payment, amount);
            System.out.printf("%s %.2f%n", payment.getName(), finalAmount);
        }

        scanner.close();
    }
}
