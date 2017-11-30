package ie.lyit.hotel;


public class Employee extends Person implements Payable {
	
	private Date dob;
	private Date startDate;
	private double salary;
	private int number;
	
	private static int nextNumber=1;
	
	private final double MAX_SALARY=150000; 
	public Employee()
	{
		super();
		dob=new Date();
		startDate=null;
		salary=0.0;
		number=nextNumber++;
		
	}
	
	public Employee(String t,String fN, String sN,String a,String p,int d,int m, int y,Date startDate, double s)
	{
		super(t,fN,sN,a,p);
		dob=new Date(d,m,y);
		this.startDate=startDate;
		salary=s;
		number=nextNumber++;
		
	}
	
	  public String toString() {
			return super.toString()+"\n"+dob+" \n "+startDate+" \n "+"€."+salary+" \n "+number;
		}
	  
	  
	  public boolean equals(Object obj) {
		 Employee  eObject;
		  if(obj instanceof Employee)
			  eObject=(Employee)obj;
		  else 
		   return false;
		  
		  return  this.number==eObject.number;

		  
	  }
	  
	  public void setStartDate(Date sD)
	  {
		  startDate=sD;
	  }
	  
	  public void setDOB(Date dateofBirth){
			dob=dateofBirth;
		}
	  
	  public void setSalary(double s)
	  {
		  salary=s;
	  }
	  
	public Date getDOB()
	{
		return dob;
	}
	
	public Date getStartDate()
	{
		return startDate;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	@Override
	public double calculateWage(double taxPercentage) {
		// TODO Auto-generated method stub
		double wage=salary/12;
		wage-=(wage=(taxPercentage/100));
		return wage;
	}

	@Override
	public double incrementSalary(double incrementAmount) {
		// TODO Auto-generated method stub
		salary=incrementAmount;
		if(salary>MAX_SALARY)
			salary=MAX_SALARY;
		
		return salary;
	}

}
