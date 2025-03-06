package com.AD.NotificationManagement.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 255)
    private String title;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String message;

    @Column(nullable = false,length = 255)
    private String recipientEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status=Status.pending;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAT;


    public enum Status{
        sent,
        pending,
        failed

    }






}
