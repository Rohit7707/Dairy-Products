package com.project.Customer_service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private Long customerId;
    private String name;
    private String email;
    private String address;
    // You can add a field like 'role' to differentiate sellers from regular users.
}
