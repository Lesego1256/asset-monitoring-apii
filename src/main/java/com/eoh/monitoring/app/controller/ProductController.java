package com.eoh.monitoring.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eoh.monitoring.app.model.Product;
import com.eoh.monitoring.app.service.DeviceServices;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProductController {

    //The service acts like a bean
    //application context 
    //all objects are turned into a bean!!
    @Autowired
    private DeviceServices service;

    //Request is the data bytes transmitted in an HTTP message 
    //immediately following the headers if there are any.
    @PostMapping("/addProduct")
    public Product createProduct(@RequestBody Product pro) {
        System.out.println("Inside Create Method");
        System.out.println("Name : " + pro.getName());
        return service.saveProduct(pro);
    }

    @GetMapping("/findAll")
    public List<Product> getAllProducts() {
        return service.getAllProduct();
    }

    @GetMapping("/getUnassignedProds")
    public List<Product> getAllUnAssigned() {
        return service.getAllProduct();
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product pro) {
        return service.updateProduct(pro);
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<Product> deleteProduct(Product pro) {
        return service.deleteProduct(pro);
    }

    @GetMapping("/countAllProducts")
    public Integer countProducts() {
        return service.countAllProducts();
    }

}
