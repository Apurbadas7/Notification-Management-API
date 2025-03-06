package com.AD.NotificationManagement.Controller;

import com.AD.NotificationManagement.DTO.ResponseDTO;
import com.AD.NotificationManagement.Model.Notification;
import com.AD.NotificationManagement.Service.MailService;
import com.AD.NotificationManagement.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NMController {

    @Autowired
    NotificationService notificationService;
    @Autowired
    MailService mailService;
    @PostMapping("/send")
    public ResponseDTO sendEmail(@RequestBody Notification notification){
        return notificationService.sendEmail(notification);
    }
    @GetMapping("/notifications")
    public List<Notification> getAllNotifications(){
        return notificationService.getAllNotification();
    }

    @GetMapping("/NotificationsByEmail/{email}")
    public List<ResponseDTO> getNotificationByEmail(@PathVariable String email){
        return notificationService.getNotificationByMail(email);
    }
    @GetMapping("/NotificationsById/{id}")
    public ResponseDTO getNotificationByID(@PathVariable Long id){
        return notificationService.getNotificationById(id);
    }

    @DeleteMapping("/DeleteNotification/{id}")
    public String deleteNotification(@PathVariable Long id){

        return notificationService.deleteNotificationById(id);
    }


}
