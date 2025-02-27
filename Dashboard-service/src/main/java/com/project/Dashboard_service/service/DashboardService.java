package com.project.Dashboard_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.Dashboard_service.Dto.DashboardProductDTO;
import com.project.Dashboard_service.Dto.SellerDTO;
import com.project.Dashboard_service.Dto.ProductDTO;

@Service
public class DashboardService {

    private final WebClient webClient;

    public DashboardService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public List<DashboardProductDTO> getDashboardProducts() {
        
        // Fetch product data from Product Service
        List<ProductDTO> products = webClient
                .get()
                .uri("http://localhost:9091/products")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ProductDTO>>() {})
                .block();

        // Process and enhance product data with seller information
        return products.stream().map(product -> {
            List<SellerDTO> sellers = fetchSellersForProduct(product.getProduct_id());
            return new DashboardProductDTO(
                product.getProduct_id(),
                product.getName(),
                product.getBrand(),
                product.getCategory(),
                product.getPrice(),
                product.getQuantity(),
                sellers
            );
        }).collect(Collectors.toList());
    }

    private List<SellerDTO> fetchSellersForProduct(int productId) {
        return webClient
                .get()
                .uri("http://localhost:9092/sellers/product/" + productId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<SellerDTO>>() {})
                .block();
    }
}
