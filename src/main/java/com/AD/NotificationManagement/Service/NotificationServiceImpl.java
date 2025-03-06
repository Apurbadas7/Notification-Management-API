package com.AD.NotificationManagement.Service;

import com.AD.NotificationManagement.DTO.ResponseDTO;
import com.AD.NotificationManagement.Model.Notification;
import com.AD.NotificationManagement.Repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NotificationServiceImpl implements NotificationService {


    @Autowired
    NotificationRepo notificationRepo;
    @Autowired
    MailService mailService;

    @Override
    public ResponseDTO sendEmail(Notification notification) {
        Notification notification1 = notificationRepo.save(notification);

        String recipient = notification1.getRecipientEmail();
        String message = notification1.getMessage();
        String title = notification1.getTitle();
        try {


            boolean f = mailService.getJavaMailSender(recipient, message, title);
            if (f) {
                System.out.println("send Successfully");
            } else {
                System.out.println("couldn't send");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setRecipientEmail(notification1.getRecipientEmail());
        responseDTO.setMessage(notification1.getMessage());
        responseDTO.setTitle(notification1.getTitle());


        return responseDTO;
    }

    @Override
    public List<Notification> getAllNotification() {
        List<Notification> notification = notificationRepo.findAll();
        return notification;

    }

    @Override
    public List<ResponseDTO> getNotificationByMail(String mail) {
        List<Notification> notifications = notificationRepo.findByRecipientEmail(mail);

        List<ResponseDTO> responseDTOList=new ArrayList<>();
        for(Notification notification:notifications){
            ResponseDTO responseDTO=new ResponseDTO();
            responseDTO.setRecipientEmail(notification.getRecipientEmail());
            responseDTO.setMessage(notification.getMessage());
            responseDTO.setTitle(notification.getTitle());

            responseDTOList.add(responseDTO);
        }
       return responseDTOList;
    }

    @Override
    public ResponseDTO getNotificationById(Long id) {
        Optional<Notification> notifications = notificationRepo.findById(id);
        Notification notification = notifications.get();

        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.setRecipientEmail(notification.getRecipientEmail());
        responseDTO.setMessage(notification.getMessage());
        responseDTO.setTitle(notification.getTitle());






        return responseDTO;
    }

    @Override
    public String deleteNotificationById(Long id) {
        notificationRepo.deleteById(id);
        return "Deleted Successfully";

    }



}
