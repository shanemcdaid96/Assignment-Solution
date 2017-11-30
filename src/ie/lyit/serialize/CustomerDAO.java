package ie.lyit.serialize;

import ie.lyit.hotel.Customer;

public interface CustomerDAO {

	// DAO interface
	// These methods should be overridden in the
	// CustomerSerializer class
	public void readRecordsFromFile();

	public void writeRecordsToFile();

	public void add();

	public void list();

	public Customer view();

	public void edit();

	public void delete();

}
