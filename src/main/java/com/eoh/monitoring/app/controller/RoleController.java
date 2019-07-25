package com.eoh.monitoring.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eoh.monitoring.app.model.Role;
import com.eoh.monitoring.app.service.RoleServices;

@RestController
@RequestMapping("/roles")
@CrossOrigin("*")
public class RoleController {

    @Autowired
    private RoleServices role;

    @GetMapping("/getAllRoles")
    public List<Role> getRoles() {
        return role.getRoles();
    }

}
