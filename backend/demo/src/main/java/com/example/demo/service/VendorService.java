package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendorById(String id) {
        return vendorRepository.findById(id);
    }

    public List<Vendor> getVendorsByName(String name) {
        return vendorRepository.findByName(name);
    }

    public List<Vendor> getVendorsByType(String type) {
        return vendorRepository.findByType(type);
    }

    public List<Vendor> addVendors(List<Vendor> vendors) {
        return vendorRepository.saveAll(vendors);
    }

    public Vendor addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public Vendor updateVendor(String id, Vendor vendorDetails) {
        Vendor vendor = vendorRepository.findById(id).orElseThrow(() -> new RuntimeException("Vendor not found"));
        vendor.setName(vendorDetails.getName());
        vendor.setType(vendorDetails.getType());
        vendor.setContractPeriod(vendorDetails.getContractPeriod());
        vendor.setContractEnding(vendorDetails.getContractEnding());
        vendor.setLogo(vendorDetails.getLogo());
        return vendorRepository.save(vendor);
    }

    public void deleteVendor(String id) {
        vendorRepository.deleteById(id);
    }
}
