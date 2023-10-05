import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Desiaralzation extends RecipientsSerialize{
	
	public Desiaralzation(String position, String name, String email, String message, String subject,String date, String time) {
		super(position, name, email, message, subject, date, time);
		
	}
	
	public static void Dserialization(String date1) throws IOException, ClassNotFoundException {
		boolean temp = false;
		try {
			FileInputStream filein = new FileInputStream("E:\\viva project\\PassMailInfo.txt"); //accessing the file
			ObjectInputStream in = new ObjectInputStream(filein);  //readimg the bytestream
			listForSer = (ArrayList) in.readObject();
			in.close(); 
			filein.close(); 
			for(RecipientsSerialize T:listForSer) {
				
				if(T.getDate().equals(date1)) {
					temp = true;
					System.out.println("time: "+ T.getTime()+" , " + "Name:  "+T.getName() +" , "+"Employee type: " + T.getPosition() + " , " + "Subject: " + T.getSubject() + " , " + "Email: " + T.getEmail() );
				}
			}
			if(!temp) {
				System.out.println("No mails sent on that date or invalid input format!\nEnter the option again and input date in correct format");
			}
		}catch(EOFException e) {
			System.out.println("");
		}catch(ClassNotFoundException e) {
			System.out.println("");
		}
	}
	
	public static void PassMailInfo() throws Exception {
			Scanner printer = new Scanner(System.in);
			System.out.println("Date input format ----- yyyy/MM/dd (ex: 2018/09/17)-----\nEnter the Birthday :  ");
			String date1 = printer.nextLine();
			Desiaralzation.Dserialization(date1);
		
	}

}
