package com.sample;

//Checked exception for invalid email addresses
class InvalidEmailException extends Exception {
 public InvalidEmailException(String message) {
     super(message);
 }
}

//Checked exception for server issues
class EmailServerDownException extends Exception {
 public EmailServerDownException(String message) {
     super(message);
 }
}

interface EmailService {
    void sendEmail(String to, String subject, String body)
            throws InvalidEmailException, EmailServerDownException;
}

class SMTPEmailService implements EmailService {

    @Override
    public void sendEmail(String to, String subject, String body)
            throws InvalidEmailException, EmailServerDownException {

        if (to == null || !to.contains("@")) {
            throw new InvalidEmailException("Invalid recipient email: " + to);
        }

        // Simulating a possible server issue
        if (Math.random() < 0.1) {
            throw new EmailServerDownException("SMTP server is down");
        }

        System.out.println("SMTP: Email sent to " + to +
                           " with subject: " + subject);
    }
}

class SendGridEmailService implements EmailService {

    @Override
    public void sendEmail(String to, String subject, String body)
            throws InvalidEmailException, EmailServerDownException {

        if (to == null || !to.contains("@")) {
            throw new InvalidEmailException("Invalid recipient email: " + to);
        }

        // Simulating a possible server issue
        if (Math.random() < 0.1) {
            throw new EmailServerDownException("SendGrid service is down");
        }

        System.out.println("SendGrid: Email sent to " + to +
                           " with subject: " + subject);
    }
}


public class Scenario21_CustomException {
    public static void main(String[] args) {
        EmailService emailService = new SMTPEmailService();

        try {
            emailService.sendEmail("userexample.com", "Hello", "Test body");
        } catch (InvalidEmailException | EmailServerDownException e) {
            System.err.println("Error sending email: " + e.getMessage());
        }
    }
}





