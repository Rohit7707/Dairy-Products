package com.project.Dashboard_service.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.Dashboard_service.Dto.DashboardProductDTO;
import com.project.Dashboard_service.Dto.SellerDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    // In-memory list for demo purposes
    private final List<DashboardProductDTO> dairyProducts = new ArrayList<>();

    
       
    // GET endpoint: Users can view dashboard products
    @GetMapping("/products")
    public ResponseEntity<?> getDashboardProducts() {
        // Wrap the products in an object with key "dairy_products"
        return ResponseEntity.ok(new DashboardResponse(dairyProducts));
    }

    // POST endpoint: Sellers can add a new product
    @PostMapping("/products")
    public ResponseEntity<DashboardProductDTO> addDashboardProduct(@RequestBody DashboardProductDTO product) {
        dairyProducts.add(product);
        return ResponseEntity.ok(product);
    }

    // Inner class to wrap the response in the expected JSON format
    public static class DashboardResponse {
        private List<DashboardProductDTO> dairy_products;

        public DashboardResponse(List<DashboardProductDTO> dairy_products) {
            this.dairy_products = dairy_products;
        }

        public List<DashboardProductDTO> getDairy_products() {
            return dairy_products;
        }

        public void setDairy_products(List<DashboardProductDTO> dairy_products) {
            this.dairy_products = dairy_products;
        }
    }
}
