package org.trishul;

public class Main {
    public static void main(String[] args) {

        CreditCard card1 = new CreditCard(999999, 222);
        Customer customer1 = new Customer("Trishul");
        customer1.addCard(card1);

        UPI upi1 = new UPI("67898765678");
        Customer customer2 = new Customer("Virat");
        customer2.addUPI(upi1);

        PaymentGateway paymentGateway = new PaymentGateway("RasorPay");

        FlipKart flipKart = new FlipKart("Flipkart");

        flipKart.addCustomer(customer1);
        flipKart.addCustomer(customer2);

        flipKart.addPaymentGateway(paymentGateway);

        ICICIBank bank = new ICICIBank("ICICI");

        paymentGateway.addBank(bank);


        boolean result1 = flipKart.makePayment(customer1, 100, "CreditCard", 999999, 222);
        boolean result2 = flipKart.makePayment(customer2, 100, "UPI", "67865678");

        System.out.println(result1 +" "+ result2);
        paymentGateway.showDistribution();

    }
}