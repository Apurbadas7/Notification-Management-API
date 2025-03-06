package com.AD.NotificationManagement.Repository;

import com.AD.NotificationManagement.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends JpaRepository<Notification,Long> {
    List<Notification> findByRecipientEmail(String recipientEmail);

}
