package br.com.gvdexport.util;

import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.omnifaces.util.Messages;

@RequestScoped
public class EnviadorEmail {

	public void sendMail(String remetente, String senha, String destinatario,String msg,String assunto){
		
		Properties props = new Properties();
		props.put("mail.smtp.user", remetente);
		props.put("mail.smtp.host", "smtp.office365.com"); 
        props.put("mail.smtp.port", "25"); 
        props.put("mail.debug", "true"); 
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable","true"); 
        props.put("mail.smtp.EnableSSL.enable","true");

        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
        props.setProperty("mail.smtp.socketFactory.fallback", "true");   
        props.setProperty("mail.smtp.port", "587");   
        props.setProperty("mail.smtp.socketFactory.port", "587");

        Session session = Session.getDefaultInstance(props, 
        		new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication()
		{
			return new PasswordAuthentication(remetente, senha);
		}
        });

        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
        	message.setFrom(new InternetAddress(remetente));

        	Address[] toUser = InternetAddress.parse(destinatario);
        	
        	message.setRecipients(Message.RecipientType.TO, toUser);
        	
        	message.setSubject(assunto);
        	
        	message.setText(msg);
        	
        	Transport.send(message);
        	Messages.addGlobalInfo("Email de solicitação Liberação, enviada com Sucesso !");
        	return;
        } catch (MessagingException e) {
        	Messages.addGlobalError("Ocorreu erro no envio da Mensagem ao Almoxarifado !");
			e.printStackTrace();
			return;
		}
	
	}
}


