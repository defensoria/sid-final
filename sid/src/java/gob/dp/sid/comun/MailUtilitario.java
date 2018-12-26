/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.sid.comun;

import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author JMATOS
 */
public class MailUtilitario {
    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;
    
    public static void sendEmailGmail(List<String> emailTo, 
                                    boolean iscc, 
                                    List<String> emailCC, 
                                    String emailBody ,
                                    String subject) 
                                throws AddressException, MessagingException {
        Utilitarios utilitario = new  Utilitarios();
        
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", utilitario.getProperties(ConstantesUtil.MAIL_GMAIL_PORT));
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");
 
        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
	generateMailMessage = new MimeMessage(getMailSession);
        
        // Enviar a...
	for(String to: emailTo) {
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	}
        
        if(iscc){
            for(String data:emailCC) {
                generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(data));
            }
	}
	generateMailMessage.setSubject(subject);
	//String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
	generateMailMessage.setContent(emailBody, "text/html");
	System.out.println("Mail Session has been created successfully..");
 
	// Step3
	System.out.println("\n\n 3rd ===> Get Session and Send mail");
	Transport transport = getMailSession.getTransport("smtp");
 
	// Enter your correct gmail UserID and Password
	// if you have 2FA enabled then provide App Specific Password
	transport.connect(utilitario.getProperties(ConstantesUtil.MAIL_GMAIL_HOST), 
                            utilitario.getProperties(ConstantesUtil.MAIL_GMAIL_USERNAME),
                            utilitario.getProperties(ConstantesUtil.MAIL_GMAIL_PASSWORD));
	// transport.connect("mail.kapitaltaxi.com", "no-reply@kapitaltaxi.com", "no-repl#2017#$");
	transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
	transport.close();
    }
    
    
    public static  void sendEmail(List<String> emailTo, 
                                    boolean iscc, 
                                    List<String> emailCC, 
                                    String emailBody ,
                                    String subject) 
                                throws AddressException, MessagingException {
	System.out.println("\n 1st=> Setup Mail Server Properties .. enviando");
	Utilitarios utilitario = new  Utilitarios();
	Properties prop = new Properties();
	prop.put("mail.smtp.auth", "true");
	prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", utilitario.getProperties(ConstantesUtil.MAIL_HOST));
	prop.put("mail.smtp.port", utilitario.getProperties(ConstantesUtil.MAIL_PORT));
	prop.put("mail.smtp.ssl.trust", utilitario.getProperties(ConstantesUtil.MAIL_HOST));
	Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(utilitario.getProperties(ConstantesUtil.MAIL_USERNAME), 
                                                    utilitario.getProperties(ConstantesUtil.MAIL_PASSWORD));
            }
        });
        Message message = new MimeMessage(session);
	message.setFrom(new InternetAddress(utilitario.getProperties(ConstantesUtil.MAIL_USERNAME)));
	// Enviar a...
	for(String to: emailTo) {
            message.setRecipients(
            Message.RecipientType.TO, InternetAddress.parse(to));
	}
	// Con copia a...
	if(iscc){
            for(String data:emailCC) {
                message.setRecipients(
		Message.RecipientType.CC, InternetAddress.parse(data));
            }
	}
	
        message.setSubject(subject);
	MimeBodyPart mimeBodyPart = new MimeBodyPart();
	mimeBodyPart.setContent(emailBody, "text/html");
	Multipart multipart = new MimeMultipart();
	multipart.addBodyPart(mimeBodyPart);
	message.setContent(multipart);
	Transport.send(message);
    }
}
