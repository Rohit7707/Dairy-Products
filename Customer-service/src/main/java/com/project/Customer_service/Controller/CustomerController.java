package com.project.Customer_service.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.Customer_service.Entity.Customer;
import com.project.Customer_service.Repo.CustomerRepo;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepo customerRepo;
    
    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer saved = customerRepo.save(customer);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long customerId) {
        Customer customer = customerRepo.findById(customerId)
                                        .orElseThrow(() -> new RuntimeException("Customer not found"));
        return ResponseEntity.ok(customer);
    }
}
