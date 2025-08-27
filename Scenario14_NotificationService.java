package com.sample;

interface Notifier {
    void sendNotification(String message, String to);
}
class EmailNotifier implements Notifier {
    @Override
    public void sendNotification(String message, String to) {
        System.out.println("Sending EMAIL to " + to + ": " + message);
    }
}
class SmsNotifier implements Notifier {
    @Override
    public void sendNotification(String message, String to) {
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}

class PushNotifier implements Notifier {
    @Override
    public void sendNotification(String message, String to) {
        System.out.println("Sending PUSH notification to " + to + ": " + message);
    }
}

//Dependency Injection
class NotificationService {
    private final Notifier notifier; // injected

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notify(String message, String to) {
        notifier.sendNotification(message, to);
    }
}


//Usage
public class Scenario14_NotificationService {
    public static void main(String[] args) {
        // Send via Email
        NotificationService emailService = new NotificationService(new EmailNotifier());
        emailService.notify("Welcome to our app!", "user@example.com");

        // Swap to SMS
        NotificationService smsService = new NotificationService(new SmsNotifier());
        smsService.notify("Your OTP is 1234", "+919876543210");

        // Swap to Push Notification
        NotificationService pushService = new NotificationService(new PushNotifier());
        pushService.notify("You have a new message", "user123");
    }
}

