package com.mdwairy.crm.controller;

import com.mdwairy.crm.dao.MySqlDao;
import com.mdwairy.crm.entity.Customer;
import com.mdwairy.crm.service.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    private ServiceManager service;

    @Autowired
    public CustomerController(ServiceManager service) {
        this.service = service;
    }

    @GetMapping("/")
    public String listCustomers(Model model){
        List<Customer> customers = service.getCustomers();
        model.addAttribute("customers", customers);
        return "customers_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "add_customer_form";
    }

    @PostMapping("/add")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        service.saveCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam("id") int id, Model model){
        Customer customer = service.getCustomer(id);
        model.addAttribute("customer", customer);
        return "add_customer_form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id){
        Customer customer = service.getCustomer(id);
        service.deleteCustomer(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("searchItem") String searchItem, Model model){
        model.addAttribute("customers", service.searchCustomer(searchItem));
        return "customers_list";
    }
}
