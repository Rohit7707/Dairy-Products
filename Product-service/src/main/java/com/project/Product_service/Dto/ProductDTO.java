package com.project.Product_service.Dto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ElementCollection;
import lombok.Data;
import java.util.List;

@Data
@Embeddable
public class ProductDTO {
    private Integer product_id;
    private String name;
    private String brand;
    private String category;
    private double price;
    private String quantity;

    // Embedded list of sellers for this product
    @ElementCollection
    private List<SellerDTO> sellers;
}
