package com.notification.notification;

public interface Notification {
    void sendNotification(String data);

    NotificationType getType();
}
