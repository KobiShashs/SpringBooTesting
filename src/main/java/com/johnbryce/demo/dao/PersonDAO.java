package com.johnbryce.demo.dao;

import com.johnbryce.demo.beans.Forum;
import com.johnbryce.demo.beans.Person;
import com.johnbryce.demo.repo.ForumRepository;
import com.johnbryce.demo.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAO {

   @Autowired
   	private PersonRepository repo;

   	public long addPerson(Person p) {
   		if (p.getAge() >= 0 && p.getAge() <= 120) {
   			repo.save(p);
   			return p.getId();
   		}
   		return -999;
   	}

   	public Iterable<Person> getAll() {
   		return repo.findAll();
   	}

   	public Person getById(long id) {
   		return repo.findById(id).orElse(null);
   	}

   	public Iterable<Person> getPersonBetweenAges(int from, int to) {
   		return repo.findPersonBetweenAge(from, to);
   	}

   	public Iterable<Person> getPersonOlderThan(int from) {
   		return repo.findPersonsByAgeGreaterThan(from);
   	}
}
