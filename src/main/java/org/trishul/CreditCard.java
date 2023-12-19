package org.trishul;

public class CreditCard {
    private int cardNumber;
    private int cvv;

    public CreditCard(int cardNumber, int cvv){
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    public int getCardNumber(){
        return this.cardNumber;
    }

    public int getCvv(){
        return this.cvv;
    }
}
