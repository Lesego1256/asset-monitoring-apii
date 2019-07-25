/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eoh.monitoring.app.respository;

import com.eoh.monitoring.app.model.Notification;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dumisani
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

	
	//this will give us in the related notifications
    @Query("SELECT n FROM Notification n WHERE n.user.id=?1")
    List<Notification> getNotificationByUserId(Long userId);
    
}
