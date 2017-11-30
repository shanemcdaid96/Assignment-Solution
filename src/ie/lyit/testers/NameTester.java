package ie.lyit.testers;

import ie.lyit.hotel.Name;
import java.util.ArrayList;
public class NameTester  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Name personA=new Name("Mr","PJ","McDaid");
      Name personB=new Name("Mr","Brad","McDaid");
     
      ArrayList<Name> list=new ArrayList<Name>();
      list.add(new Name("Mr","Shane","McDaid"));
      list.add(new Name("Mr","Jonjo","Shelvey"));
      list.add(personA);
      list.add(personB);
      
      for(Name currentPerson:list)
    	System.out.println(currentPerson);
      
    // if(nameSearch)
      if(nameSearch(personA, list))
  	     System.out.println("FOUND!");
  	   else
  	     System.out.println("NOT FOUND!");
      

      /*
      System.out.println(personA);
      System.out.println(personB);
      
      if(personA.equals(personB))
       System.out.println("Same");
      else
     System.out.println("Not the Same");
      
      if(personA.isFemale())
          System.out.println("Is Female");
         else
        System.out.println("Not Female");*/
      
    	    		 
	}

public static boolean nameSearch(Name nameSearch,ArrayList<Name>list) {
	  
	return list.contains(nameSearch);  
  }
}
