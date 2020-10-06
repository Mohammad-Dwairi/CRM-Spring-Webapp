package com.mdwairy.crm.dao;

import com.mdwairy.crm.entity.Customer;

import java.util.List;

public interface MySqlDao {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);
    Customer getCustomer(int id);
    void deleteCustomer(int id);
    List<Customer> searchCustomer(String searchItem);
}
