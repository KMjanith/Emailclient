import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
	private String CurrentDate;
	private String CurrentTime;

	 public String getCurrentDate() {
		return CurrentDate;
	}

	public void setCurrentDate(String currentDate) {
		CurrentDate = currentDate;
	}

	public String getCurrentTime() {
		return CurrentTime;
	}

	public void setCurrentTime(String currentTime) {
		CurrentTime = currentTime;
	}

	public void GetDateAndTime() {    
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			String[] A = dtf.format(now).split(" "); 
			setCurrentDate(A[0]);
			setCurrentTime(A[1]);
			
		} 
}
