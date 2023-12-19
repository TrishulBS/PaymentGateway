package org.trishul;

public class Customer {
    private String name;
    private CreditCard card;
    private NetBank netBank;
    private UPI upi;

    public Customer(String name){
        this.name = name;
    }

    public void addCard(CreditCard card){
        this.card = card;
    }

    public void addUPI(UPI upi){
        this.upi = upi;
    }

    public void addNetBank(NetBank netBank){
        this.netBank = netBank;
    }

    public String getName() {
        return name;
    }

    public CreditCard getCard() {
        return card;
    }

    public NetBank getNetBank() {
        return netBank;
    }

    public UPI getUpi() {
        return upi;
    }
}
