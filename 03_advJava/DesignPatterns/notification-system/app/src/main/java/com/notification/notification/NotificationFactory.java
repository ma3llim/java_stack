package com.notification.notification;

import com.notification.impl.*;

public class NotificationFactory {
    public static Notification create(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException("Notification type cannot be null");
        }
        switch (type) {
            case SMS -> {
                return new SmsNotification();
            }
            case EMAIL -> {
                return new EmailNotification();
            }
            case PUSH -> {
                return new PushNotification();
            }
            case SLACK -> {
                return new SlackNotification();
            }
            case WHATSAPP -> {
                return new WhatsAppNotification();
            }
            default -> throw new IllegalArgumentException("Unknown notification type: " + type);
        }

    }
}
