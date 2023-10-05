import java.io.Serializable;

//class for take the personal recipient informations to send the mail in current date
public class personal extends SendMail implements  Serializable{
	
	public void SendingRegularMail(String to,String subject,String text,String name) throws Exception {
		SendMail.setSubject(subject);
		SendMail.setTo(to);
		SendMail.setText(text);
		Mail(name,"Personal");
	}	
}	
