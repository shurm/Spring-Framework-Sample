package bootsample.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import java.lang.reflect.*;

import bootsample.model.Person;

/**
 * Custom Tag class. Gets the value of a field from the Person Class
 * 
 * @author Michael Shur
 *
 */
public class MyTag extends SimpleTagSupport 
{
	//the Person object
	private Person person;

	//the field name whose value is requested
	private String column;

	public void setPerson(Person person) 
	{
		this.person = person;
	}

	public void setColumn(String column) 
	{
		this.column = column;
	}


	public void doTag() throws JspException, IOException 
	{
		String result=null;
		try 
		{
			Field field = Person.class.getDeclaredField(column);
			boolean b = field.isAccessible();
			field.setAccessible(true);
			result = field.get(person).toString();
			field.setAccessible(b);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		getJspContext().getOut().println(result.toString());
	}
}