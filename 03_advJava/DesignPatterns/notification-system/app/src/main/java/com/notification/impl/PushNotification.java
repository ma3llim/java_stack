package com.notification.impl;

import com.notification.notification.Notification;
import com.notification.notification.NotificationType;

public class PushNotification implements Notification {
    @Override
    public void sendNotification(String data) {
        System.out.println("Push Sent: [ " + data + " ]");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.PUSH;
    }
}
