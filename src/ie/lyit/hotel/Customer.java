//Software Implementation Assignment 1
//Shane Mc Daid
//L00117529
//BSc.Computing
//Date: 12/11/17
//Customer Class

package ie.lyit.hotel;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ie.lyit.serialize.CustomerSerializer;

public class Customer extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4838447828100636009L;
	private String emailAddress;
	private int customerNo;
	
	// change static number from private to protected so
	// nextNumber is visible in customerSerializer
	private static int nextNumber = 1;
	


	public Customer() {

		super();
		emailAddress = null;
		customerNo = nextNumber++;

	}
	


	public Customer(String t, String fN, String sN, String a, String p, String e) {
		// TODO Auto-generated constructor stub
		super(t, fN, sN, a, p);
		emailAddress = e;
		//customerNo = nextNumber++;

	}

	public String toString() {
		return super.toString() + "\n Email Address:" + emailAddress + " \n Customer No: " + customerNo;
	}

	public boolean equals(Object obj) {
		Customer cObject;
		if (obj instanceof Customer)
			cObject = (Customer) obj;
		else
			return false;

		return this.customerNo == cObject.customerNo;

	}

	public void setEmail(String eA) {
		emailAddress = eA;
	}

	public String getEmail() {
		return emailAddress;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	// read() - To read a customer from the user
	public void read() {
		JTextField txtCustomerNo = new JTextField();
		txtCustomerNo.setText("" + this.getCustomerNo());
		JTextField txtTitle = new JTextField();
		txtTitle.requestFocus();
		JTextField txtFirstName = new JTextField();
		JTextField txtSurname = new JTextField();
		JTextField txtAddress = new JTextField();
		JTextField txtPhoneNo = new JTextField();
		JTextField txtEmail = new JTextField();

		
		Object[] message = { "Customer Number:", txtCustomerNo, "Title:", txtTitle, "First Name:", txtFirstName,
				"Surname:", txtSurname, "Address:", txtAddress, "Phone Number:", txtPhoneNo, "Email:", txtEmail, };
		

		int option = JOptionPane.showConfirmDialog(null, message, "Enter customer details",
				JOptionPane.OK_CANCEL_OPTION);
		
		Name txtName = new Name(txtTitle.getText(), txtFirstName.getText(), txtSurname.getText());

		if (option == JOptionPane.OK_OPTION) {
			this.name = txtName;
			this.address = txtAddress.getText();
			this.phoneNo = txtPhoneNo.getText();
			this.emailAddress = txtEmail.getText();
		}
	}
}


