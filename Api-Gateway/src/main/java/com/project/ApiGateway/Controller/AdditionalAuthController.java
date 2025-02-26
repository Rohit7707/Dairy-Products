package com.project.ApiGateway.Controller;


import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AdditionalAuthController {

    // Example endpoint for password reset (details would vary)
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> request) {
        // Process password reset using request details.
        // For demo purposes, simply return a success message.
        return ResponseEntity.ok("Password reset link sent to email.");
    }
}
