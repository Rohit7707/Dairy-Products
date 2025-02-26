package com.project.Product_service.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

import com.project.Product_service.Dto.ProductDTO;

@Data
@Entity
@Table(name = "product_listings")
public class ProductListing {
    @Id
    private Long sellerId;  // The seller's ID; only sellers can add products

    @ElementCollection
    private List<ProductDTO> products;
}
