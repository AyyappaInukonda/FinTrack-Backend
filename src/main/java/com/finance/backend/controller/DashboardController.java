package com.finance.backend.controller;

import com.finance.backend.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/summary")
    public Map<String, Object> getSummary() {
        return dashboardService.getSummary();
    }

    @GetMapping("/category")
    public Map<String, Double> getCategoryData() {
        return dashboardService.getCategoryData();
    }
}