package ie.lyit.hotel;

import java.io.Serializable;

///implement Serializable to the Person class 
public abstract class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8133874781500586487L;
	protected Name name;
	protected String address;
	protected String phoneNo;
	
  public Person()
  {
	name=new Name();
	address=null;
	phoneNo=null;
  }
  
  public Person(String t,String fN, String sN, String a, String p)
  {
	 name=new Name(t, fN, sN);
	 address=a;
	 phoneNo=p;
  }
  
  public String toString() {
		return name+" \n Address: "+address+" \n Phone No: "+phoneNo;
	}
  
  public boolean equals(Object obj) {
	  Person pObject;
	  if(obj instanceof Person)
		  pObject=(Person)obj;
	  else 
	   return false;
	  
	  return (name.equals(pObject.name)
			  && address.equals(pObject.address)
			  && phoneNo.equals(pObject.phoneNo));

	  
  }
  public void setName(Name newN) {
	   name=newN;
  }
  public void setAddress(String newA) {
	   address=newA;
  }
  public void setPhoneNo(String newP) {
	   phoneNo=newP;
  }
  public Name getName()
  {
	   return name;
  }
  public String getAddress()
  {
	   return address;
  }
  public String getPhoneNo()
  {
	   return phoneNo;
  }

}
