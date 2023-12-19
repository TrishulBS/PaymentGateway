package org.trishul;

import java.util.List;

public interface Client {
    List<Customer> getCustomers();

    List<String> getPaymentModes();

    void addPaymentMode(String name);

    void deletePaymentMode(String name);
    String getClientName();

}
