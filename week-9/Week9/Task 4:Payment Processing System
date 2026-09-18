import java.util.*;

interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("CreditCard payment: " + amount);
    }
}

class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("UPI payment: " + amount);
    }
}

class NetBankingPayment implements Payment {
    public void pay(double amount) {
        System.out.println("NetBanking payment: " + amount);
    }
}

abstract class PaymentProcessor {
    abstract double processPayment(Payment payment, double amount);
}

class OnlinePaymentProcessor extends PaymentProcessor {

    public double processPayment(Payment payment, double amount) {
        double fee;

        if (payment instanceof CreditCardPayment) {
            fee = amount * 0.02;
        } 
        else if (payment instanceof UPIPayment) {
            fee = amount * 0.01;
        } 
        else if (payment instanceof NetBankingPayment) {
            fee = amount * 0.015;
        } 
        else {
            fee = 0;
        }

        return amount + fee;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < n; i++) {

            int paymentType = sc.nextInt();
            double amount = sc.nextDouble();

            Payment payment;

            if (paymentType == 1) {
                payment = new CreditCardPayment();
            } 
            else if (paymentType == 2) {
                payment = new UPIPayment();
            } 
            else {
                payment = new NetBankingPayment();
            }

            double finalAmount = processor.processPayment(payment, amount);

            if (paymentType == 1) {
                System.out.printf("CreditCard %.2f%n", finalAmount);
            } 
            else if (paymentType == 2) {
                System.out.printf("UPI %.2f%n", finalAmount);
            } 
            else {
                System.out.printf("NetBanking %.2f%n", finalAmount);
            }
        }

        sc.close();
    }
}
