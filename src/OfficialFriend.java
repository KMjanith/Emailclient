import java.io.Serializable;

//class for take the official friends informations to send the mail in current date
public class OfficialFriend extends SendMail implements Serializable{
	public void SendingRegularMail(String to, String subject, String text, String name) throws Exception {
		SendMail.setSubject(subject);
		SendMail.setTo(to);
		SendMail.setText(text);
		Mail(name,"Office_friend");    //mail sending caller	
	}	
}
