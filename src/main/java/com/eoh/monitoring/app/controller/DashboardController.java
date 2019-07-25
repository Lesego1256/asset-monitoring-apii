/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eoh.monitoring.app.controller;

import com.eoh.monitoring.app.service.DeviceServices;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dumisani
 */

@RestController
@CrossOrigin
@RequestMapping("/dashboard")
public class DashboardController {
    
    private final DeviceServices deviceServices;
    
    @Autowired
    private DashboardController(DeviceServices deviceServices){
        this.deviceServices = deviceServices;
    }
    
    @GetMapping
    public Map dashboardInfo(){
        return deviceServices.dashboardInfo();
    }
}
