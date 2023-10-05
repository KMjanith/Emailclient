import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//class for send mail on user inputs

public class Mail extends SendMail{
	private String to;
	private String subject;
	private String text;
	
	public void Mail1() throws IOException{
		
		Scanner moon = new Scanner(System.in); 
		//recipients adress
		System.out.println("Enter the recipient gmail adress:");
		to = moon.nextLine();
			
		//subject
		System.out.println("Enter the subject:");
		subject = moon.nextLine();
			
		//text
		System.out.println("Enter the message:");
		text = moon.nextLine();
		
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
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(text);
			
			try {
				System.out.println("sending email.please wait...");
				Transport.send(message);
				RecipientsSerialize Res = new RecipientsSerialize(null,null,null,null,null,null,null);
				Res.AddObjects(to,"*CUSTOM EMAIL","*NO",subject,text);  //Emailobject
				//serializing the emal object
				RecipientsSerialize.Serealization("E:\\viva project\\PassMailInfo.txt");
				System.out.println("message send successfully");
				
			}catch(SendFailedException t) {
				System.out.println("Invalid gmail address! please check");
			}
				
		} catch (MessagingException mex) {
	        mex.printStackTrace();
	    }			
	}	
}
