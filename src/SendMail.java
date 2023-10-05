import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//super class send mail
public class SendMail {
	private static String to;  //recipient's gmail address
	private static String subject;
	private static String text;
	
	public void Mail(String name,String position){  //this name is the sepearted text to get the name 
			
		//sender's gmail address
		String from = "kavindujanith4436@gmail.com";
			
		//smtp host address;
		String host = "smtp.gmail.com";
			
		//get properties
		Properties properties = System.getProperties();
			
		//setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465" );
		properties.put("mail.smtp.ssl.enable", "true" );
		properties.put("mail.smtp.auth", "true" );
		
		//get session object and pass the username and password
		Session session = Session.getInstance(properties,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("kavindujanith4436@gmail.com", "varuzoaodiejmwpt");
	           }
		});
			
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(getTo()));
			message.setSubject(getSubject());
			message.setText(getText());
				
			try {

				Transport.send(message);
				RecipientsSerialize Res = new RecipientsSerialize(null,null,null,null,null,null,null);
				Res.AddObjects(to,name,position,subject,text);  //Emailobject
				//serializing the email object
				try {
					RecipientsSerialize.Serealization("E:\\viva project\\PassMailInfo.txt");
				} catch (IOException e) {
					e.printStackTrace();
				}
				//System.out.println("message send successfully");
				
			}catch(SendFailedException t) {
				System.out.println("Invalid gmail address! please check");
			}
				
		} catch (MessagingException mex) {
	        mex.printStackTrace();
	    }		
	}

	public static String getTo() {
		return to;
	}

	public static void setTo(String to) {
		SendMail.to = to;
	}

	public static String getSubject() {
		return subject;
	}

	public static void setSubject(String subject) {
		SendMail.subject = subject;
	}

	public static String getText() {
		return text;
	}

	public static void setText(String text) {
		SendMail.text = text;
	}

}

