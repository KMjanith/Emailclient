import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RecipientsSerialize implements Serializable{
	
	static ArrayList<RecipientsSerialize> listForSer = new ArrayList<RecipientsSerialize>();
	
	private String position;
	private String name;
	private String email;
	private String message;
	private String subject;
	private String date;
	private String time;
	
	public RecipientsSerialize(String position,String name,String email,String message, String subject,String date,String time) {
		this.email = email;
		this.message = message;
		this.name = name;
		this.position = position;
		this.subject = subject;
		this.date = date;
		this.time = time;
	}
	
	//method to create Email objects
	public void AddObjects(String email, String name, String position, String subject,String messege) {
		DateTime date1 = new DateTime();
		date1.GetDateAndTime();
		listForSer.add(new RecipientsSerialize(position,name,email,message,subject,date1.getCurrentDate(),date1.getCurrentTime()));
	}
	
	
	public static void Serealization(String filename) throws IOException {
		
		FileOutputStream fileout = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(fileout);
		out.writeObject(listForSer);  //use to write the email object to the file
		out.close();  //close Objectoutputstream
		fileout.close();  //close FileOutputStream
		
	}
	
	
	//Dserialization method
	public static void Dserial(String filename) throws IOException, ClassNotFoundException {
		try {
			FileInputStream filein = new FileInputStream(filename); //accessing the file
			ObjectInputStream in = new ObjectInputStream(filein);  //readimg the bytestream
			listForSer = (ArrayList) in.readObject();
			in.close(); //closing the ObjectInputStream
			filein.close(); // closing the FileInputStream
		}catch(EOFException e) {
			System.out.println("");
		}catch(ClassNotFoundException e) {
			System.out.println("");
		}
	}
	

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public String getDate() {
		return date;
	}

	public String getSubject() {
		return subject;
	}

	public String getEmail() {
		return email;
	}

	public String getTime() {
		return time;
	}
}	

