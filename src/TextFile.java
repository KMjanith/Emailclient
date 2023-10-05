import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextFile {
	public void WriteToFile(String birthdate) throws IOException {
		String DateMonth[] = birthdate.split("/");         //we are taking only the month and the date to choose right one.
		int ddd = Integer.parseInt(DateMonth[1])+Integer.parseInt(DateMonth[2]);
		SendMail mail = new Mail();
		
		System.out.println("Enter to the following formats(birthday format is case sensetive(ex:- 2018/09/02)):\n" 
				+ "Official: <name>,<email>,<designation>\n"
				+ "Office_friend: <name>,<email>,<designation>,<birth day>\n"
				+ "Personal: <name>,<nick name>,<email>,<birth day>\n");
		
		
		
		FileWriter file = new FileWriter("E:\\viva project\\clientList.txt",true);
		Scanner data = new Scanner(System.in);
		String details;
		System.out.println("If you have done entering, please enter -1 ");
		while(true) {
				
			details = data.nextLine();
				
			if(details.equals("-1")) {
				break;
			}else {
				try {
					file.write(details + "\n");
					String[] A = details.split("\\s*:\\s*");
				
					String[] Q = A[1].split("\\s*,\\s*");
					String DateMonth1[] = Q[3].split("/");         //we are taking only the month and the date to choose right one.
					int ddd1 = Integer.parseInt(DateMonth1[1])+Integer.parseInt(DateMonth1[2]);
						
					if(A[0].equals("Office_friend")) {
						if(ddd1==ddd) {
							System.out.println("this person have birthday today.If you want to send a greeting mail type Yes.otherwise No.");
							String opt = data.nextLine();
							if(opt.equals("Yes")) {
								SendMail.setSubject("Happy Birthday");
								SendMail.setTo(Q[1]);
								SendMail.setText(" Wish you a Happy Birthday "+ Q[0]);
								OfficeFriendData(Q,A);  //adding details to the relevant lists
								System.out.println("sending mail.Please Wait....");
								mail.Mail(Q[0],"Office_friend");    //sending the mail
								System.out.println("successfully sent the mail!!\n");
							}else {
								OfficeFriendData(Q,A);  //adding details to the relevant lists
							}
								
						}else {
							OfficeFriendData(Q,A);  //adding details to the relevant lists
						}
					}		
						
					if(A[0].equals("Personal")) {
						if( ddd1==ddd){
							System.out.println("this person have birthday today.If you want to send a greeting mail type Yes.otherwise No.");
							String opt = data.nextLine();
							if(opt.equals("Yes")) {
								SendMail.setSubject("Happy Birthday");
								SendMail.setTo(Q[2]);
								SendMail.setText("hugs and love on your birthday "+ Q[0]+"("+Q[1]+")");
								PersonalDeta(Q,A);  //adding details to the relevant lists
								System.out.println("sending mail.Please Wait....");
								mail.Mail(Q[0]+"("+Q[1]+")","Personal");    //sending the mail
								System.out.println("successfully sent the mails!!\n");
							}else {
								PersonalDeta(Q,A);  //adding details to the relevant lists
							}
						}else {
							PersonalDeta(Q,A);  //adding details to the relevant lists
						}
					}
					
				}catch(ArrayIndexOutOfBoundsException e)	{
					System.out.println("invalid input or official recipient");
				}
			}
		}
		file.close();
	}
		
	public void OfficeFriendData(String[] data,String[] position) {
		Devider.name1_office_friends.add(data[0]);     //adding informations to the array lists.
		Devider.ResCount.add(new Devider(data[0],data[3],data[1],data[2],position[0]));
		Devider.gmail_office_friends.add(data[1]);
		Devider.birthday_office_friends.add(data[3]);
	}
	
	public void PersonalDeta(String[] data,String[] position) {
		Devider.ResCount.add(new Devider(data[0],data[3],data[2],data[1],position[0]));  //adding informations to the array lists.
		Devider.name1_personal.add(data[0]+"("+data[1]+")");
		Devider.gmail_personal.add(data[2]);
		Devider.birthday__personal.add(data[3]);
	}
}
