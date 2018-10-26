package bootsample.service;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootsample.dao.PersonRepository;
import bootsample.model.Person;

/* Singleton */
@Service
public class PersonService 
{
	@Autowired
	private PersonRepository repository;
	
	private Person lastPersonAdded;
	
	
	public List<Person> getPeople()
	{
		List<Person> people = new LinkedList<>();
		repository.findAll().forEach(people::add);
		
		if(lastPersonAdded!=null)
		{
			people.remove(lastPersonAdded);
			people.add(0, lastPersonAdded);
		}
		
		return people;
	}
	
	
	public void addPerson(Person p)
	{
		lastPersonAdded=p;
		repository.save(p);
	}


	public List<String> getAttributes() 
	{
		Field[] fields = Person.class.getDeclaredFields();
		List<String> attributes = new LinkedList<>();
		
		
		for(Field f : fields)
		{
			attributes.add(f.getName());
		}
		
		return attributes;
	}
	
}
