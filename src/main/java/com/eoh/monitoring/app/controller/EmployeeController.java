package com.eoh.monitoring.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eoh.monitoring.app.model.User;

import com.eoh.monitoring.app.service.UserServices;

@RestController
@RequestMapping("/employees")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private UserServices service;
    
    @PostMapping("/addEmployee")
    public User createProduct(@RequestBody User em) {
        System.out.println("Inside Create Method");
        return service.createEmployee(em);
    }

    @GetMapping("/findAll")
    public List<User> getAllEmployee() {
        System.out.println("Inside Find All Method");
        System.out.println(service.getAllEmployees());
        return service.getAllEmployees();
    }

    @GetMapping("/getEmployee/{id}")
    public User getEmployee(@PathVariable(value = "id") Long id) {
        return service.getEmployee(id);

    }

    @GetMapping("/login/{email}/{password}")//We are getting it using the hibernate stan
    public User login(@PathVariable String email, @PathVariable String password) {
        return service.loginn(email, password);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<User> updateProduct(@RequestBody User emp) {
        return service.updateEmployee(emp);
    }

    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<User> deleteProduct(User emp) {
        return service.deleteEmployee(emp);
    }

}
