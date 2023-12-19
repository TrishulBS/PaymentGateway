package org.trishul;

public class PaymentTransaction {
    private Customer customer;
    private Client client;
    private int transactionId;
    private String vpa;
    private String userName;
    private String password;
    private  int cardNumber;
    private int cvv;
    private String paymentMethod;
    private int amount;

    public PaymentTransaction(Customer customer, Client client, int amount, int id, String paymentMethod, String vpa){
        this.customer = customer;
        this.client = client;
        this.transactionId = id;
        this.paymentMethod = paymentMethod;
        this.vpa = vpa;
        this.amount = amount;
    }

    public PaymentTransaction(Customer customer, Client client, int amount,int id, String paymentMethod, String userName, String password){
        this.customer = customer;
        this.client = client;
        this.transactionId = id;
        this.paymentMethod = paymentMethod;
        this.userName = userName;
        this.password = password;
        this.amount = amount;
    }

    public PaymentTransaction(Customer customer, Client client, int amount,int id, String paymentMethod, int cardNumber, int cvv){
        this.customer = customer;
        this.client = client;
        this.transactionId = id;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentMethod(){
        return this.paymentMethod;
    }

    public String getVpa() {
        return vpa;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCvv() {
        return cvv;
    }
}
