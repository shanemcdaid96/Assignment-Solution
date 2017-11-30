//Software Implementation Assignment 1
//Shane Mc Daid
//L00117529
//BSc.Computing
//Date: 12/11/17
//CustomerSerializer Class

//new package added to Hotel System
package ie.lyit.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import ie.lyit.hotel.Customer;

public class CustomerSerializer implements CustomerDAO {
	// CustomerSerializer implements the CustomerDAO
	// Declare Arraylist called customers - for storing a list of customers
	private ArrayList<Customer> customers;

	// Constant FILENAME for the file to be created
	final String FILENAME = "customers.ser";

	// create an object of CustomerSerializer
	private static CustomerSerializer singleInstance = new CustomerSerializer();

	// Default Constructor
	// make the constructor private so that this class cannot be
	// instantiated
	private CustomerSerializer() {
		// customers = new ArrayList<Customer>();
		System.out.println("Ok- Inside CustomerSerializer Class Constructor...");

	}

	// Get the only object available
	public static CustomerSerializer getSingleInstance() {
		if (singleInstance == null) {
			singleInstance = new CustomerSerializer();
			System.out.println("Ok-single object created: " + singleInstance);
		}
		return singleInstance;

	}

	public void displaySingleton() {
		System.out.println("Singleton object: " + singleInstance);
	}

	/*
	 * Method Name : add() Return Type void Parameter : None Purpose : Read one
	 * Customer record from the user and adds it to the customers Arraylist
	 */
	public void add() {
		// Create a Customer Object
		Customer customer = new Customer();
		// Call read() method and read customer details
		customer.read();
		// And add it to the customers ArrayList
		customers.add(customer);

	}

	/*
	 * Method Name : view() Return Type void Parameter : None Purpose : Displays the
	 * required Customer record on screen and return it, or null if not found
	 */
	public Customer view() {

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		// Read the number of the customer to be viewed from the user
		System.out.println("ENTER CUSTOMER NUMBER: ");
		int customerToView = keyboard.nextInt();

		// for every Customer object in customers
		for (Customer tmpCustomer : customers) {
			// if it's number equals the number of the tmpCustomer
			if (tmpCustomer.getCustomerNo() == customerToView) {
				// display it
				System.out.println(tmpCustomer);
				return tmpCustomer;
			}

		}

		// if we reach this code the book was not found so return null
		return null;
	}

	/*
	 * Method Name : list() Return Type void Parameter : None Purpose : Lists all
	 * Customer records in the ArrayList
	 */
	public void list() {
		// for every Customer object in customers
		for (Customer tmpCustomer : customers) {
			// display it
			System.out.println(tmpCustomer);
		}
	}

	/*
	 * Method Name : edit() Return Type void Parameter : None Purpose : Edits the
	 * required Customer in customers
	 */
	public void edit() {
		// Call view() to find, display, & return the customer to edit
		Customer tempCustomer = view();
		// If the customer != null, i.e. it was found then...
		if (tempCustomer != null) {
			// get it's index
			int index = customers.indexOf(tempCustomer);
			// read in a new customer and...
			tempCustomer.read();

			// reset the object in customers
			customers.set(index, tempCustomer);

		}
	}

	/*
	 * Method Name : delete() Return Type void Parameter : None Purpose : Deletes
	 * the required Customer from customers
	 */
	public void delete() {
		// Call view() to find, display, & return the customer to delete
		Customer tempCustomer = view();
		// If the customer != null, i.e. it was found then...
		if (tempCustomer != null)
			// ...remove it from customers
			customers.remove(tempCustomer);

	}

	/*
	 * Method Name : writeRecordsToFile() Return Type void Parameter : None Purpose
	 * : Writes the ArrayList customers to the File Customers.ser before closing the
	 * file
	 */
	public void writeRecordsToFile() {

		try {
			// Serialize the ArrayList
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			ObjectOutputStream os = new ObjectOutputStream(fileStream);

			os.writeObject(customers);
			os.close();
		} catch (FileNotFoundException f) {
			System.out.println("Cannot Create File to Store Books");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	/*
	 * Method Name : readRecordsToFile() Return Type void Parameter : None Purpose :
	 * Reads the ArrayList from the File Customers.ser back into customers before
	 * closing the file
	 */
	@SuppressWarnings("unchecked")
	public void readRecordsFromFile() {

		// create variable int tmpNumber
		// int tmpNumber = 0;

		try {
			// Deserialize the ArrayList
			FileInputStream fileStream = new FileInputStream(FILENAME);
			ObjectInputStream is = new ObjectInputStream(fileStream);

			customers = (ArrayList<Customer>) is.readObject();

			// When reading the records to the file
			// tmpNumber equals size of ArrayList + 1
			// next customer number equals tmpNumber
			// tmpNumber=customers.size()+1;
			// nextNumber=tmpNumber;

			is.close();

		} catch (FileNotFoundException f) {
			System.out.println("Cannot Find File to Read");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
