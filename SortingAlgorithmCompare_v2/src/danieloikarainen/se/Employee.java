package danieloikarainen.se;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee implements Cloneable
{

	public static void main(String[] args) 
	{
	}

	public Employee(String pFirstName, String pLastName, GregorianCalendar pHireDay) 
	{
		firstName = pFirstName;
		lastName = pLastName;
		
		hireDay = pHireDay;
	}
		

	public String getFirstName() 
	{
		return firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}
	
	public int getYearOfService()
	{  				
		return (new GregorianCalendar().get(Calendar.YEAR)) - hireDay.get(Calendar.YEAR);
	}
	
	public Employee clone() 
	{
		Employee aClonedEmployee;
		try 
		{
			aClonedEmployee = (Employee) super.clone();
			aClonedEmployee.hireDay = (GregorianCalendar) hireDay.clone();
			return aClonedEmployee;
		} 
		catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isLarger(Employee compareTo)
	{
		if (this.getYearOfService() > compareTo.getYearOfService())
			return true;
		else
			return false;
	}
	
	

	@Override
	public String toString() 
	{
		return "Employee class: Member value:|firstName|" + firstName + " |lastName|" + lastName + "|YearOfService|" + this.getYearOfService();
	}



	private String firstName;
	private String lastName;
	private GregorianCalendar hireDay;
}
