package bootsample.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	private String name;	
	
	public boolean equals(Object o)
	{
		Person p=(Person)o;
		
		if(p.name.equals(name))
			return true;
		return false;
	}


	/*ADD NEW STRING VARIABLES HERE. 
	 * 
	 * Example: String address
	 * */

	
	
}
