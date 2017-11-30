//Software Implementation Assignment 1
//Shane Mc Daid
//L00117529
//BSc.Computing
//Date: 12/11/17
//CustomerSerializerTester Class
package ie.lyit.testers;

import java.util.Scanner;

import java.util.InputMismatchException;

import ie.lyit.hotel.Customer;
import ie.lyit.serialize.CustomerSerializer;

public class CustomerSerializerTester {

	public static void main(String[] args) {
		// Call Scanner keyboard
		Scanner kbInt = new Scanner(System.in);

		// Create ArrayList of Customers for Serialization
		// illegal construct
		// Compile Time Error: The constructor CustomerSerializer() is not visible
		// CustomerSerializer customerSerializer = new CustomerSerializer();

		// Get the only object available
		CustomerSerializer customerSerializer = CustomerSerializer.getSingleInstance();

		// display object
		CustomerSerializer.getSingleInstance().displaySingleton();
		CustomerSerializer.getSingleInstance().displaySingleton();

		// initialize option to 0
		int option = 0;

		// Deserialize the ArrayList from the File,
		// i.e. read the customers ArrayList from the file back into the ArrayList
		customerSerializer.readRecordsFromFile();

		/*
		 * NOTE: When entering an option inside the do-while loop, the GUI interface on
		 * either the add() method or edit() method displays behind the eclipse program
		 * on the first loop. When you press the add() or edit method again, the GUI
		 * interface will show up in front of eclipse and will continue as normal until
		 * the user exits the program.
		 * 
		 * Alternatively, You can call the add method just once, outside of the do-while
		 * loop and when you run the menu the add() or edit() methods should appear in
		 * front of ecclipse when chosen
		 */
		// customerSerializer.add();

		do {
			// Print out Menu Options
			// try-catch method
			// try to call menu and enter option
			try {
				System.out.println("Customer Menu \n");
				System.out.println("1. Add \n2. List \n3. View \n4. Edit \n5. Delete \n6. Quit ");
				System.out.println("\n\tEnter Option:");
				option = kbInt.nextInt();

				// Key In option choice
				// switch on the option and call the appropriate method
				switch (option) {

				case 1:
					customerSerializer.add();
					break;// call add() method
				case 2:
					customerSerializer.list();
					break;// call list() method
				case 3:
					customerSerializer.view();
					break;// call view() method
				case 4:
					customerSerializer.edit();
					break;// call edit() method
				case 5:
					customerSerializer.delete();
					break;// call delete method
				case 6:
					System.out.println("Goodbye");
					break;// Exit menu
				default:
					System.out.println("INVALID OPTION...");
				}
			} catch (InputMismatchException e) {
				// catch error caused by non-integer value entered
				System.out.println("Option choice should be an Integer");
				// allow user to enter another menu choice after catching error
				kbInt.next();
			}

		} while (option != 6);// Keep displaying menu until user exits program

		// Serialize the ArrayList to the File
		// i.e. write the customers ArrayList back into the the file
		customerSerializer.writeRecordsToFile();

		// Close scanner class when out of loop
		kbInt.close();

	}
}