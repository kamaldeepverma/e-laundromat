package com.laundrovalley.rest.service;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.laundrovalley.rest.model.Notification;

@Service
public class EmailServiceImpl implements EmailService{

	@Override
	public void sendEmail(Notification notification) {
	
		
		try {
		
			InternetAddress to = new InternetAddress(notification.getRecipientEmail());
			InternetAddress from = new InternetAddress("yashratnani1@gmail.com");
			String subject = notification.getSubject();
			String text = notification.getText();
			
			String password= "yashratnaniyash11";      
			String host = "smtp.gmail.com";  
		                 
			final String username = "yashratnani1@gmail.com";
		      
			  System.out.println("TLSEmail Start"); 
		              
	          Properties properties = System.getProperties();
              properties.setProperty("mail.smtp.host", host); 
              properties.put("mail.smtp.port", "465");  
              properties.put("mail.smtp.starttls.enable", "true");
              properties.put("mail.smtp.auth", "true");  
                
              // SSL Factory 
              properties.put("mail.smtp.socketFactory.class", 
                      "javax.net.ssl.SSLSocketFactory");  
              Session session = Session.getInstance(properties, 
                  new javax.mail.Authenticator() { 
                        
                      protected PasswordAuthentication  
                              getPasswordAuthentication() { 
                          return new PasswordAuthentication(username, 
                                                          password); 
                      } 
                  }); 
        
       
              MimeMessage message = new MimeMessage(session);  
            
              message.setFrom(from); 
            
	          message.addRecipient(Message.RecipientType.TO,to); 
	          message.setSubject(subject); 
	          message.setText(text);
        
          //Transport trans=session.getTransport("smtp");
          
	          Transport.send(message); 
	          System.out.println("Yo it has been sent.."); 
      } 
      catch (MessagingException mex) { 
          mex.printStackTrace(); 
      } 
		
	}

}
