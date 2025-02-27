package com.project.Dashboard_service.Dto;

import lombok.Data;

@Data
public class ProductDTO {
    private int product_id;
    private String name;
    private String brand;
    private String category;
    private double price;
    private String quantity;
}
