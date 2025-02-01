package com.muhammet.jpa.service;

import com.muhammet.jpa.entity.Customer;
import com.muhammet.jpa.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // gerekli/zorunlu olan constructor u ekle
public class CustomerService {
    private final CustomerRepository repository;

    public void save(Customer customer){
        repository.save(customer);
    }

    public List<Customer> getAllCustomer(){
        return repository.findAll();
    }

    public List<Customer> getCustomerByName(String name){
        return repository.findAllByName(name);
    }
}
