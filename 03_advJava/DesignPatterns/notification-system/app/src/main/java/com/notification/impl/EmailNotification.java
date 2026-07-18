package com.notification.impl;

import com.notification.notification.Notification;
import com.notification.notification.NotificationType;

public class EmailNotification implements Notification {
    @Override
    public void sendNotification(String data) {
        System.out.println("Email Sent: [ " + data + " ]");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }
}
