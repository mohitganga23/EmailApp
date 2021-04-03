import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	
	private String password;
	private int defaultPassLength = 12;
	
	private String email;
	private String alternateEmail;
	private int mailBoxCapacity;
	
	private String department;
	private String companySuffix = "company.com";
	
	//Constructor 
	public Email(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.department = setDepartment();
		
		this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + 
				"@" + this.department + "." + this.companySuffix;
		this.password = randomPassword(this.defaultPassLength);
		this.mailBoxCapacity = 50;		
	}
	
	//Ask for the department
	private String setDepartment() {
		System.out.println("Department codes\n1 for Sales \n2 for Development "
				+ "\n3 for Accounting \n0 for Other\nEnter the department code: ");
		Scanner sc = new Scanner(System.in);
		int deptChoice = sc.nextInt();
		sc.close();
		if (deptChoice == 1) return "sales";
		else if (deptChoice == 2) return "development";
		else if (deptChoice == 3) return "accounting";
		else return "other";
	}
	
	//Random Password Generator
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%*";
		char[] password = new char[length];
		
		for (int i = 0; i < length; i++) {
			int r = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(r);
		}
		
		return new String(password);
	}
	
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}
	
	public void setAltEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailBoxCapacity() { return mailBoxCapacity; }
	
	public String getAltEmail() {return alternateEmail; }
	
	public String getPassword() {return password; }

	public void showInfo() {
		System.out.println("Name: " + firstName+ " " + lastName);
		System.out.println("Department: " + department);
		System.out.println("Email: " + email);
		System.out.println("MailBox Capacity: " + mailBoxCapacity + "mb");
	}
}
	
