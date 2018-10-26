package bootsample.controller;

import java.lang.reflect.Field;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bootsample.model.Person;
import bootsample.service.PersonService;

/**
 * @author Michael Shur
 */
@Controller
public class MainController 
{
	@Autowired
	private PersonService service;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String get(HttpServletRequest request)
	{
		return redirectToIndex(request);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String post(HttpServletRequest request)
	{
		
		Person newPerson = createNewPersonFromFrontEnd(request);
		service.addPerson(newPerson);
		return redirectToIndex(request);
	}
	
	/*
	 * Creates a new Person Object using the values the user entered on the index.jsp page
	 */
	private Person createNewPersonFromFrontEnd(HttpServletRequest request)
	{
		
		Map<String,String[]> parameterMap = request.getParameterMap();
		
		Field [] fields=Person.class.getDeclaredFields();
		
		Person newPerson = null;
		try 
		{
			newPerson = new Person();
			for (Field field : fields) 
			{
				boolean b=field.isAccessible();
				field.setAccessible(true);
				field.set(newPerson, field.getType().cast(parameterMap.get(field.getName())[0]));
				field.setAccessible(b);
		    }
		}
		catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newPerson;
	}
	
	/*
	 * Sends information to the index.jsp page and redirects the user to that same page
	 */
	private String redirectToIndex(HttpServletRequest request)
	{
		request.setAttribute("columns",service.getAttributes());
		request.setAttribute("people",service.getPeople());
		return "index";
	}
}
