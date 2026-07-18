package com.notification.impl;

import com.notification.notification.Notification;
import com.notification.notification.NotificationType;

public class SmsNotification implements Notification {
    @Override
    public void sendNotification(String data) {
        System.out.println("SMS Sent: [ " + data + " ]");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }
}