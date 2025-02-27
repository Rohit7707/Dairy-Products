package com.project.Dashboard_service.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class DashboardProductDTO {
    private int product_id;
    private String name;
    private String brand;
    private String category;
    private double price;
    private String quantity;
    private List<SellerDTO> sellers;
}
