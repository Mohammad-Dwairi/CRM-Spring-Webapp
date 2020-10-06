package com.mdwairy.crm.service;

import com.mdwairy.crm.entity.Customer;

import java.util.List;

public interface ServiceManager {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomer(int id);
    void deleteCustomer(int id);
    List<Customer> searchCustomer(String searchItem);
}
