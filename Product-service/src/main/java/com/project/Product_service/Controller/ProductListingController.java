package com.project.Product_service.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.Product_service.Entity.ProductListing;
import com.project.Product_service.Repo.ProductListingRepo;

@RestController
@RequestMapping("/products")
public class ProductListingController {

    private final ProductListingRepo listingRepo;
    
    public ProductListingController(ProductListingRepo listingRepo) {
        this.listingRepo = listingRepo;
    }

    // Seller can add or update their product listing
    @PostMapping("/{sellerId}")
    public ResponseEntity<ProductListing> addOrUpdateProductListing(@PathVariable Long sellerId,
                                                                      @RequestBody ProductListing listing) {
        listing.setSellerId(sellerId);
        ProductListing saved = listingRepo.save(listing);
        return ResponseEntity.ok(saved);
    }

    // Retrieve product listing for a seller (or customer, if needed)
    @GetMapping("/{sellerId}")
    public ResponseEntity<ProductListing> getProductListing(@PathVariable Long sellerId) {
        ProductListing listing = listingRepo.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Product listing not found for sellerId: " + sellerId));
        return ResponseEntity.ok(listing);
    }
}
