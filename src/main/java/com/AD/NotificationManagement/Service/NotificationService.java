package com.AD.NotificationManagement.Service;

import com.AD.NotificationManagement.DTO.ResponseDTO;
import com.AD.NotificationManagement.Model.Notification;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {

    public ResponseDTO sendEmail(Notification notification);
    public List<Notification> getAllNotification();
    public List<ResponseDTO> getNotificationByMail(String mail);
    public ResponseDTO getNotificationById(Long id);
    public String deleteNotificationById(Long id);



}
