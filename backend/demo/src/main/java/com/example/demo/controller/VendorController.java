package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable String id) {
        Vendor vendor = vendorService.getVendorById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
        return ResponseEntity.ok().body(vendor);
    }

    @GetMapping("/name/{name}")
    public List<Vendor> getVendorsByName(@PathVariable String name) {
        return vendorService.getVendorsByName(name);
    }

    @GetMapping("/type/{type}")
    public List<Vendor> getVendorsByType(@PathVariable String type) {
        return vendorService.getVendorsByType(type);
    }

    @PostMapping
    public ResponseEntity<List<Vendor>> addVendors(@RequestBody List<Vendor> vendors) {
        List<Vendor> createdVendors = vendorService.addVendors(vendors);
        return ResponseEntity.ok(createdVendors);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable String id, @RequestBody Vendor vendorDetails) {
        Vendor updatedVendor = vendorService.updateVendor(id, vendorDetails);
        return ResponseEntity.ok(updatedVendor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable String id) {
        vendorService.deleteVendor(id);
        return ResponseEntity.noContent().build();
    }
}
