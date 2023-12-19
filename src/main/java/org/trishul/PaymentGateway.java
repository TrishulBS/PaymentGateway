package org.trishul;

import java.util.List;

public class PaymentGateway {
    private String name;
    private List<Client> clients;
    private List<String> paymentModes;

    private int upiCount;
    private int creditCardCount;
    private int netBankCount;

    private int allUpiCount;
    private int allCreditCardCount;
    private int allNetBankCount;

    private Bank bank;

    public void addBank(Bank bank){
        this.bank = bank;
    }
    public PaymentGateway(String name){
        this.name = name;
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public void deleteClient(Client client) throws Exception{
        if(clients.contains(client)){
            clients.remove(client);
            System.out.println("Client Removed Successfully");
        }
        else{
            System.out.println("Client Not Found");
            throw new Exception("Client not found");
        }
    }

    public void addPaymentMode(String name) throws Exception{
        if(paymentModes.contains(name)){
            System.out.println("Payment Mode already exist");
            throw new Exception("Payment Mode already exist");
        }
        paymentModes.add(name);
        System.out.println("Payment Mode Added Successfully");
    }

    public void addPaymentMode(String name, String clientName) {
        for(Client client: clients){
            if(client.getClientName() == clientName){
                client.addPaymentMode(name);
                System.out.println("Payment method added successfully to the client");
                break;
            }
        }
    }

    public void deletePaymentMode(String name) throws Exception{
        if(paymentModes.contains(name) == false){
            System.out.println("Payment Mode does not exist to delete");
            throw new Exception("Payment Mode does not exist to delete");
        }
        else{
            paymentModes.remove(name);
            System.out.println("Payment Mode Deleted");
        }
    }

    public void deletePaymentMode(String name, String clientName) {
        for(Client client: clients){
            if(client.getClientName() == clientName){
                client.deletePaymentMode(name);
                System.out.println("Payment method deleted successfully from the client");
                break;
            }
        }
    }

    public Boolean hasPaymentMode(String name){
        return paymentModes.contains(name);
    }

    public Boolean makePayment(PaymentTransaction pt){
        boolean res;
        if(pt.getPaymentMethod() == "CreditCard"){
            this.allCreditCardCount+=1;
            res =  bank.authorizePayment(pt);
            if(res==true){
                this.creditCardCount+=1;
            }
            return res;


        }
        else if(pt.getPaymentMethod() == "UPI"){
            this.allUpiCount+=1;
            res =  bank.authorizePayment(pt);
            if(res==true){
                this.upiCount+=1;
            }
            return res;
        }
        else{
            this.allNetBankCount+=1;
            res =  bank.authorizePayment(pt);
            if(res==true){
                this.creditCardCount+=1;
            }
            return res;
        }
    }

    public void showDistribution(){
        System.out.println("Number of Successful UPI Payments: "+this.upiCount);
        System.out.println("Number of All UPI Payments: "+this.allUpiCount);
        System.out.println("Number of Successful Credit Card Payments: "+this.creditCardCount);
        System.out.println("Number of All Credit Card Payments: "+this.allCreditCardCount);
        System.out.println("Number of Successful Netbank Payments: "+this.netBankCount);
        System.out.println("Number of All Netbank Payments: "+this.allNetBankCount);
    }

}
