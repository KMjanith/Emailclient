import java.util.Timer;
import java.util.TimerTask;

public class TimeShedule {
	public void Shedular() {
		TimerTask Clean = new AutoMailSender();   
		Timer timer  = new Timer();
		timer.scheduleAtFixedRate(Clean,  0, 86400000);
	}
}
