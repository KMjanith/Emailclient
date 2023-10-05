import java.util.TimerTask;

public class AutoMailSender extends TimerTask{
	public void run() {
		System.out.println("sending greeting mails for today.Please Wait....");
		try {
			DateTime Date = new DateTime();  //instance of date time class
			Date.GetDateAndTime();  //setting current date and time
			String formattedDate11 = Date.getCurrentDate();
			//calling devider class to send mail on current date
			Devider.AutoMailSender(formattedDate11);
		} catch (Exception e1) {
			e1.printStackTrace();
		}      
		System.out.println("successfully sent the mails!!\n");
	}
}
