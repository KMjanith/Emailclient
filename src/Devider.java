import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//class of loading information to the application
//helps to find the right recipients to send the birthday greeting mails.

public class Devider implements Serializable,DevierParent{
	
	private static String line;
	private String name;
	private String NickOrPosi;
	private String birthday;
	private String email;
	private String EmployeeType;
	
	Devider(String name,String birthday,String email,String NickOrPosi,String position) {
		this.email = email;
		this.name = name;
		this.birthday = birthday;
		this.NickOrPosi = NickOrPosi;
		this.EmployeeType = position;
	}
	
	public String getName() {
		return name;
	}


	public String getNickOrPosi() {
		return NickOrPosi;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getEmail() {
		return email;
	}

	public String getEmployeeType() {
		return EmployeeType;
	}

	static List<Devider> ResCount = new ArrayList<>();  //list to store the recipients
	
	static List<String> name1_personal = new ArrayList<String>();  		//list for store the names of the personals recipients
	static List<String> name1_office_friends = new ArrayList<String>(); 	//list for store the names of the office_friends recipients
	static List<String> gmail_personal = new ArrayList<String>();  		//list for store the gmails of the personals recipients
	static List<String> gmail_office_friends = new ArrayList<String>(); 	////list for store the gmails of the office_friends  recipients
	static List<String> birthday__personal = new ArrayList<String>();  	//list for store the birthdays of the personals recipients
	static List<String> birthday_office_friends = new ArrayList<String>(); //list for store the birthdays of the office_friends recipients
	 
	static Scanner moon = new Scanner(System.in);
	
	public void ReadFromFile(){
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("E:\\viva project\\clientList.txt")); //reading from the same file
			try {
				
				while((line = reader.readLine())!= null) {
					String[] l = line.split("\\s*:\\s*");  //spliting by ":"
					String[] Q = l[1].split("\\s*,\\s*");  //splitting by ","
					
					if(l[0].equals("Office_friend")) {    //if recipient is a office friend add the informaion to the relevent lists
						ResCount.add(new Devider(Q[0],Q[3],Q[1],Q[2],l[0]));
						gmail_office_friends.add(Q[1]);
						name1_office_friends.add(Q[0]);
						birthday_office_friends.add(Q[3]);
						
					}
					else if(l[0].equals("Personal")) {  //if recipient is a Personal add the informaion to the relevent lists
						ResCount.add(new Devider(Q[0],Q[3],Q[2],Q[1],l[0]));
						name1_personal.add(Q[0]+"{"+Q[1]+")");
						gmail_personal.add(Q[2]);
						birthday__personal.add(Q[3]);
						
					}	
				}
				reader.close();
				
				//serializing all the recipients objects in the client list file
				//optional,this for backup
				FileOutputStream fileout = new FileOutputStream("E:\\viva project\\RecipientsDetails.txt");
				ObjectOutputStream out = new ObjectOutputStream(fileout);
				out.writeObject(ResCount);  
				out.close();  
				fileout.close();  
				
			} catch (ArrayIndexOutOfBoundsException f) {
				System.out.println("ArrayIndexOutOfBound");
			}catch (IOException e) {
				//e.printStackTrace();
				System.out.println("IO Error");
			}
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("No such a file found!");
		}		
	}
	
	//configer who are the birthday celebreties today
	public static void AutoMailSender(String date) throws Exception {     //taking the current date as the parameter
		String DateMonth[] = date.split("/");         //we are taking only the month and the date to choose right one.
		                                              //splitting the current date
		int ddd2 = Integer.parseInt(DateMonth[1])+Integer.parseInt(DateMonth[2]);
		
		for(int i=0;i<birthday__personal.size();i++) {       //checking for personal recipients
			String DateSelector[] = birthday__personal.get(i).split("/");   //splitting the birth  date
			int ddd3 = Integer.parseInt(DateSelector[1])+Integer.parseInt(DateSelector[2]);
			if(ddd2==ddd3){
				personal obj3 = new personal();
				obj3.SendingRegularMail(gmail_personal.get(i),"Happy Birthday", "hugs and love on your birthday "+ name1_personal.get(i),name1_personal.get(i));
			}
		}
		
		for(int j=0;j<birthday_office_friends.size();j++) {   //checking for official recipients
			String DateSelector[] = birthday_office_friends.get(j).split("/");
			int ddd3 = Integer.parseInt(DateSelector[1])+Integer.parseInt(DateSelector[2]);
			if(ddd2==ddd3) {
				OfficialFriend obj4 = new OfficialFriend();
				obj4.SendingRegularMail(gmail_office_friends.get(j),"Happy Birthday", " Wish you a Happy Birthday "+ name1_office_friends.get(j),name1_office_friends.get(j));
			}
		}
		
		//RecipientsSerialize.Serealization("E:\\viva project\\PassMailInfo.txt");
	}
	

	//method for printing the names of recipients who have birthdays in hiven date
	public static void per_birth() {   
		 
		 System.out.println("BirthDay input format ------ yyyy/MM/dd (ex: 2018/09/17)-------\nEnter the Birthday :  ");
		 String birthday_0 = moon.nextLine();
		 String DateMonth[] = birthday_0 .split("/");  //we are taking only the month and the date to choose right one.
		                                                     //splitting the current date
		 int ddd2 = Integer.parseInt(DateMonth[1])+Integer.parseInt(DateMonth[2]);
		 int temp = 0;
		 
		//for loop for printing the office recipients who have birthdays
		 for (int i=0;i<birthday_office_friends.size();i++) {     
			 String DateSelector[] = birthday_office_friends.get(i).split("/");    //splitting the birth  date
			 int ddd3 = Integer.parseInt(DateSelector[1])+Integer.parseInt(DateSelector[2]);
			 if(ddd2==ddd3){
		    	 temp = 1;
		    	 System.out.println("office friend - " + name1_office_friends.get(i));
		     }
		 }
		 
		//for loop for print the names of personals
		 for (int j=0;j<birthday__personal.size();j++) {      
			 String DateSelector[] = birthday__personal.get(j).split("/");     //splitting the birth  date
			 int ddd3 = Integer.parseInt(DateSelector[1])+Integer.parseInt(DateSelector[2]);
			 if(ddd3==ddd2){
		    	 temp =1;
		    	 System.out.println("personal - " + name1_personal.get(j));
		     }
		 }
		 
		 if(temp==0) {
			 System.out.println("No birthdays on given date or invalid input format !!");
		 }
	 }
	
	//printing the number of recipients in the application
	public static void RecipientsCount() {
		System.out.println("number of recipient objects in the application: " + ResCount.size());
	}
	
}

