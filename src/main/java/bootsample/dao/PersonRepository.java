package bootsample.dao;

import org.springframework.data.repository.CrudRepository;

import bootsample.model.Person;

/**
 * The interface which puts information from the user into the Apache Derby database
 * 
 * @author Michael Shur
 *
 */
public interface PersonRepository extends CrudRepository<Person,String>{}
