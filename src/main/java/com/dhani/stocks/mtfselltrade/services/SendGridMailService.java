package com.dhani.stocks.mtfselltrade.services;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Service
public class SendGridMailService {

    @Value("${sendgrid.api.key}")
    private String sendGridApiKey;

    @Value("${report.mail.to}")
    private String mailTo;

    public void sendEmailWithAttachment(String subject, String content, java.io.File file) throws IOException {
        Email from = new Email("gobind.barick@dhani.com");
        Email to = new Email(mailTo);
        Content emailContent = new Content("text/plain", content);
        Mail mail = new Mail(from, subject, to, emailContent);

        // Attach file
        Attachments attachments = new Attachments();
        attachments.setFilename(file.getName());
        attachments.setType("text/csv");
        attachments.setDisposition("attachment");
        attachments.setContent(Base64.getEncoder().encodeToString(Files.readAllBytes(file.toPath())));
        mail.addAttachments(attachments);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = sg.api(request);

        if (response.getStatusCode() >= 300) {
            throw new RuntimeException("SendGrid email failed: " + response.getBody());
        }
    }
}
