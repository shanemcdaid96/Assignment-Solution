package ie.lyit.hotel;

import java.io.Serializable;

///implement Serializable to the Name class 
public class Name implements Serializable {

   /**
	 * 
	 */
	private static final long serialVersionUID = -8974721478915759904L;
private String title;
   private String firstName;
   private String surname;
   
   public Name()
   {
	   this.title=null;
	   this.firstName=null;
	   this.surname=null;
	   
   }
   
   public Name(String t, String fN, String sN)
   {
	   this.title=t;
	   this.firstName=fN;
	   this.surname=sN;
   }
   
   public String toString() {
	   return("Name: "+title + "."+ firstName+" "+surname);
   }
   
   public boolean equals(Object obj) {
	  Name naObject;
	  if(obj instanceof Name)
		  naObject=(Name)obj;
	  else 
	   return false;
	  
	  return (this.title.equals(naObject.title)
			  && this.firstName.equals(naObject.firstName)
			  && this.surname.equals(naObject.surname));

	  
   }
   public void setTitle(String newT) {
	   title=newT;
   }
   public void setFirst(String newF) {
	   firstName=newF;
   }
   public void setSurname(String newS) {
	   surname=newS;
   }
   public String getTitle()
   {
	   return title;
   }
   public String getFirst()
   {
	   return firstName;
   }
   public String getSurname()
   {
	   return surname;
   }
   
   public boolean isFemale() {

		  if (this.title.equalsIgnoreCase("Miss")
		      || this.title.equalsIgnoreCase("Mrs")
		      || this.title.equalsIgnoreCase("Ms"))
			  return true;
		  else
			  return false;  
	   }
   
   
}
