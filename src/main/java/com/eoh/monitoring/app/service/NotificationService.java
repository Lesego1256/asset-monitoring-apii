/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eoh.monitoring.app.service;

import com.eoh.monitoring.app.email.MailServer;
import com.eoh.monitoring.app.model.Notification;
import com.eoh.monitoring.app.model.User;
import com.eoh.monitoring.app.respository.NotificationRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dumisani
 */
@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    
    @Autowired
    private  UserServices userServices;

    @Autowired
    private NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> findAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification addNotification(Notification notification) {
        notification.setDateCreated(new Date());
        notification.setStatus(1);
        
        User user = userServices.getEmployee(notification.getUser().getId());
        MailServer.sendRequest(notification.getName(), notification.getDescription(),user.getEmail(), user.getName(), user.getSurname());
        return notificationRepository.save(notification);
    }

    public List<Notification> findNotificationsByUserId(Long userId) {
        return notificationRepository.getNotificationByUserId(userId);
    }
    
    public Notification delete(Long Id){
        Notification notification = notificationRepository.getOne(Id);
         notificationRepository.deleteById(Id);
         return notification;
    }
    
    public Long count(){
        return notificationRepository.count();
    }
}
