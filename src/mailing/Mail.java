package mailing;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.Properties;
import java.util.logging.Level;
import javax.mail.Session;

public class Mail {
	static String myEmail=""; //senders email
    static String pswd=""; //password of the above email
    public static void mail(String reciever) throws Exception
    {

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.starttls.required", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        //prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        //prop.setProperty("mail.transport.protocol", "smtp");     
        //prop.setProperty("mail.host", "smtp.gmail.com");
      //  prop.put("mail.smtp.port","587");
        //prop.put("mail.smtp.auth", "true");
        //prop.put("mail.smtp.starttls.enable","true");
        //prop.put("mail.smtp.starttls.required","true");
       //prop.put("mail.smtp.ssl.protocols","TLSv1.2");
       //prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.debug", "true");
      //prop.put("mail.smtp.user", myEmail);
      //prop.put("mail.smtp.host","localhost");
      //prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
       
      //  prop.put("mail.smtp.socketFactory.port", "465");  
      //  prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
      //  prop.put("mail.smtp.socketFactory.fallback", "false");
        
        Session session= Session.getInstance(prop, new Authenticator()
        {
           @Override
           protected PasswordAuthentication getPasswordAuthentication()
           { return new PasswordAuthentication(myEmail,pswd); }
        });
        Message msg= prepareMessage(session,myEmail, reciever);
       // Transport.send(msg);
        Transport trans = session.getTransport("smtp");
        trans.connect("smtp.gmail.com", 587, myEmail,pswd);
        trans.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Successful");
    }
    private static Message prepareMessage(Session session, String myEmail,String reciever)
    {
        try
        {
            Message msg= new MimeMessage(session);
            msg.setFrom(new InternetAddress(myEmail));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
            msg.setSubject("Email sent using Java coding");
           // msg.setText("This email is generated using java code.");
            
            Multipart Content= new MimeMultipart();
            
            MimeBodyPart textBodyPart= new MimeBodyPart();
            textBodyPart.setText("This is an email generated using Java coding");
            
            MimeBodyPart pdf= new MimeBodyPart();
            pdf.attachFile("/home/hp/Downloads/TASK 1- Mailing using Java code.docx"); //add file path of the attachment
            
            Content.addBodyPart(textBodyPart);
            Content.addBodyPart(pdf);
            
            msg.setContent(Content);
            return msg;
        }
        catch(Exception ex)
        {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
}
