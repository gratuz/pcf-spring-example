package com.example.customer;

import com.example.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class CustomerService {


    @Autowired
    private CustomerRepository repository;

    public CustomerService(){}

    public Iterable<Customer> Get(){

        return repository.findAll();
    }

    public Customer GetOne(Long id){

        return repository.findById(id).orElseThrow(() -> new NotFoundException(id.toString()));
    }

    public Customer Create(Customer c){

        return repository.save(c);
    }

    public Customer Update(Customer c){
        CustomerService cs =  new CustomerService();

        Customer oldc = repository.findById(c.getId()).orElseThrow(() -> new NotFoundException(c.getId().toString()));
        oldc.setEmail(c.getEmail());
        oldc.setName(c.getEmail());

        return repository.save(oldc);
    }

    public Long Delete(Long id){
        CustomerService cs = new CustomerService();
        repository.delete(repository.findById(id).orElseThrow(() -> new NotFoundException(id.toString())));
        return id;
    }

}
