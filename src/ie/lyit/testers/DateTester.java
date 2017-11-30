package ie.lyit.testers;

import ie.lyit.hotel.Date;
import java.util.Scanner;
public class DateTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard=new Scanner(System.in);
		Date dateA=new Date();
		boolean goodInput=false;
		do {
			System.out.println("Enter Day:");
			int day=keyboard.nextInt();
			System.out.println("Enter Month:");
			int month=keyboard.nextInt();
			System.out.println("Enter Year:");
			int year=keyboard.nextInt();
		try {
		dateA.setDay(day);
		dateA.setMonth(month);
		dateA.setYear(year);
		System.out.println(dateA);
		goodInput=true;
		}
		catch(IllegalArgumentException e)
		{
		  System.out.println("Date is Invalid.");
		}
		}while(!goodInput);
		
		goodInput=false;
		do {
			System.out.println("Enter Day:");
			int day1=keyboard.nextInt();
			System.out.println("Enter Month:");
			int month1=keyboard.nextInt();
			System.out.println("Enter Year:");
			int year1=keyboard.nextInt();
		try {
		Date dateb=new Date(day1,month1,year1);
		System.out.println(dateb);
		goodInput=true;
		}
		catch(IllegalArgumentException e)
		{
		  System.out.println("Date is Invalid.");
		}
		}while(!goodInput);

		
		 //  if(dateA.equals(dateB))
		//       System.out.println("Same");
		  //    else
		  //   System.out.println("Not the Same");
		keyboard.close();
	}

}
