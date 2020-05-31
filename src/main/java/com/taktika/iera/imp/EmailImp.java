package com.taktika.iera.imp;


import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */
@Service
public class EmailImp {

    @Value("${app.sendgrid.templateId}")
    private String templateId;

    @Autowired
    SendGrid sendGrid;
    public String sendEmail(String email) throws IOException {
        Mail mail = prepareMail(email);
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        try {
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            if(response!=null){
                System.out.println("response code from sendgrid"+response.getHeaders());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "error in sent";
        }
        return "mail has been sent check your imbox!";
    }
    public Mail prepareMail(String email){



        Email fromEmail = new Email();
        fromEmail.setEmail("iera.contact.info@gmail.com");
        fromEmail.setName("IERA");

        Email to = new Email();
        to.setEmail(email);

        Content content = new Content("text/plain", "Bienvenido a iEra ! " +
                "Ahora haces parte de una influencia a la economía circular");

        //Personalization personalization = new Personalization();
        //personalization.addTo(to);

        //mail.setTemplateId(templateId);

        Mail mail = new Mail(fromEmail, "Hola !",  to, content);

        return mail;
    }
}