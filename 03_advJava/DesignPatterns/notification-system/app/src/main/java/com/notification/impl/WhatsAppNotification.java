package com.notification.impl;

import com.notification.notification.Notification;
import com.notification.notification.NotificationType;

public class WhatsAppNotification implements Notification {

    @Override
    public void sendNotification(String data) {
        System.out.println("WHATSAPP Sent: [ " + data + " ]");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.WHATSAPP;
    }
}
