package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Vendor;

public interface VendorRepository extends MongoRepository<Vendor, String> {
    List<Vendor> findByName(String name);
    List<Vendor> findByType(String type);
}
