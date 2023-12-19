package org.trishul;

public interface Bank {
    boolean authorizePayment(PaymentTransaction paymentTransaction);
    String getBankName();
}
