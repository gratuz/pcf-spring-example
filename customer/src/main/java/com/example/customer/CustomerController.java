package com.example.customer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.example.exception.NotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/customer")
@Component
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<Iterable<Customer>> Get() {

        return ResponseEntity.ok(service.Get());
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<Customer> GetOne(@PathVariable(value="id")Long id) {

        return ResponseEntity.ok(service.GetOne(id));
    }

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<Customer> create(@RequestBody @Valid Customer data) {

        return ResponseEntity.ok(service.Create(data));
    }

    @PutMapping(value = "", produces = "application/json")
    public ResponseEntity<Customer> update(@RequestBody @Valid Customer data) {

        return ResponseEntity.ok(service.Update(data));
    }

    @DeleteMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<Long> delete(@PathVariable(value="id") Long id) {

        return ResponseEntity.ok(service.Delete(id));
    }
}