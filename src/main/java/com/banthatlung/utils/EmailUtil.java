package com.banthatlung.utils;
//String from = "mcuong40981@gmail.com";
//        String password = "jrrf ohrn diry vhrp";
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailUtil {
    public static void sendActivationEmail(String toEmail, String activationLink) throws MessagingException {
        // Email configuration
        String host = "smtp.gmail.com";
        String from = "mcuong40981@gmail.com";
        String password = "jrrf ohrn diry vhrp";

        // Set properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        // Create session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        // Create message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject("Xác thực Email của bạn");
        message.setText("Xin chào,\n\nVui lòng nhấp vào liên kết sau để kích hoạt email của bạn:\n" + activationLink + "\n\nTrân trọng,\nĐội ngũ cửa hàng");

        // Send email
        Transport.send(message);
    }
}