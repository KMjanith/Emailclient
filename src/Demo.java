import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Demo {
	
	//main method
	//static String formattedDate11;
	public static void main(String[] args) {
		TimeShedule time = new TimeShedule();
		try (Scanner sun = new Scanner(System.in)) {
			
			String option = "";           //varibale for getting the option number 
			DateTime Date = new DateTime();  //instance of date time class
			Date.GetDateAndTime();  //setting current date and time
			String formattedDate11 = Date.getCurrentDate(); //taking the date of today
			System.out.println("Hi..Today is: " + formattedDate11);
			
			//loading the pass mail info to the application
			try {
				RecipientsSerialize.Dserial("E:\\viva project\\PassMailInfo.txt");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			DevierParent devider = new Devider(null, null, null, null, null);  //instance to load data to the application
			devider.ReadFromFile();         //calling deviderclass to load data to the application
			
			
			time.Shedular(); //sending automatic mails for today
			System.out.println("Enter option type: \n"
					 + "1 - Adding a new recipient\n"
					 + "2 - Sending an email\n"
					 + "3 - Printing out all the recipients who have birthdays on given date\n"
					 + "4 - Printing out details of all the emails sent\n"
					 + "5 - Printing out the number of recipient objects in the application\n");
			
			
			boolean temp = true;
			while(temp) {
				try {
					System.out.println("\nEnter the option");
					option = sun.nextLine();
				}catch (InputMismatchException f) {
					System.out.println("invalid input Enter a valid input");
				}catch(NoSuchElementException s) {
					System.out.println("");
				}
					try {
							switch(option) { 
							case "1":                              //to enter the data onto the ClientList text file
								TextFile file = new TextFile();     
								file.WriteToFile(formattedDate11);
								break;
									
							case "2":                  //to send the custom input email with subject and Text
								System.out.println("Enter email address,subject and body to send the mail\n");    
								Mail birthdaymail = new Mail();
								birthdaymail.Mail1();
								
								break;
									
							case "3":            //printing the names of the people who have birthday in given date
								System.out.println("Printing out all the recipients who have birthdays in given date");
								Devider.per_birth(); 
								break;
									
							case "4":                           //printing the sent email data on a given date
								System.out.println("Printing out details of all the emails sent on given date");
								try {
									Desiaralzation.PassMailInfo();
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
									
							case "5":          //printing how many member objects in the application
								System.out.println("Printing out the number of recipient objects in the application");
								Devider.RecipientsCount();
								break;
									
							default:       //if user inputs a incalid option value then it will end up the programme
								System.out.println("invalid input Enter a valid input");
								//temp = false;
									
							}
					} 
					catch (IOException e) {
					System.out.println("invalid input");
				}
					catch(ArrayIndexOutOfBoundsException r) {
						System.out.println("invalid input");
					}
			}
		}	
	}
}

