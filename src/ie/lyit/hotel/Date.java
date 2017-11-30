package ie.lyit.hotel;

public class Date {
  
	private int day;
	private int month;
	private int year;
	
public Date()
  {
	this.day=0;	
	this.month=0;
	this.year=0;
  }

public Date(int d, int m, int y)throws IllegalArgumentException {
	if(d<1||d>31||m<1||m>12||y<1900||y>2017)
		throw new IllegalArgumentException("Invalid Date");
	this.day=d;
	this.month=m;
	this.year=y;
}

public String toString() {
	return day+" - "+month+" - "+year;
}
@Override
public boolean equals(Object o){
		// First check if o is a null reference to prevent run-time exceptions
		if(o == null) 
      return false;
	
		// Next check if o references the current object, if it does it must be equal
		if (this == o)
			return true;
      
		// Next check if o is in fact a Date object
		if(!(o instanceof Date))
			return false;
		else
		{
			// If none of the above are true, cast o to a Date object so that
         // we can compare the object's instance variables and methods
			Date other = (Date)o;
			
			return (this.day == other.day) &&
				   (this.month == other.month) &&
				   (this.year == other.year);
		}
	}
public void setDay(int nD)throws IllegalArgumentException
{
if(nD<1||nD>31)
	throw new IllegalArgumentException("Invalid day.");
this.day=nD;	
}
public void setMonth(int nM)throws IllegalArgumentException
{
	if(nM<1||nM>12)
		throw new IllegalArgumentException("Invalid month.");
this.month=nM;	
}
public void setYear(int nY)throws IllegalArgumentException
{
	if(nY<1900||nY>2017)
		throw new IllegalArgumentException("Invalid year.");
this.year=nY;	
}
public int getDay()
{
return day;		
	
}
public int getMonth()
{
return month;		
	
}
public int getYear()
{
return year;		
	
}
}
