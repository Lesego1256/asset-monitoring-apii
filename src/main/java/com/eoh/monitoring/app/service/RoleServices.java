package com.eoh.monitoring.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eoh.monitoring.app.model.Role;
import com.eoh.monitoring.app.respository.RoleRepository;

@Service
public class RoleServices {

    @Autowired
    private RoleRepository repo;

    public List<Role> getRoles() {
        return repo.findAll();
    }
}
