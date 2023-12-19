package org.trishul;

public class ICICIBank implements Bank{
    String name;

    public ICICIBank(String name){
        this.name = name;
    }

    public String getBankName(){
        return this.name;
    }

    public boolean authorizePayment(PaymentTransaction paymentTransaction){
        Client client = paymentTransaction.getClient();
        Customer customer = paymentTransaction.getCustomer();
        if(client.getCustomers().contains(customer)){
            String paymentMethod = paymentTransaction.getPaymentMethod();

            if(paymentMethod == "UPI"){
                System.out.println(customer.getUpi().getVpa() + "here");
                System.out.println(paymentTransaction.getCustomer().getUpi().getVpa() + "here2");
                if(customer.getUpi().getVpa().equals(paymentTransaction.getVpa())){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(paymentMethod == "CreditCard"){
                if(customer.getCard().getCardNumber() == paymentTransaction.getCardNumber() &&
                    customer.getCard().getCvv() == paymentTransaction.getCvv()){
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                if(customer.getNetBank().getPassword() == paymentTransaction.getPassword() &&
                    customer.getNetBank().getUserName() == paymentTransaction.getUserName()){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        else{
            return false;
        }

    }
}
