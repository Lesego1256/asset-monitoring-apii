/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eoh.monitoring.app.controller;

import com.eoh.monitoring.app.model.Notification;
import com.eoh.monitoring.app.service.NotificationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dumisani
 */
@RestController
@CrossOrigin
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public List<Notification> findAll() {
        return notificationService.findAllNotifications();
    }

    @GetMapping("/{userId}")
    public List<Notification> getNotificationsByUserId(@PathVariable("userId") Long userId) {
        return notificationService.findNotificationsByUserId(userId);
    }

    @PostMapping
    public Notification addNotification(@RequestBody Notification notification) {
        return notificationService.addNotification(notification);
    }

    @GetMapping("/count")
    public Long count() {
        return notificationService.count();
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> delete(@PathVariable("notificationId") Long id) {

        Notification notification = notificationService.delete(id);

        if (notification != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }
}
