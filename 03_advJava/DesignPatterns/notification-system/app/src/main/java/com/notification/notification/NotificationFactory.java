package com.notification.notification;

import com.notification.impl.*;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class NotificationFactory {
    private static final Map<NotificationType, Supplier<Notification>> REGISTRY = new EnumMap<>(NotificationType.class);

    static {
        REGISTRY.put(NotificationType.SMS, SmsNotification::new);
        REGISTRY.put(NotificationType.EMAIL, EmailNotification::new);
        REGISTRY.put(NotificationType.PUSH, PushNotification::new);
        REGISTRY.put(NotificationType.SLACK, SlackNotification::new);
        REGISTRY.put(NotificationType.WHATSAPP, WhatsAppNotification::new);
    }

    public static Notification create(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException("Notification type cannot be null");
        }
        Supplier<Notification> supplier = REGISTRY.get(type);
        if (supplier == null) {
            throw new IllegalArgumentException("Unknown notification type: " + type);
        }

        return supplier.get();
    }
}