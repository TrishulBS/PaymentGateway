package org.trishul;

import java.util.ArrayList;
import java.util.List;

public class FlipKart implements Client{

    private List<String> paymentModes;
    private String name;
    private List<Customer> customers;
    private int transactionId = 0;

    private PaymentGateway paymentGateway;

    public FlipKart(String name){
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addPaymentGateway(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    @Override
    public List<Customer> getCustomers(){
        return this.customers;
    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    @Override
    public List<String> getPaymentModes(){
        return this.paymentModes;
    }

    @Override
    public String getClientName(){
        return this.name;
    }

    @Override
    public void addPaymentMode(String name){
        this.paymentModes.add(name);
    }

    @Override
    public void deletePaymentMode(String name){
        this.paymentModes.remove(name);
    }

    public boolean makePayment(Customer customer, int amount, String paymentType, String vpa){
        transactionId += 1;
        PaymentTransaction pt = new PaymentTransaction(customer, this, amount, transactionId,paymentType, vpa);
        return paymentGateway.makePayment(pt);
    }

    public boolean makePayment(Customer customer, int amount, String paymentType, String userName, String password){
        transactionId += 1;
        PaymentTransaction pt = new PaymentTransaction(customer, this, amount, transactionId,paymentType, userName, password);
        return paymentGateway.makePayment(pt);
    }

    public boolean makePayment(Customer customer, int amount, String paymentType, int cardNumber, int cvv){
        transactionId += 1;
        PaymentTransaction pt = new PaymentTransaction(customer, this, amount, transactionId,paymentType, cardNumber, cvv);
        return paymentGateway.makePayment(pt);
    }
}
