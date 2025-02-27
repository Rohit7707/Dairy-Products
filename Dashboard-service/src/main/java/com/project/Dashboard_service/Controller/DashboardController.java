package com.project.Dashboard_service.Controller;

import com.project.Dashboard_service.Dto.DashboardProductDTO;
import com.project.Dashboard_service.service.DashboardService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/products")
    public List<DashboardProductDTO> getDashboardProducts() {
        return dashboardService.getDashboardProducts();
    }
}
